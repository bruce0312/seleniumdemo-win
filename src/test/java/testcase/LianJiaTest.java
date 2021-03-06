package testcase;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LianJiaTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://www.lianjia.com/";
    private String excelPath = "./src/test/resources/DataProvider.xlsx";
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //@Test(dataProvider = "getSearchData")
    @Test(dataProvider = "useExcelData")
    public void searchCity(String SearchKey){
        driver.get(baseUrl);
        //WebElement text = driver.findElement(By.partialLinkText(SearchKey));
        WebElement searchBox = driver.findElement(By.id("keyword-box"));
        WebElement findHouse = driver.findElement(By.id("findHouse"));
        searchBox.clear();
        searchBox.sendKeys(SearchKey);
        findHouse.click();
        By expectedElement = By.xpath("//*[@class='title']//*[contains(text(),'" + SearchKey + "')]");
        wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        //System.out.println(text.getLocation());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(expectedElement));
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("./src/test/resources/" + SearchKey + ".png"));
        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    @DataProvider(name = "original_way")
    public static Object[][] getSearchData(){
        Object[][] o = new Object[4][1];
        o[0][0] = "新龙城";
        o[1][0] = "天通苑";
        o[2][0] = "北京新天地";
        o[3][0] = "望京";
        return o;
    }

//    @DataProvider(name = "useExcelData")
//    public Object[][] getData() throws Exception{
//        return getDataFromExcel("./src/test/resources/DataProvider.xlsx");
//    }

    @DataProvider(name = "useExcelData")
    public Object[][] getDataFromExcel() throws Exception {
        Workbook workbook;
        try(FileInputStream excelInputStream = new FileInputStream("./src/test/resources/DataProvider.xlsx")){
            workbook = new XSSFWorkbook(excelPath);
        }
        Sheet sheet = workbook.getSheetAt(0);
        int rowInExcel = sheet.getPhysicalNumberOfRows();
        int colInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] obj = new Object[rowInExcel-1][colInExcel];
        for(int row=1;row<rowInExcel;row++){
            for(int col=0;col<colInExcel;col++){
                obj[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                System.out.println(obj[row-1][col]);
            }
        }
        return obj;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
