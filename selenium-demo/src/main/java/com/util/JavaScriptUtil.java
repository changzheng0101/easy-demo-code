package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * 有些操作无法通过api来完成
 * 通过调用JavaScript来实现
 */
public class JavaScriptUtil extends BaseUtil {

    public static void scrollToElementJS(By by) {
        WebElement element = driver.findElement(by);
        String jsScript = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(jsScript, element);
    }

    public static void clickJS(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }
}
