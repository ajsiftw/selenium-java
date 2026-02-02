package pages;

import utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import java.nio.file.Paths;
import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(
                ConfigReader.getIntProperty("explicitWait")));
    }

    // ---------- UTILS ---------- //

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    protected void uploadFile(By locator) {
        WebElement upload = waitForClickable(locator);
        upload.sendKeys(Paths.get("src/test/resources/testdata/picture.jpg")
                .toAbsolutePath()
                .toString());
    }

    // ---------- WAITS ---------- //

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ---------- CLICKS ---------- //

    protected void normalClick(By locator) {
        WebElement element = waitForClickable(locator);
        element.click();
    }

    protected void jsClick(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", element
        );
    }

    protected void click(By locator) {
        try {
            scrollIntoView(locator);
            normalClick(locator);
        } catch (ElementClickInterceptedException e) {
            jsClick(locator);
        }
    }

    // ---------- SCROLLS ---------- //

    protected void scrollIntoView(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", element
        );
    }

    // ---------- TEXTS ---------- //

    protected void enterText(By locator, String text) {
        WebElement element = waitForClickable(locator);
        element.sendKeys(text);
    }

    protected void enterTextPressEnter(By locator, String text) {
        WebElement element = waitForClickable(locator);
        element.sendKeys(text, Keys.ENTER);
    }

    // ---------- SELECTS ---------- //

    protected void selectByVisibleText(By locator, String text) {
        WebElement dropdownElement = waitForClickable(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(text);
    }

    protected void selectByIndex(By locator, int index) {
        WebElement dropdownElement = waitForClickable(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    protected void selectByValue(By locator, String value) {
        WebElement dropdownElement = waitForClickable(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

}