package com.demoqa.pages;

import com.base.BasePage;
import com.demoqa.pages.alertsFrameAndWindows.AlertsFrameAndWindowsPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.forms.FormsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By formsCard = By.xpath("//h5[text()='Forms']");
    private final By elementsCard = By.xpath("//h5[text()='Elements']");
    private final By widgetsCard = By.xpath("//h5[text()='Widgets']");
    private final By alertsFrameAndWindowsCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");

    public FormsPage goToForms() {
        click(formsCard);
        return new FormsPage();
    }


    public ElementsPage goToElementsPage() {
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgetsPage() {
        click(widgetsCard);
        return new WidgetsPage();
    }

    public AlertsFrameAndWindowsPage goToAlertsFrameAndWindows() {
        click(alertsFrameAndWindowsCard);
        return new AlertsFrameAndWindowsPage();
    }
}

