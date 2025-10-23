package part3.tests.dynamic_wait;

import com.demoqa.pages.elements.DynamicPropertiesPage;
import com.demoqa.pages.widgets.ProgressBarPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class DynamicWaitTests extends BaseTest {

    @Test
    public void testVisibleAfterButtonText() {
        DynamicPropertiesPage dynamicPropertiesPage = homePage.goToElementsPage().clickDynamicProperties();
        String actualText = dynamicPropertiesPage.getVisibleAfterButtonText();
        String expectedText = "Visible After 5 Seconds";
        assertEquals(actualText, expectedText,
                "\n Actual & Expected Text Do Not Match \n");
    }

    @Test
    public void testProgressBar() {
        ProgressBarPage progressBarPage = homePage.goToWidgetsPage().clickProgressBar();
        progressBarPage.clickStartStopButton();
        String finishedProgressBarValue = progressBarPage.getFinishedProgressBarValue();
        Assert.assertEquals(finishedProgressBarValue, "100%");
    }
}
