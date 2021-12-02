package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompletePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public CompletePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#back-to-products")
    WebElement backHomeBtn;


    public void clickBackHome() {
        click(backHomeBtn);
    }

}
