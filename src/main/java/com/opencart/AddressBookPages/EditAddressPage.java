package com.opencart.AddressBookPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Edit Address with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class EditAddressPage {

    /** This variable is input field FirstName */
    @FindBy(id = "input-firstname")
    private WebElement firstname;

    /** This variable is input field LastName */
    @FindBy(id = "input-lastname")
    private WebElement lastname;

    /** This variable is input field Company */
    @FindBy(id = "input-company")
    private WebElement company;

    /** This variable is input field First Address */
    @FindBy(name = "address_1")
    private WebElement firstAddress;

    /** This variable is input field Second Address */
    @FindBy(name = "address_2")
    private WebElement secondAddress;

    /** This variable is input field City */
    @FindBy(id = "input-city")
    private WebElement city;

    /** This variable is input field PostCode */
    @FindBy(id = "input-postcode")
    private WebElement postcode;

    /** This variable is dropdown menu Country */
    @FindBy(id = "input-country")
    private WebElement country;

    /** This variable is dropdown menu Region/Stait */
    @FindBy(id = "input-zone")
    private WebElement zone;

    /** This variable is yes button for check Default Address */
    @FindBy(xpath = "//input[@name ='default' and @value ='1']")
    private WebElement yesButton;

    /** This variable is no button for check Default Address */
    @FindBy(xpath = "//input[@name ='default' and @value ='0']")
    private WebElement noButton;

    /** This variable is Continue button */
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;

    /** This variable is Back button */
    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement backButton;

    /** This variable for catching message about something error in firs input field*/
    @FindBy(xpath = "//div[contains(@class,'text-danger')]")
    private WebElement errorText;

    /** This method for input text in field FirstName */
    public void inputFirstname(String text) {
        firstname.click();
        firstname.clear();
        firstname.sendKeys(text);
    }

    /** This method for input text in field LastName */
    public void inputLastname(String text) {
        lastname.click();
        lastname.clear();
        lastname.sendKeys(text);
    }

    /** This method for input text in field Company */
    public void inputCompany(String text) {
        company.click();
        company.clear();
        company.sendKeys(text);
    }

    /** This method for input text in field First Address */
    public void inputAddress1(String text) {
        firstAddress.click();
        firstAddress.clear();
        firstAddress.sendKeys(text);
    }

    /** This method for input text in field Second Address */
    public void inputAddress2(String text) {
        secondAddress.click();
        secondAddress.clear();
        secondAddress.sendKeys(text);
    }

    /** This method for input text in field City */
    public void inputCity(String text) {
        city.click();
        city.clear();
        city.sendKeys(text);
    }

    /** This method for input text in field Postcode */
    public void inputPostcode(String text) {
        postcode.click();
        postcode.clear();
        postcode.sendKeys(text);
    }

    /** This method for select from dropdown menu Country element equal @param text*/
    public void selectCountry(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        country = country.findElement(By.xpath(xpath));
        country.click();
    }

    /** This method for click on button Continue */
    public void clickContinueButton() {
        continueButton.click();
    }

    /** This method for select from dropdown menu Country element equal @param text*/
    public void selectZone(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        zone = zone.findElement(By.xpath(xpath));
        zone.click();
    }

    /** This method for click on button Yes if check Default Address */
    public void clickYesDefault() {
        yesButton.click();
    }

    /** This method for click on button No if check Default Address */
    public void clickNoDefault() {
        noButton.click();
    }

    /** This method for click on button Back */
    public void clickBackButton() {
        backButton.click();
    }

    /** This method for catch text from error message in firs input field */
    public String getErrorText() {
        return errorText.getText();
    }


}
