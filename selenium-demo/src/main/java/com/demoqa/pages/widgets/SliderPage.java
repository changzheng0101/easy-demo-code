package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static com.util.ActionUtil.dragAndDrop;
import static com.util.GetUtil.getWebElementAttribute;

public class SliderPage extends WidgetsPage {
    private final By slider = By.xpath("//input[@type='range']");
    private final By sliderValue = By.id("sliderValue");

    public String getSliderValue() {
        return getWebElementAttribute(sliderValue, "value");
    }

    public void moveSlider(int y) {
        dragAndDrop(find(slider), 0, y);
    }
}
