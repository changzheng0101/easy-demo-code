package com.util;

import org.openqa.selenium.By;

public class GetUtil extends BaseUtil {
    public static String getWebElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getWebElementAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public static String getURL() {
        return driver.getCurrentUrl();
    }
}
