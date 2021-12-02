package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutStepsTwoPage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckOutStepsTwoPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#finish")
    WebElement finishBtn;


    public void clickFinish() {
        click(finishBtn);
    }
}