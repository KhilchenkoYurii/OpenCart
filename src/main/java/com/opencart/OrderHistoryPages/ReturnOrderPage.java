package com.opencart.OrderHistoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Return Order with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class ReturnOrderPage {

    /** This variable for select Reason for returning on Return Order page*/
    @FindBy(xpath = "//input[@name = 'return_reason_id' and @value = '1']")
    private WebElement returnReason;

    /** This variable for button Submit on Return Order page*/
    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement submitButton;

    /** This method select first Reason for Return Order*/
    public void selectReturnReason() {
        returnReason.click();
    }

    /** This method for click on button Submit*/
    public void submitButtonClick() {
        submitButton.click();
    }
}
