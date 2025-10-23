package part3.tests.modals;

import com.demoqa.pages.alertsFrameAndWindows.ModalDialogsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class ModalTest extends BaseTest {

    @Test
    public void testModalDialog() {
        ModalDialogsPage modalDialogsPage = homePage.goToAlertsFrameAndWindows().clickModalDialogs();
        modalDialogsPage.clickSmallModalButton();
        String actualText = modalDialogsPage.getSmallModalText();
        Assert.assertTrue(actualText.contains("small modal"),
                "\n The Message Does Not Contain 'small modal' \n");
        modalDialogsPage.clickSmallModalCloseButton();
    }
}
