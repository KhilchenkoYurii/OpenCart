package com.opencart.OrderHistoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Order Detail with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class OrderDetailPage {

    /** This variable is button Return Order */
    @FindBy(xpath = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-danger')]")
    private WebElement returnButton;

    /** This variable is button Reorder Order */
    @FindBy(xpath = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-primary')]")
    private WebElement reorderButton;

    /** This variable for catching message about success reordering */
    @FindBy(xpath = "//div[@class = 'alert alert-success']")
    private WebElement actionMessage;

    /** This method for click on button Return Order */
    public void returnButtonClick() {
        returnButton.click();
    }

    /** This method for click on button Reorder Order */
    public void reorderButtonClick() {
        reorderButton.click();
    }

    /** This method for catch text from message about success reordering */
    public String getActionMessage() {
        return actionMessage.getText();
    }
}
