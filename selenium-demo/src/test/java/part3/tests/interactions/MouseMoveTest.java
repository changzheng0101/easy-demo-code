package part3.tests.interactions;

import com.demoqa.pages.widgets.SliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class MouseMoveTest extends BaseTest {

    @Test
    public void testMoveSliderWithMouse() {
        SliderPage sliderPage = homePage.goToWidgetsPage().clickSlider();
        sliderPage.moveSlider(100);
        String sliderValue = sliderPage.getSliderValue();
        Assert.assertEquals(sliderValue, "50");
    }
}
