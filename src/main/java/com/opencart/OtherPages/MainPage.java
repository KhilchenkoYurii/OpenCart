package com.opencart.OtherPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private static final String BASE_URL = "http://192.168.112.131/opencart/upload/";
    private WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void open()
    {
        driver.get(BASE_URL);
    }

    public void clickOnAccount()
    {
        myAccountLink.click();
    }

    public void clickOnRegister()
    {
        registerLink.click();
    }

    public void  clickOnLogin()
    {
        loginLink.click();
    }

}
