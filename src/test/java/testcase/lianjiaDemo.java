package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class lianjiaDemo {
    public static void main(String[] args) throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "/src/test/java/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hz.lianjia.com/");
        driver.findElement(By.id("keyword-box")).sendKeys("翠苑三区");
//        driver.findElement(By.id("findHouse")).click();
        driver.findElement(By.id("keyword-box")).clear();
        driver.findElement(By.id("keyword-box")).sendKeys("望京");
        Thread.sleep(3000);
        driver.quit();
    }

}
