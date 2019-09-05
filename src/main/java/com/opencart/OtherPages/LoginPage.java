package com.opencart.OtherPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Login with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class LoginPage {

    /** This constant is password for login */
    private static final String PASS = "qwerty";

    /** This constant is Email for login */
    private static final String EMAIL = "roman@gmail.com";

    /** This variable for input field Email */
    @FindBy(id = "input-email")
    private WebElement emailInput;

    /** This variable for input field Password */
    @FindBy(id = "input-password")
    private  WebElement passwordInput;

    /** This variable for button Login */
    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement loginButton;

    /** This method Log in in OpenCart system as User*/
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
