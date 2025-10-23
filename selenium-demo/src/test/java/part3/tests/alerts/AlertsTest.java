package part3.tests.alerts;

import com.demoqa.pages.alertsFrameAndWindows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

import static com.util.AlertUtil.*;

public class AlertsTest extends BaseTest {

    @Test
    public void testInformationAlert() {
        AlertsPage alertsPage = homePage.goToAlertsFrameAndWindows().clickAlerts();
        alertsPage.clickInformationAlertButton();
        String expectedAlertText = "You clicked a button";
        Assert.assertEquals(getAlertText(), expectedAlertText,
                "\n Actual & Expected Messages Do Not Match \n");
        acceptAlert();
    }

    @Test
    public void testConfirmAlert() {
        AlertsPage alertsPage = homePage.goToAlertsFrameAndWindows().clickAlerts();
        alertsPage.clickConfirmAlertButton();
        String expectedConfirmationResult = "You selected Cancel";
        dismissAlert();
        String actualConfirmationResult = alertsPage.getConfirmResult();
        Assert.assertEquals(actualConfirmationResult, expectedConfirmationResult,
                "\n Actual & Expected Messages Do Not Match \n");
    }

    @Test
    public void testPromptAlert() {
        AlertsPage alertsPage = homePage.goToAlertsFrameAndWindows().clickAlerts();
        alertsPage.clickPromptAlertButton();
        String alertInputText = "Hello World";
        String expectedPromptResult = "You entered " + alertInputText;
        setAlertText(alertInputText);
        acceptAlert();
        String actualPromptResult = alertsPage.getPromptResult();
        Assert.assertEquals(actualPromptResult, expectedPromptResult,
                "\n Actual & Expected Messages Do Not Match \n");
    }
}
