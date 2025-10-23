package part3.tests.widgets;

import com.demoqa.pages.widgets.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class DateTest extends BaseTest {

    @Test
    public void testSelectDate() {
        DatePickerPage datePickerPage = homePage.goToWidgetsPage().clickDatePicker();
        String month = "December";
        String monthNumber = "12";
        String day = "31";
        String year = "2034";

        datePickerPage.clickDateInput();
        datePickerPage.selectMonth(month);
        datePickerPage.selectYear(year);
        datePickerPage.clickDay(day);

        String actualDate = datePickerPage.getDate();
        String expectedDate = monthNumber + "/" + day + "/" + year;
        Assert.assertEquals(actualDate, expectedDate,
                "\n Actual & Expected Dates Do Not Match" +
                        "\n Actual Date:   " + actualDate +
                        "\n Expected Date: " + expectedDate + "\n");
    }
}
