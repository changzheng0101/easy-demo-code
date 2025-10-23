package part3.tests.widgets;

import com.demoqa.pages.widgets.SelectMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

import java.util.List;

public class DropDownTest extends BaseTest {

    @Test(testName = "测试Dropdown")
    public void testMultiSelectDropDown() {
        SelectMenuPage selectMenuPage = homePage.goToWidgetsPage().clickSelectMenu();
        selectMenuPage.selectStandardMulti("Volvo");
        selectMenuPage.selectStandardMulti(1);
        selectMenuPage.selectStandardMulti("Audi");
        selectMenuPage.selectStandardMulti(2);

        selectMenuPage.deselectStandardMulti("saab");

        List<String> actualSelectedOptions =
                selectMenuPage.getAllSelectedOptions();
        Assert.assertTrue(actualSelectedOptions.contains("Volvo"));
        Assert.assertTrue(actualSelectedOptions.contains("Opel"));
        Assert.assertTrue(actualSelectedOptions.contains("Audi"));
        Assert.assertFalse(actualSelectedOptions.contains("Saab"),
                "\n Saab Is Selected As An Option \n");
    }
}
