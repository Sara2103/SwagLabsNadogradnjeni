package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    /* mogu da proverim: - da li su proizvodi u korpi isti kao sa prethodne stranice
                         - da li radi dugme REMOVE/ CONTINUTE SHOPPING (pa da dodam nesto drugo)
                         - zavrsetak kupovine dugme CHECKOUT itd.
     */

    @FindBy(css = "#checkout")
    WebElement checkoutBtn;

    public void clickCheckout(){
        click(checkoutBtn);
    }
}
