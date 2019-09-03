package com.opencart.AddressBookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage {

    private static final String BASE_URL = "http://192.168.112.131/opencart/upload/index.php?route=account/address";
    private WebDriver driver;
    @FindBy(className = "text-left")
    private WebElement addressText;

    @FindBy(linkText = "Edit")
    private WebElement editButton;

    @FindBy(xpath = "//a[contains(@class,'btn btn-danger')]")
    private WebElement deleteButton;

    @FindBy(linkText = "New Address")
    private WebElement newAddressButton;

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement updateText;

    @FindBy(xpath = "//div[contains(@class,'alert alert-warning')]")
    private WebElement warningText;


    public void openPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(BASE_URL);}

    public void editClick() {
        editButton.click();
    }

    public void deleteClick() {
        deleteButton.click();
    }

    public void newAddressClick() {
        newAddressButton.click();
    }

    public String getUpdateText() {
        return updateText.getText();
    }

    public String getWarningText() {
        return warningText.getText();
    }
}
