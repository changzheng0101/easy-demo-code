package com.demoqa.pages.elements;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

public class ElementsPage extends HomePage {
    private final By webTablesMenuItem = By.xpath("//ul[@class='menu-list']//span[text()='Web Tables']");
    private final By linksMenuItem = By.xpath("//ul[@class='menu-list']//span[text()='Links']");
    private final By dynamicPropertiesMenuItem =
            By.xpath("//ul[@class='menu-list']//span[text()='Dynamic Properties']");
    private final By textBoxMenuItem = By.xpath("//ul[@class='menu-list']//span[text()='Text Box']");

    public WebTablesPage clickWebTables() {
        click(webTablesMenuItem);
        return new WebTablesPage();
    }

    public LinksPage clickLinks() {
        click(linksMenuItem);
        return new LinksPage();
    }

    public DynamicPropertiesPage clickDynamicProperties() {
        click(dynamicPropertiesMenuItem);
        return new DynamicPropertiesPage();
    }

    public TextBoxPage clickTextBox() {
        click(textBoxMenuItem);
        return new TextBoxPage();
    }
}
