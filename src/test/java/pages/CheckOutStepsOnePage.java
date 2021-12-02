package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutStepsOnePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckOutStepsOnePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        //za svaki Page pravim uvek ove tri vrednosti
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this); //kad koristim PF mogu da koristim njegove anotacije za pronalazak elemenata
    }

    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement zip;
    @FindBy(css = "#continue")
    WebElement continueBtn;


    public void enterFirstName(String txt) {
        enterText(firstName, txt);
    }

    public void enterLastName(String txt) {
        enterText(lastName, txt);
    }

    public void enterZip(String txt) {
        enterText(zip, txt);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    //zajedno sve
    public void fillCheckOutStepOneInfo(String txtFirst, String txtLast, String txtZip) {
        enterFirstName(txtFirst);
        enterLastName(txtLast);
        enterZip(txtZip);
        clickContinue();
    }
}
