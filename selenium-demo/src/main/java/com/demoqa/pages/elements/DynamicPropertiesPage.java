package com.demoqa.pages.elements;

import com.util.GetUtil;
import com.util.WaitUtil;
import org.openqa.selenium.By;

public class DynamicPropertiesPage extends ElementsPage {

    private final By visibleAfterButton = By.id("visibleAfter");

    public String getVisibleAfterButtonText() {
        WaitUtil.explicitWaitUntilVisible(6, visibleAfterButton);
        return GetUtil.getWebElementText(visibleAfterButton);
    }

}
