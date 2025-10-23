package part3.tests.frames;

import com.demoqa.pages.alertsFrameAndWindows.FramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part3.base.BaseTest;

public class FrameTest extends BaseTest {

    @Test
    public void testFrameBigBox() {
        FramesPage framesPage = homePage.goToAlertsFrameAndWindows().clickFrames();
        String actualBigBoxText = framesPage.getTextInBigFrame();
        String expectedBigBoxText = "This is a sample page";
        Assert.assertEquals(actualBigBoxText, expectedBigBoxText,
                "\n Actual & Expected Text Do Not Match \n");
        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeaderText = "Frames";
        Assert.assertEquals(actualHeaderText, expectedHeaderText,
                "\n Actual & Expected Header Text Do Not Match \n");
    }

    @Test
    public void testFrameSmallBox() {
        FramesPage framesPage = homePage.goToAlertsFrameAndWindows().clickFrames();
        String actualSmallBoxText = framesPage.getTextInSmallFrame();
        String expectedSmallBoxText = "This is a sample page";
        Assert.assertEquals(actualSmallBoxText, expectedSmallBoxText,
                "\n Actual & Expected Text Do Not Match \n");
        String actualHeaderText = framesPage.getHeaderFramesText();
        String expectedHeaderText = "Frames";
        Assert.assertEquals(actualHeaderText, expectedHeaderText,
                "\n Actual & Expected Header Text Do Not Match \n");
    }
}
