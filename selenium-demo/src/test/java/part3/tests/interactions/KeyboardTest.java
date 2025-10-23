package part3.tests.interactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class KeyboardTest extends BaseTest {

    @Test
    public void testApplicationUsingKeyboard() {
        var textBoxPage = homePage.goToElementsPage().clickTextBox();
        textBoxPage.setFullName("test full name");
        textBoxPage.setEmail("test@GMail.com");
        textBoxPage.setCurrentAddress("1234 Selenium Avenue");
        textBoxPage.setCurrentAddress("Suite 3400");
        textBoxPage.setCurrentAddress("Dallas, Texas");
        textBoxPage.clickSubmitButton();
        String actualAddress = textBoxPage.getCurrentAddress();
        Assert.assertTrue(actualAddress.contains("Suite 3400"),
                "\n Actual Address Does Not Contain Suite 3400 \n");
    }
}
