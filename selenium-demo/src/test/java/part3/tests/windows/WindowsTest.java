package part3.tests.windows;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

import static com.util.GetUtil.getURL;

public class WindowsTest extends BaseTest {

    @Test
    public void testNewWindowURL() {
        var windowsPage = homePage.goToAlertsFrameAndWindows().clickBrowserWindows();
        windowsPage.clickNewWindowButton();
        windowsPage.switchToNewWindow();
        String actualURL = getURL();
        String expectedURL = "https://demoqa.com/sample";
        Assert.assertEquals(actualURL, expectedURL,
                "\n Actual & Expected URL's Do Not Match \n");
    }
}
