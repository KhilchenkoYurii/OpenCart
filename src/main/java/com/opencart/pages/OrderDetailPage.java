package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailPage {
    @FindBy(css = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-danger')]")
    private WebElement returnButton;

    @FindBy(css = "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-primary')]")
    private WebElement reorderButton;

    public void returnButtonClick() {
        reorderButton.click();
    }

    public void reorderButtonClick() {
        reorderButton.click();
    }

}
