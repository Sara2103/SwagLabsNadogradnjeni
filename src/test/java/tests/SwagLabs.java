package tests;

import excel_core.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.Map;


public class SwagLabs extends BaseTest{

    String url = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {

        init("Chrome", "95", 30);
        driver.get(url);
    }


    @Test
    public void login() throws IOException {

        Map<String,String> data = new ExcelUtils().getRowData("src/test/testData/TestData.xlsx", "Data", 1);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        LoginPage login = new LoginPage(driver, wait);

        login.enterUsername(data.get("Username"));
        login.enterPass(data.get("Password"));
        login.clickLogin();

        //hvatam sc
        reportScreenshot("Test", "TestAllure");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "PRODUCTS");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getAttribute("class"), "title");
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getCssValue("text-transform"), "uppercase");
    }

    @Test
    public void buyProduct() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        LoginPage l = new LoginPage(driver, wait);
        l.login("standard_user", "secret_sauce");
        //screenshot
        takeScreenshot("PosleLogina");


        InventoryPage inv = new InventoryPage(driver, wait);
        //1.resenje
        //inv.clickAddToCart(3);

        //2.resenje
        inv.clickAddToCart("3");
        inv.clickAddToCart("4");
        //inv.clickAddToCartByProductName("Sauce Labs Fleece Jacket");
        //inv.clickAddToCartByProductDesc("laptop");
        inv.clickCart();


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        CartPage cart = new CartPage(driver, wait);
        cart.clickCheckout();


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

        CheckOutStepsOnePage c1 = new CheckOutStepsOnePage(driver, wait);
        c1.enterFirstName("Sara");
        c1.enterLastName("Saric");
        c1.enterZip("13124");
        c1.clickContinue();

        //ILI zajedno
        //c1.fillCheckOutStepOneInfo("Sara", "Saric", "233");


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        CheckOutStepsTwoPage c2 = new CheckOutStepsTwoPage(driver, wait);
        c2.clickFinish();


        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(driver.findElement(By.cssSelector(".complete-header")).getText(), "THANK YOU FOR YOUR ORDER");

        CompletePage com = new CompletePage(driver,wait);
        com.clickBackHome();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }


    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
