package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.util.ActionUtil.*;
import static com.util.GetUtil.*;
import static com.util.JavaScriptUtil.*;
import static com.util.WaitUtil.*;

public class TextBoxPage extends ElementsPage {
    private final By fullNameField = By.id("userName");
    private final By currentAddressField = By.xpath("//textarea[@id='currentAddress']");
    private final By submitButton = By.id("submit");
    private final By currentAddressResult = By.xpath("//p[@id='currentAddress']");

    public String getCurrentAddress() {
        explicitWaitUntilVisible(5, currentAddressResult);
        return getWebElementText(currentAddressResult);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void setFullName(String fullName) {
        scrollToElementJS(fullNameField);
        sendKeys(find(fullNameField), Keys.chord(fullName));
    }

    public void setCurrentAddress(String address) {
        sendKeys(find(currentAddressField), address + Keys.ENTER);
    }

    public void setEmail(String email) {
        setFullName(Keys.chord(Keys.TAB, email));
    }
}
