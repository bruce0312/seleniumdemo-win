package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hupujieSearchHomePage {
    @FindBy(id = "showfoucs1")
    private WebElement searchBox;

    @FindBy(className = "btn-searchs")
    private WebElement SearchBtn;

    public hupujieSearchHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doSearch(){
        searchBox.clear();
        searchBox.sendKeys("德国");
        SearchBtn.click();
    }


}