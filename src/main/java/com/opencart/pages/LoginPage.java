package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private  WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginButton;

    private static final String PASS = "qwerty";

    private static final String EMAIL = "fyck414@gmail.com";

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
