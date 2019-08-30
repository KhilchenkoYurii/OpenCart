package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage {

    @FindBy(className = "text-left")
    private WebElement addressText;

    @FindBy(linkText = "Edit")
    private WebElement editButton;

    @FindBy(linkText = "Delete")
    private WebElement deleteButton;

    @FindBy(linkText = "New Address")
    private WebElement newAddressButton;

    public void editClick() {
        editButton.click();
    }

    public void deleteClick() {
        deleteButton.click();
    }

    public void newAddressClick() {
        newAddressButton.click();
    }
}
