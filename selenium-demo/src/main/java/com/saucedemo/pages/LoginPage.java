package com.saucedemo.pages;

import com.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//div[contains(@class, 'error-message-container')]//h3");

    public void setUsername(String username) {
        setText(usernameInput, username);
    }

    public void setPassword(String password) {
        setText(passwordInput, password);
    }

    /**
     * 这是一个导航方法，会导航到另一个页面
     *
     * @return 登录后的第一个产品页
     */
    public ProductPage clickLoginButton() {
        click(loginButton);
        return new ProductPage();
    }

    public ProductPage loginApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
