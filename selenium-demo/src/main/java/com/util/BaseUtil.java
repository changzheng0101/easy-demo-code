package com.util;

import org.openqa.selenium.WebDriver;

public class BaseUtil {
    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BaseUtil.driver = driver;
    }
}
