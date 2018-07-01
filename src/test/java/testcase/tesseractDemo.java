package testcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class tesseractDemo {
    //WebDriver driver;

    @Test
    public void test() throws MalformedURLException {
        //System.setProperty("webdriver.chromedriver","../driver/chromedrivers/driver_2_21/chromedriver.exe");
        DesiredCapabilities dc = new DesiredCapabilities();
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");//无界面的web自动化，加快自动化效率
        //dc.setCapability(chromeOptions.CAPABILITY,chromeOptions);
        dc.setCapability("platformName","android");
        dc.setCapability("deviceName","sss");
        dc.setCapability("noReset",true);
        dc.setCapability("browserName","browser");
        dc.setCapability("chromedriverExecutableDir","D:\\temp-jar\\chromedriver\\2.20");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.110:4444/wd/hub"),dc);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.133:4444/wd/hub"),dc);

        driver.get("https://www.baidu.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();

    }
}
