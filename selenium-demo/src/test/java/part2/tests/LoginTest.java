package part2.tests;

import com.saucedemo.pages.ProductPage;
import org.testng.annotations.Test;
import part2.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("xyz3400");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        assertTrue(actualMessage.contains("Epic sadface"));
    }

    @Test
    public void testLoginSuccess() {
        ProductPage productPage = loginPage.loginApplication("standard_user", "secret_sauce");
        assertTrue(productPage.isProductsHeaderDisplayed(),
                "\n Products Header Is Not Displayed \n");
    }
}
