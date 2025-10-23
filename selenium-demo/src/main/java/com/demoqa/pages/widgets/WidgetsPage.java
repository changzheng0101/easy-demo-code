package com.demoqa.pages.widgets;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;


public class WidgetsPage extends HomePage {
    private final By selectMenuItem = By.xpath("//ul[@class='menu-list']//span[text()='Select Menu']");
    private final By datePickerMenuItem = By.xpath("//ul[@class='menu-list']//span[text()='Date Picker']");
    private final By progressBarMenuItem =
            By.xpath("//ul[@class='menu-list']//span[text()='Progress Bar']");
    private final By sliderMenuItem =
            By.xpath("//ul[@class='menu-list']//span[text()='Slider']");

    public SelectMenuPage clickSelectMenu() {
        click(selectMenuItem);
        return new SelectMenuPage();
    }

    public DatePickerPage clickDatePicker() {
        click(datePickerMenuItem);
        return new DatePickerPage();
    }

    public ProgressBarPage clickProgressBar() {
        click(progressBarMenuItem);
        return new ProgressBarPage();
    }

    public SliderPage clickSlider() {
        click(sliderMenuItem);
        return new SliderPage();
    }
}
