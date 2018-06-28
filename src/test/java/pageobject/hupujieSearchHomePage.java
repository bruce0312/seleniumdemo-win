package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hupujieSearchHomePage {
    @FindBy(id = "showfoucs1")
    public WebElement searchBox;

    @FindBy(className = "btn-searchs")
    public WebElement SearchBtn;

    public hupujieSearchHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


}