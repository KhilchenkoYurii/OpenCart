package com.opencart.AddressBookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Address Book with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class AddressBookPage {

    /** This a base url for page Address Book */
    private static final String BASE_URL = "http://192.168.112.132/opencart/upload/index.php?route=account/address";

    /** This a  personal webdriver for open base url */
    private WebDriver driver;

    /** This variable for address information on page */
    @FindBy(className = "text-left")
    private WebElement addressText;

    /** This variable for button Edit on page */
    @FindBy(linkText = "Edit")
    private WebElement editButton;

    /** This variable for button Delete on page */
    @FindBy(xpath = "//a[contains(@class,'btn btn-danger')]")
    private WebElement deleteButton;

    /** This variable for button New Address on page */
    @FindBy(linkText = "New Address")
    private WebElement newAddressButton;

    /** This variable for catching message about success update */
    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement updateText;

    /** This variable for catching message with warning */
    @FindBy(xpath = "//div[contains(@class,'alert alert-warning')]")
    private WebElement warningText;

    /** This method opening page*/
    public void openPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(BASE_URL);}

    /** This method click on button Edit */
    public void editClick() {
        editButton.click();
    }

    /** This method click on button Delete  */
    public void deleteClick() {
        deleteButton.click();
    }

    /** This method click on button New Address  */
    public void newAddressClick() {
        newAddressButton.click();
    }

    /** This method catch text in update success message */
    public String getUpdateText() {
        return updateText.getText();
    }

    /** This method catch text in warning message */
    public String getWarningText() {
        return warningText.getText();
    }
}
