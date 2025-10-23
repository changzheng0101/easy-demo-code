package com.demoqa.pages.widgets;

import com.util.DropDownUtil;
import org.openqa.selenium.By;

import java.util.List;

public class SelectMenuPage extends WidgetsPage {
    private final By standardMultiSelect = By.id("cars");

    public void selectStandardMulti(String text) {
        DropDownUtil.selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMulti(int index) {
        DropDownUtil.selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value) {
        DropDownUtil.deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedOptions() {
        return DropDownUtil.getAllSelectedOptions(standardMultiSelect);
    }
}
