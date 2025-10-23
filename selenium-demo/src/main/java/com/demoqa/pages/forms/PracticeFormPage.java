package com.demoqa.pages.forms;

import org.openqa.selenium.By;

import static com.util.JavaScriptUtil.clickJS;

public class PracticeFormPage extends FormsPage {
    private final By femaleRadioButton = By.xpath("//label[text()='Female']");
    private final By sportsCheckbox = By.id("hobbies-checkbox-1");
    private final By readingCheckbox = By.id("hobbies-checkbox-2");
    private final By musicCheckbox = By.id("hobbies-checkbox-3");

    public void clickFemaleRadioButton() {
        click(femaleRadioButton);
    }

    public void selectSportsCheckbox() {
        if (!find(sportsCheckbox).isSelected()) {
            clickJS(sportsCheckbox);
        }
    }

    public void selectReadingCheckbox() {
        if (!find(readingCheckbox).isSelected()) {
            clickJS(readingCheckbox);
        }
    }

    public void selectMusicCheckbox() {
        if (!find(musicCheckbox).isSelected()) {
            clickJS(musicCheckbox);
        }
    }

    public void unselectReadingCheckbox() {
        if (find(readingCheckbox).isSelected()) {
            clickJS(readingCheckbox);
        }
    }

    public boolean isMusicSelected() {
        return find(musicCheckbox).isSelected();
    }

    public boolean isReadingSelected() {
        return find(readingCheckbox).isSelected();
    }
}
