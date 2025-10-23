package com.saucedemo.pages;

import com.base.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private final By productsHeader =
            By.xpath("//div[@class='header_secondary_container']//span[@class='title']");

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }
}
