package com.demoqa.pages.alertsFrameAndWindows;

import org.openqa.selenium.By;

import static com.util.FrameUtil.*;
import static com.util.GetUtil.getWebElementText;

public class FramesPage extends AlertsFrameAndWindowsPage {
    private final By textInFrame = By.id("sampleHeading");
    private final By headerFramesText = By.xpath("//h1[text()='Frames']");
    private final By frameSmallBox = By.id("frame2");

    private void switchToBigBox() {
        String frameBigBoxId = "frame1";
        switchToFrameWithString(frameBigBoxId);
    }

    private void switchToSmallBox() {
        switchToFrameWithWebElement(find(frameSmallBox));
    }

    public String getHeaderFramesText() {
        return getWebElementText(headerFramesText);
    }

    public String getTextInBigFrame() {
        delay(500);
        switchToBigBox();
        String bigFrameText = getWebElementText(textInFrame);
        switchToDefaultContent();
        return bigFrameText;
    }

    public String getTextInSmallFrame() {
        delay(500);
        switchToSmallBox();
        String smallFrameText = getWebElementText(textInFrame);
        switchToDefaultContent();
        return smallFrameText;
    }
}
