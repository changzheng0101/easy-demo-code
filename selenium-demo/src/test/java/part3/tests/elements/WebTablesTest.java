package part3.tests.elements;

import com.demoqa.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class WebTablesTest extends BaseTest {

    @Test
    public void testTable() {
        String email = "alden@example.com";
        String newAge = "99";

        WebTablesPage webTablesPage = homePage.goToElementsPage().clickWebTables();
        webTablesPage.clickEdit(email);
        webTablesPage.setAge(newAge);
        webTablesPage.clickSubmitButton();

        Assert.assertEquals(webTablesPage.getTableAge(email), newAge);
    }
}
