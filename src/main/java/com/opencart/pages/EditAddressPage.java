package com.opencart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = "#input-country > option:nth-child(226)")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"input-zone\"]/option[3]")
    private WebElement zone;

    @FindBy(xpath = "//*[@id=\"input-zone\"]/option[2]")
    private WebElement zoneInAdd;

    @FindBy(className = "radio-inline")
    private WebElement yesNoButton;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    private WebElement continueButton;

    @FindBy(css = "#content > form > div > div.pull-left > a")
    private WebElement backButton;

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
        country.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void selectZone(String text) {
        zone.click();
    }
    public void selectZoneInAdd(String text) {
        zoneInAdd.click();
    }

    public void clickYesDefault() {

        yesNoButton.findElement(By.linkText("Yes"));
        yesNoButton.click();
    }

    public void clickNoDefault() {
        yesNoButton.findElement(By.linkText("Yes"));
        yesNoButton.click();
    }

    public void clickBackButton() {
        backButton.click();
    }



}
