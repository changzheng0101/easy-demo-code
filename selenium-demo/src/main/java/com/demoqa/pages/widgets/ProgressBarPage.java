package com.demoqa.pages.widgets;

import com.util.GetUtil;
import org.openqa.selenium.By;

import static com.util.WaitUtil.fluentWaitUntilVisible;

public class ProgressBarPage extends WidgetsPage {
    private final By startStopButton = By.id("startStopButton");
    private final By progressValue = By.xpath("//div[@id='progressBar']/div[@aria-valuenow='100']");

    public void clickStartStopButton() {
        click(startStopButton);
    }

    public String getFinishedProgressBarValue() {
        fluentWaitUntilVisible(30, progressValue);
        return GetUtil.getWebElementText(progressValue);
    }
}
