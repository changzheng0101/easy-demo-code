package part3.tests.forms;

import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class RadioButtonTest extends BaseTest {

    @Test(testName = "测试RadioButton被点击")
    public void testRadioButton() {
        PracticeFormPage practiceFormPage = homePage.goToForms().clickPracticeFromMenuItem();
        practiceFormPage.clickFemaleRadioButton();
    }
}
