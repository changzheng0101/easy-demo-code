package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class LinksPage extends ElementsPage {
    private final By badRequestLink = By.id("bad-request");
    private final By response = By.id("linkResponse");

    public void clickBadRequestLink() {
        click(badRequestLink);
    }

    public String getResponse() {
        delay(1000);
        return find(response).getText();
    }
}
