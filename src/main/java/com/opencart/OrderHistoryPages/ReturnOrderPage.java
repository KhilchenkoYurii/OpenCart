package com.opencart.OrderHistoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private WebElement returnReason;

    /** This variable for button Submit on Return Order page*/
    private WebElement submitButton;

    public ReturnOrderPage(WebDriver driver) {
        this.returnReason = driver.findElement(By.xpath("//input[@name = 'return_reason_id' and @value = '1']"));
        this.submitButton = driver.findElement(By.xpath("//input[@class = 'btn btn-primary']"));
    }

    /** This method select first Reason for Return Order*/
    public void selectReturnReason() {
        returnReason.click();
    }

    /** This method for click on button Submit*/
    public void submitButtonClick() {
        submitButton.click();
    }
}
