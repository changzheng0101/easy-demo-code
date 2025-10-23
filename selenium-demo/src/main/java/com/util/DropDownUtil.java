package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * dropdown的工具类，可以根据visible text、value和index来进行选择
 * e.g. `<option value="opel">Opel</option>`
 * visible text => Opel
 * value        => opel
 * index start from 0
 */
public class DropDownUtil extends BaseUtil {

    private static Select findDropDown(By by) {
        return new Select(driver.findElement(by));
    }

    public static void selectByVisibleText(By locator, String text) {
        findDropDown(locator).selectByVisibleText(text);
    }

    public static void selectByIndex(By locator, int index) {
        findDropDown(locator).selectByIndex(index);
    }

    public static void selectByValue(By locator, String value) {
        findDropDown(locator).selectByValue(value);
    }

    public static void deselectByValue(By locator, String value) {
        findDropDown(locator).deselectByValue(value);
    }

    public static List<String> getAllSelectedOptions(By locator) {
        List<WebElement> allSelectedOptions =
                findDropDown(locator).getAllSelectedOptions();
        return allSelectedOptions.stream().
                map(WebElement::getText).collect(Collectors.toList());
    }
}
