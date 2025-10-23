package com.demoqa.pages.alertsFrameAndWindows;

import org.openqa.selenium.By;

import java.util.Set;

import static com.util.WindowUtil.switchToWindow;

public class BrowserWindowsPage extends AlertsFrameAndWindowsPage {

    private final By newWindowsButton = By.id("windowButton");

    public void clickNewWindowButton() {
        click(newWindowsButton);
    }

    public void switchToNewWindow() {
        // Step 1: Get The Current "Main" Window Handle
        String currentHandle = driver.getWindowHandle();
        System.out.println("Main Window ID: " + currentHandle + "\n");

        // Step 2: Get All Window Handles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("Open Windows: " + allHandles.size());

        // Step 3: Switch To The New Window Using The Window Handle
        for (String handle : allHandles) {
            if (currentHandle.equals(handle)) {
                System.out.println("1st Window ID: " + handle);
            } else {
                switchToWindow(handle);
                System.out.println("2nd Window ID: " + handle);
            }
        }
    }
}
