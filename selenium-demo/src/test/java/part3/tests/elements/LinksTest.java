package part3.tests.elements;

import com.demoqa.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class LinksTest extends BaseTest {

    @Test
    public void testBadRequest() {
        String expectedText = "Link has responded with staus 400 and status text Bad Request";
        LinksPage linksPage = homePage.goToElementsPage().clickLinks();
        linksPage.clickBadRequestLink();
        String response = linksPage.getResponse();
        Assert.assertEquals(response, expectedText);
    }
}
