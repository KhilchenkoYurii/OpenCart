package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    private WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastnameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "telephone")
    private WebElement phoneInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "confirm")
    private WebElement confirmInput;

    @FindBy(name = "agree")
    private WebElement agreeCheckBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/input[2]")
    private WebElement ContinueButton;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterFirstName(String name){

        firstNameInput.clear();
        firstNameInput.sendKeys(name);
    }


    public void enterLastName(String lastName) {

        lastnameInput.clear();
        lastnameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {

        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPhone(String number) {

        phoneInput.clear();
        phoneInput.sendKeys(number);
    }

    public void enterPassword(String pass ) {

        passwordInput.clear();
        passwordInput.sendKeys(pass);
    }

    public void confirmPassword(String confirm) {

        confirmInput.clear();
        confirmInput.sendKeys(confirm);
    }

    public void policyCheck()
    {
        agreeCheckBox.click();
    }

    public void pressContinue()
    {
        ContinueButton.click();
    }


}
