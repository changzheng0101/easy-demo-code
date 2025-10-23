package com.util;

import org.openqa.selenium.WebElement;

public class FrameUtil extends SwitchToUtil {

    public static void switchToFrameWithString(String nameOrId) {
        switchTo().frame(nameOrId);
    }

    public static void switchToFrameWithWebElement(WebElement frameElement) {
        switchTo().frame(frameElement);
    }

    public static void switchToDefaultContent() {
        switchTo().defaultContent();
    }
}
