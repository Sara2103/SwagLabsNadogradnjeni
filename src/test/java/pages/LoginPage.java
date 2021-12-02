package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //lociranje elemenata
    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement login;


    public void enterUsername(String txt) {
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(username))); ako hocu nesto da sacekam pre upisa username to se ceka ovde, na nivou tog page-a i tog elementa
        enterText(username, txt);
    }

    public void enterPass(String txt) {
        enterText(password, txt);
    }

    public void clickLogin() {
        click(login);
    }

    //sve zajedno, kad god mi treba login ja pozovem ovu metodu, a ne ove sitne gore, njih koristim samo prvi put, a to sam vec pisala
    public void login(String username, String pass){
        enterUsername(username);
        enterPass(pass);
        clickLogin();
    }
}
