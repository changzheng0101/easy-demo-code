package com.util;

import org.openqa.selenium.WebDriver;

/**
 * 有些场景和窗口，需要进行SwitchTo切换之后才可以进一步操作
 */
public class SwitchToUtil extends BaseUtil {
    protected static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }
}
