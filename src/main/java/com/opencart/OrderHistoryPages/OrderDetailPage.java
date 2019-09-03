package com.opencart.OrderHistoryPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailPage {
    @FindBy(xpath = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-danger')]")
    private WebElement returnButton;

    @FindBy(xpath = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-primary')]")
    private WebElement reorderButton;

    @FindBy(xpath = "//div[@class = 'alert alert-success']")
    private WebElement actionMessage;

    public void returnButtonClick() {
        returnButton.click();
    }

    public void reorderButtonClick() {
        reorderButton.click();
    }

    public String getActionMessage() {
        return actionMessage.getText();
    }

}
