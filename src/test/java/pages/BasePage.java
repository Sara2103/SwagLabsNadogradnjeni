package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String waitTime = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("waitTime");

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver, this);
    }

    //univerzalne metode

    public void click(WebElement element) {

        wait = new WebDriverWait(driver, Integer.parseInt(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Actions a = new Actions(driver);
            a.moveToElement(element).build().perform();

            element.click();
        } catch (StaleElementReferenceException e) {

            Actions a = new Actions(driver);
            a.moveToElement(element).build().perform();

            element.click();
        }
    }

    public void selectByVisibleText(WebElement element, String value) {
        try {
            if (value != null) {
                Select s = new Select(element);
                s.selectByVisibleText(value);
            } else {
                System.out.println("Parameter was null!");
            }
        } catch (StaleElementReferenceException e) {
            if (value != null) {
                Select s = new Select(element);
                s.selectByVisibleText(value);
            } else {
                System.out.println("Parameter was null!");
            }
        }
    }

    public void selectByValue(WebElement element, String value) {
        try {
            if (value != null) {
                Select s = new Select(element);
                s.selectByValue(value);
            } else {
                System.out.println("Parameter was null!");
            }
        } catch (StaleElementReferenceException e) {
            if (value != null) {
                Select s = new Select(element);
                s.selectByValue(value);
            } else {
                System.out.println("Parameter was null!");
            }
        }
    }

    public void enterText(WebElement element, String txt) {

        //System.out.println("Unosim: "+txt); //za pracanje metoda mozemo ovo da stavimo

        wait = new WebDriverWait(driver, Integer.parseInt(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            if (txt != null) {
                element.clear();
                element.sendKeys(txt);
            } else {
                System.out.println("Parameter was null!");
            }
        } catch (StaleElementReferenceException e) {
            if (txt != null) {
                element.clear();
                element.sendKeys(txt);
            } else {
                System.out.println("Parameter was null!");
            }
        }
    }

    public void assertEquals(WebElement element, String expectedValue) {
        wait = new WebDriverWait(driver, Integer.parseInt(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Assert.assertEquals(element.getText(), expectedValue);
        } catch (StaleElementReferenceException e) {
            Assert.assertEquals(element.getText(), expectedValue);
        }
    }

    //SCREENSHOT
    public void takeScreenshot(String fileName) throws IOException {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("src/screenshot/" + fileName + "_" + System.currentTimeMillis() + ".png"));
    }

    //cao SM
}

