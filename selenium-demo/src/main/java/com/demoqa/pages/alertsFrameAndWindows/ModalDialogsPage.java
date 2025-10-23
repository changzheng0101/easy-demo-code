package com.demoqa.pages.alertsFrameAndWindows;

import org.openqa.selenium.By;

public class ModalDialogsPage extends AlertsFrameAndWindowsPage {
    private final By smallModalButton = By.xpath("//button[text()='Small modal']");
    private final By smallModalText = By.xpath("//div[@class='modal-body']");
    private final By smallModalCloseButton = By.xpath("//div[@class='modal-header']//span[@aria-hidden='true']");

    public void clickSmallModalButton() {
        click(smallModalButton);
    }

    public String getSmallModalText() {
        return find(smallModalText).getText();
    }

    public void clickSmallModalCloseButton() {
        click(smallModalCloseButton);
    }
}
