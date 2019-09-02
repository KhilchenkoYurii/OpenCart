package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {
    @FindBy(css = "#content > div.table-responsive > table > tbody > tr > td:nth-child(7) > a")
    private WebElement lookButton;

    public void lookClick() {
        lookButton.click();
    }
}
