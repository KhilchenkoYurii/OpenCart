package com.opencart.OtherPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private  WebElement passwordInput;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement loginButton;

    private static final String PASS = "qwerty";

    private static final String EMAIL = "roman@gmail.com";

    public void logining()
    {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(EMAIL);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(PASS);
        loginButton.click();
    }
}
