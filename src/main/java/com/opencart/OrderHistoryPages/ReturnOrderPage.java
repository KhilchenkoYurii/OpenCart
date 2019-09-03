package com.opencart.OrderHistoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnOrderPage {
    @FindBy(xpath = "//input[@name = 'return_reason_id' and @value = '1']")
    private WebElement returnReason;

    @FindBy(xpath = "//input[@class = 'btn btn-primary']")
    private WebElement submitButton;

    public void selectReturnReason() {
        returnReason.click();
    }

    public void submitButtonClick() {
        submitButton.click();
    }
}
