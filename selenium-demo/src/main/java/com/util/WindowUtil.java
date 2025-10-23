package com.util;

public class WindowUtil extends SwitchToUtil {

    public static void switchToWindow(String handle) {
        switchTo().window(handle);
    }
}
