package com.opencart.OtherPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a Main page with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class MainPage {

    /** This variable is a base url for Main page */
    private static final String BASE_URL = "http://192.168.112.133/opencart/upload/";

    /** This variable is a personal web driver */
    private WebDriver driver;

    /** This variable for link at My Account page */
    @FindBy(linkText = "My Account")
    private WebElement myAccountLink;

    /** This variable for link at Registry page */
    @FindBy(linkText = "Register")
    private WebElement registerLink;

    /** This variable for link at Login page */
    @FindBy(linkText = "Login")
    private WebElement loginLink;



    /** This argument constructor for Main page */
    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    /** This method opening Main page */
    public void open()
    {
        driver.get(BASE_URL);
    }

    /** This method for click on My Account link */
    public void clickOnAccount()
    {
        myAccountLink.click();
    }

    /** This method for click on Registry link */
    public void clickOnRegister()
    {
        registerLink.click();
    }

    /** This method for click on Login link */
    public void  clickOnLogin()
    {
        loginLink.click();
    }

}
