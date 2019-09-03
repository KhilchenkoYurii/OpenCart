package com.opencart.AddressBookPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAddressPage {

    @FindBy(id = "input-firstname")
    private WebElement firstname;

    @FindBy(id = "input-lastname")
    private WebElement lastname;

    @FindBy(id = "input-company")
    private WebElement company;

    @FindBy(name = "address_1")
    private WebElement firstAddress;

    @FindBy(name = "address_2")
    private WebElement secondAddress;

    @FindBy(id = "input-city")
    private WebElement city;

    @FindBy(id = "input-postcode")
    private WebElement postcode;

    @FindBy(id = "input-country")
    private WebElement country;

    @FindBy(id = "input-zone")
    private WebElement zone;

    @FindBy(xpath = "//input[@name ='default' and @value ='1']")
    private WebElement yesButton;

    @FindBy(xpath = "//input[@name ='default' and @value ='0']")
    private WebElement noButton;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement backButton;

    @FindBy(xpath = "//div[contains(@class,'text-danger')]")
    private WebElement errorText;

    public void inputFirstname(String text) {
        firstname.click();
        firstname.clear();
        firstname.sendKeys(text);
    }

    public void inputLastname(String text) {
        lastname.click();
        lastname.clear();
        lastname.sendKeys(text);
    }

    public void inputCompany(String text) {
        company.click();
        company.clear();
        company.sendKeys(text);
    }

    public void inputAddress1(String text) {
        firstAddress.click();
        firstAddress.clear();
        firstAddress.sendKeys(text);
    }

    public void inputAddress2(String text) {
        secondAddress.click();
        secondAddress.clear();
        secondAddress.sendKeys(text);
    }

    public void inputCity(String text) {
        city.click();
        city.clear();
        city.sendKeys(text);
    }

    public void inputPostcode(String text) {
        postcode.click();
        postcode.clear();
        postcode.sendKeys(text);
    }

    public void selectCountry(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        country = country.findElement(By.xpath(xpath));
        country.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void selectZone(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        zone = zone.findElement(By.xpath(xpath));
        zone.click();
    }

    public void clickYesDefault() {
        yesButton.click();
    }

    public void clickNoDefault() {
        noButton.click();
    }

    public void clickBackButton() {
        backButton.click();
    }

    public String getErorrText() {
        return errorText.getText();
    }


}
