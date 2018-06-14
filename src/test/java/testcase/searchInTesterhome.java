package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class searchInTesterhome {
    public static void main(String[] args) throws InterruptedException {


        String chromePath = System.getProperty("user.dir")+"/src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        //System.setProperty("webdriver.chrome.driver","./src/test/java/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testerhome.com");
        //System.out.println(driver.getPageSource());
        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).getText();
        driver.findElement(By.name("q")).getAttribute("name");
        driver.findElement(By.name("q")).getSize();
        driver.findElement(By.name("q")).getTagName();
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        String chromePath = System.getProperty("user.dir")+"/src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchSelenium(){
        driver.get("https://testerhome.com");
        System.out.println(driver.getWindowHandle());
        String currentHandle = driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
            }
        }


        driver.findElement(By.name("q")).sendKeys("selenium");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        boolean actualText = driver.findElement(By.className("media-heading")).isDisplayed();
        Assert.assertTrue(actualText,"搜索失败");
    }

    @Test
    public void advancedApi(){
        driver.switchTo().window(driver.getWindowHandle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
