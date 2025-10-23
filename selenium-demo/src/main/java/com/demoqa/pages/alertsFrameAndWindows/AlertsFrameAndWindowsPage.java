package com.demoqa.pages.alertsFrameAndWindows;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

public class AlertsFrameAndWindowsPage extends HomePage {

    private final By modalDialogsMenuItem = By.xpath("//span[text()='Modal Dialogs']");
    private final By alertsMenuItem = By.xpath("//span[text()='Alerts']");
    private final By framesMenuItem = By.xpath("//span[text()='Frames']");
    private final By browserWindowsMenuItem = By.xpath("//span[text()='Browser Windows']");


    public ModalDialogsPage clickModalDialogs() {
        click(modalDialogsMenuItem);
        return new ModalDialogsPage();
    }

    public AlertsPage clickAlerts() {
        click(alertsMenuItem);
        return new AlertsPage();
    }

    public FramesPage clickFrames() {
        click(framesMenuItem);
        return new FramesPage();
    }

    public BrowserWindowsPage clickBrowserWindows() {
        click(browserWindowsMenuItem);
        return new BrowserWindowsPage();
    }
}
