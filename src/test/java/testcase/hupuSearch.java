package testcase;

import methods.ReadFromExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.hupujieSearchHomePage;

public class hupuSearch {
    WebDriver driver;
    WebDriverWait wait;
    private String excelPath = "../../resources/hupudata.xlsx";
    private String baseUrl = "https://bbs.hupu.com/all-gambia";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chromedriver","../driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(dataProvider = "dataInExcel")
    public void doSearch(){

    }

    @Test(priority = 0)
    public void hupuSearchPO(){
        hupujieSearchHomePage hpSearchPO = new hupujieSearchHomePage(driver);
        hpSearchPO.searchBox.clear();
        hpSearchPO.searchBox.sendKeys("德国");
        hpSearchPO.SearchBtn.click();

        String currentHandle = driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(handle.equals(currentHandle)){
                continue;
            }
            driver.switchTo().window(handle);
        }


    }

    @Test(priority = 1)
    public void hupuResultPO(){

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    @DataProvider(name = "dataInExcel")
    public Object[][] dataInExcel() throws Exception {
        Object[][] getDataFromExcel;
        ReadFromExcel readFromExcel = new ReadFromExcel();
        getDataFromExcel = readFromExcel.getDataFromExcel(excelPath);
        return getDataFromExcel;
    }
}
