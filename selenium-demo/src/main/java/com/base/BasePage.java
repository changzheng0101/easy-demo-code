package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.util.JavaScriptUtil.scrollToElementJS;

public class BasePage {
    public static WebDriver driver;

    public static void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By by) {
        return driver.findElement(by);
    }

    protected void setText(By by, String text) {
        find(by).clear();
        find(by).sendKeys(text);
    }

    protected void click(By by) {
        scrollToElementJS(by);
        find(by).click();
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
