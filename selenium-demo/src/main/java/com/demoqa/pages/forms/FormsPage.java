package com.demoqa.pages.forms;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

public class FormsPage extends HomePage {
    private final By practiceFromMenuItem = By.xpath("//span[text()='Practice Form']");

    public PracticeFormPage clickPracticeFromMenuItem() {
        click(practiceFromMenuItem);
        return new PracticeFormPage();
    }
}
