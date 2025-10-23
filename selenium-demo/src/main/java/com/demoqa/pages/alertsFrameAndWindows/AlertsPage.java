package com.demoqa.pages.alertsFrameAndWindows;

import org.openqa.selenium.By;

import static com.util.GetUtil.getWebElementText;

public class AlertsPage extends AlertsFrameAndWindowsPage {
    private final By informationAlertButton = By.id("alertButton");
    private final By confirmAlertButton = By.id("confirmButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptAlertButton = By.id("promtButton");
    private final By promptResult = By.id("promptResult");

    public void clickInformationAlertButton() {
        click(informationAlertButton);
    }

    public void clickConfirmAlertButton() {
        click(confirmAlertButton);
    }

    public String getConfirmResult() {
        return getWebElementText(confirmResult);
    }

    public void clickPromptAlertButton() {
        click(promptAlertButton);
    }

    public String getPromptResult() {
        return getWebElementText(promptResult);
    }
}
