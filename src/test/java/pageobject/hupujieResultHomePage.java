package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hupujieResultHomePage {
    //切换至“日志”搜索结果
    @FindBy(xpath = "//*[@id='search_main']//a[contains(text(),'日志')]")
    private WebElement rizhiBtn;

    @FindBy(className = "page")
    private WebElement assertZone;

    public hupujieResultHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
