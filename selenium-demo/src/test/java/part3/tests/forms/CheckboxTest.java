package part3.tests.forms;

import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class CheckboxTest extends BaseTest {

    @Test(testName = "测试checkbox被选中")
    public void testCheckbox() {
        PracticeFormPage formPage = homePage.goToForms().clickPracticeFromMenuItem();
        formPage.selectSportsCheckbox();
        formPage.selectReadingCheckbox();
        formPage.selectMusicCheckbox();
        formPage.unselectReadingCheckbox();

        Assert.assertTrue(formPage.isMusicSelected());
        Assert.assertFalse(formPage.isReadingSelected());
    }
}
