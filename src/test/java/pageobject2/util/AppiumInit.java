package pageobject2.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumInit {
    //android init
    String platformNameAndroid = "Android";
    String deviceNameAndroid = "xxx";
    String appPackageName = "com.xueqiu.android";
    String appActivity = ".view.WelcomeActivityAlias";
    String automationAndroid = "uiautomator2";

    //ios init
    String platformNameIos = "iOS";
    String platformVersion = "11.2";
    String deviceNameIos = "iPhone 8";
    String appPath = "/Users/bruce/Library/Developer/Xcode/DerivedData/UICatalog-cpgabmyboblgwffdjmlsfcowvgcy/Build/Products/Debug-iphonesimulator/UICatalog.app";
    String bundleId = "com.example.apple-samplecode.UICatalog";
    String automationIos = "XCUITest";

    //appium远程地址
    String baseUrl = "https://127.0.0.1:4723/wd/hub";

    AndroidDriver driver1;
    IOSDriver driver2;

    public void desiredCapAndroid() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName",platformNameAndroid);
        dc.setCapability("deviceName",deviceNameAndroid);
        dc.setCapability("appPackage",appPackageName);
        dc.setCapability("appActivity",appActivity);
        dc.setCapability("uiAutomation",automationAndroid);
        dc.setCapability("noReset",true);
        dc.setCapability("resetKeyboard",true);
        dc.setCapability("unicodeKeyboard",true);

        URL remoteUrl = new URL(baseUrl);
        driver1 = new AndroidDriver(remoteUrl,dc);
        driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void desiredCapIos() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platform",platformNameIos);
        dc.setCapability("platformVersion",platformVersion);
        dc.setCapability("deviceName",deviceNameIos);
        dc.setCapability("app",appPath);
        dc.setCapability("uiAutomation",automationIos);

        URL remoteUrl = new URL(baseUrl);
        driver2 = new IOSDriver(remoteUrl,dc);
        driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
