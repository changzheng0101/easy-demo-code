package com.demoqa.pages.widgets;

import org.openqa.selenium.By;

import static com.util.DropDownUtil.*;


public class DatePickerPage extends WidgetsPage {
    private final By dateInput = By.id("datePickerMonthYearInput");
    private final By yearDropDown = By.className("react-datepicker__year-select");
    private final By monthDropDown = By.className("react-datepicker__month-select");

    private By dayValue(String day) {
        return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--')]" +
                "[text()='" + day + "']");
    }

    public void clickDateInput() {
        click(dateInput);
    }

    public void selectYear(String year) {
        selectByVisibleText(yearDropDown, year);
    }

    public void selectMonth(String month) {
        selectByVisibleText(monthDropDown, month);
    }

    public void clickDay(String day) {
        click(dayValue(day));
    }

    public String getDate() {
        return find(dateInput).getAttribute("value");
    }
}
