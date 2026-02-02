package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = ConfigReader.getIntProperty("defaultTimeout");      // seconds
    private static final int DEFAULT_POLLING = ConfigReader.getIntProperty("defaultPolling");      // milliseconds

    private WaitUtils() {
    }

    private static FluentWait<WebDriver> getWait(WebDriver driver, int timeoutInSeconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // ---------- VISIBILITY ---------- //

    public static WebElement waitUntilVisible(WebDriver driver, WebElement element) {
        return waitUntilVisible(driver, element, DEFAULT_TIMEOUT);
    }

    public static WebElement waitUntilVisible(
            WebDriver driver, WebElement element, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator) {
        return waitUntilVisible(driver, locator, DEFAULT_TIMEOUT);
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ---------- CLICKABLE ---------- //

    public static WebElement waitUntilClickable(WebDriver driver, WebElement element) {
        return waitUntilClickable(driver, element, DEFAULT_TIMEOUT);
    }

    public static WebElement waitUntilClickable(
            WebDriver driver, WebElement element, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator) {
        return waitUntilClickable(driver, locator, DEFAULT_TIMEOUT);
    }

    public static WebElement waitUntilClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ---------- INVISIBILITY ---------- //

    public static boolean waitUntilInvisible(WebDriver driver, WebElement element) {
        return waitUntilInvisible(driver, element, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilInvisible(
            WebDriver driver, WebElement element, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean waitUntilInvisible(WebDriver driver, By locator) {
        return waitUntilInvisible(driver, locator, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // ---------- TEXT ---------- //

    public static boolean waitUntilTextPresent(
            WebDriver driver, WebElement element, String text) {
        return waitUntilTextPresent(driver, element, text, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilTextPresent(
            WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean waitUntilTextPresent(
            WebDriver driver, By locator, String text) {
        return waitUntilTextPresent(driver, locator, text, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilTextPresent(
            WebDriver driver, By locator, String text, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // ---------- ATTRIBUTE ---------- //

    public static boolean waitUntilAttributeContains(
            WebDriver driver, WebElement element, String attribute, String value) {
        return waitUntilAttributeContains(driver, element, attribute, value, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilAttributeContains(
            WebDriver driver, WebElement element, String attribute,
            String value, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static boolean waitUntilAttributeContains(
            WebDriver driver, By locator, String attribute, String value) {
        return waitUntilAttributeContains(driver, locator, attribute, value, DEFAULT_TIMEOUT);
    }

    public static boolean waitUntilAttributeContains(
            WebDriver driver, By locator, String attribute, String value, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    // ---------- PRESENCE (DOM only) ---------- //

    public static WebElement waitUntilPresent(WebDriver driver, By locator) {
        return waitUntilPresent(driver, locator, DEFAULT_TIMEOUT);
    }

    public static WebElement waitUntilPresent(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
