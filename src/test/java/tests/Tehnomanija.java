package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Tehnomanija extends BaseTest{

    //String url = "https://www.tehnomanija.rs/";

    @BeforeMethod
    public void setUp() {
        init("Chrome", "96", 30);
        //driver.get(url);
    }


    @Test
    public void navigateMenu() throws InterruptedException {
        driver.get("https://www.tehnomanija.rs/");
        wait = new WebDriverWait(driver, 30);

        //hover
        Actions act = new Actions(driver);
        act
                .moveToElement(driver.findElement(By.cssSelector(".category-menu.js-category-menu")))
                .moveToElement(driver.findElement(By.xpath("//a[normalize-space()='BELA TEHNIKA']")))
                .build().perform(); //hover ne moze bez ovoga, ovo izvrsava hover
        driver.findElement(By.cssSelector("a[title='Mini frižideri']")).click();

        Thread.sleep(5000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
        wait = new WebDriverWait(driver, 30);

        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));

        //drag & drop
        Actions act = new Actions(driver);
        act.dragAndDrop(driver.findElement(By.xpath("//ul[@id='gallery']/li[3]")), driver.findElement(By.xpath("//div[@id='trash']"))).build().perform();

        //rucni d%d kad ovaj gore ne radi
        act
                .clickAndHold(driver.findElement(By.xpath("//ul[@id='gallery']/li[3]")))
                .moveToElement(driver.findElement(By.xpath("//div[@id='trash']")))
                .release(driver.findElement(By.xpath("//div[@id='trash']")))
                .build().perform();

        Thread.sleep(5000);
    }

    @Test
    public void checkElement() throws InterruptedException {
        driver.get("https://www.tehnomanija.rs/");
        wait = new WebDriverWait(driver, 30);

        //hover
        Actions act = new Actions(driver);
        act
                .moveToElement(driver.findElement(By.cssSelector(".category-menu.js-category-menu")))
                .moveToElement(driver.findElement(By.xpath("//a[normalize-space()='TELEFONIJA']")))
                .build().perform();
        driver.findElement(By.cssSelector("a[title='Nokia']")).click();

        //check 2 option: android, bela
        driver.findElement(By.cssSelector("#mCSB_3_container > li:nth-child(2)")).click(); //.operativni-sistemandroid
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='mCSB_5_container']/li[7]")).click();

        //find price and save
        WebElement priceOne = driver.findElement(By.xpath("//*[@class='price' and contains(text(),'11.988')]"));

        //click on the first phone
        driver.findElement(By.xpath("//div[@class='products-wrap']/div/div[1]"));


        Thread.sleep(5000);
    }



    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
