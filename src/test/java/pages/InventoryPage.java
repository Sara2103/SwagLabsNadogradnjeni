package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //2. resenje da spakujem u String i da koristim Replace metodu
    String addToCartButton = "//div[@class='inventory_list']/div[$]//button";
    String addToCartByProductName= "//div[@class='inventory_list']//div[text()='$']/../../..//button"; //$ je promenljiva koja nosi ime proizvoda-gledaj naslov proizovda na UI
    String addToCartByProductDescription = "//div[contains(text(), '$')]/../..//button";  // //da pronadje deo teksta u opisu proizvoda

    /*ne koristim ID kod kupovine, jer je to zapravo 3.element a ja zelim bas taj proizvod, a to nije njegov ID vec od dugmeta 3.elementa
    prvo uzimam jedan el. koji pokriva sve proizvode -> inventory_list jer on ima svih 6 proizvoda //div[@class='inventory_list']/div[3]
    sa /div ulazim u elemente ispod; sa [3] kazem koji tacno zelim; ako napisem //div[@class='inventory_list']/div[3]//button to znaci daj mi button/cenu/tekst koji je negde u tom d
    ivu, ovo radi samo kad imas jedan takav el. ili iskljucivo samo preko imena KLASE, nikako ID ili NAME*/

    //da ne bih prosledjivala kao malopre sve el posebno jer moze da postoji 200 proizvoda, pravim metodu i prosledim joj koji el hocu
    //1. resenje
//    public void clickAddToCart(int i){
//        driver.findElement(By.xpath("//div[@class='inventory_list']/div["+i+"]//button")).click();
//    }


    //2.resenje - replace menja karakter sa nekim drugim karakterom, ali taj koji menjam stavim da bude specifican da se slucajno ne bi ponovio jos negde u stringu
    public void clickAddToCart(String i){
        driver.findElement(By.xpath(addToCartButton.replace("$", i))).click();
    }

    public void clickAddToCartByProductName(String name){
        driver.findElement(By.xpath(addToCartByProductName.replace("$", name))).click();
    }

    public void clickAddToCartByProductDesc(String desc){
        driver.findElement(By.xpath(addToCartByProductDescription.replace("$", desc))).click();
    }

    @FindBy(css = "#shopping_cart_container")
    WebElement cart;


    public void clickCart(){
        click(cart);
    }
}
