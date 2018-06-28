package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class FindElement {

    public WebElement findCurrentElement(String findway,String locator){
        WebElement ele = null;
        WebDriver driver = new ChromeDriver();
        switch (findway) {
            case "id":
                ele = driver.findElement(By.id(locator));
                break;
            case "xpath":
                ele = driver.findElement(By.xpath(locator));
                break;
            case "css":
                ele = driver.findElement(By.cssSelector(locator));
                break;
            case "partialLinkText":
                ele = driver.findElement(By.partialLinkText(locator));
                break;
            case "className":
                ele = driver.findElement(By.className(locator));
            default:
                Reporter.log("没有找到相应的定位方法---" + findway);
                break;
        }

        return ele;
    }
}
