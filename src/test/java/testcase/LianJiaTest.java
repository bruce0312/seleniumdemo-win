package testcase;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LianJiaTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.lianjia.com/";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void logIn(){
        driver.get(baseUrl);
        WebElement text = driver.findElement(By.partialLinkText("漳州"));
        System.out.println(text.getLocation());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",text);
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("./src/test/java/resources/web.png"));
        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
