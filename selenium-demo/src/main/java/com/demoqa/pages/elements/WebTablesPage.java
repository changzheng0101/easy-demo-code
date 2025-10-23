package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class WebTablesPage extends ElementsPage {
    private final By registrationAgeField = By.id("age");
    private final By registrationSubmitButton = By.id("submit");

    public void clickEdit(String email) {
        By editButton = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']");
        click(editButton);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void clickSubmitButton() {
        click(registrationSubmitButton);
    }


    public String getTableAge(String email) {
        By tableAge = By.xpath("//div[text()='" + email + "']//preceding::div[1]");
        return find(tableAge).getText();
    }
}
