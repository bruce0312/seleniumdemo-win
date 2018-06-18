package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginBos {
    private WebDriver driver ;
    private WebDriverWait wait;
    final private static int WAIT_TIME = 5;
    final private static String USER_NAME = "15012341234";
    final private static String PASSWORD = "222";


    @BeforeClass
    public void setUp(){
        String chromePath = System.getProperty("user.dir") + "/src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        //System.setProperty("jna.library.path","./src/test/resources/tessdata/dlls");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void once() throws InterruptedException {
        driver.get("https://bos-admin-test.kkjiaju.net/login");
        driver.findElement(By.cssSelector("#loginname")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        WebElement img = driver.findElement(By.id("CAPTCHA"));
        String captcha = new GetCode().getValidateCode(driver,img);
        driver.findElement(By.id("validateCode")).clear();
        driver.findElement(By.id("validateCode")).sendKeys(captcha);
        Thread.sleep(5000);
    }

    @Test
    public void logIn() throws Exception {
        System.out.println("begin to login");
        driver.get("https://bos-admin-test.kkjiaju.net/login");
        driver.findElement(By.cssSelector("#loginname")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        //TODO 识别验证码并自动输入
        WebElement img = driver.findElement(By.id("CAPTCHA"));
        String captcha = new GetCode().getValidateCode(driver,img);
        driver.findElement(By.id("validateCode")).clear();
        driver.findElement(By.id("validateCode")).sendKeys(captcha);
        //driver.findElement(By.xpath("//input[@value='登录']")).click();
        try {
            if(!driver.findElement(By.xpath("//li[@class='role']//span")).isDisplayed()){
                System.out.println("登录成功");
                logIn();
            }
        }catch (Exception e){
            System.out.println("未成功识别验证码，重新登录");
            e.printStackTrace();
            logIn();
        }
        //driver.findElement(By.xpath("//input[@value='登录']")).click();
        wait = new WebDriverWait(driver,WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='role']//span")));
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='role']//span")).isDisplayed(),"登录成功后页面跳转失败");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
