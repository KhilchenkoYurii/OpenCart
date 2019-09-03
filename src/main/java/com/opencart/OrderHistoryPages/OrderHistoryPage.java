package com.opencart.OrderHistoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {
    @FindBy(xpath = "//td[contains(text(),'#3')]/following-sibling::td/a[contains(@class,'btn btn-info')]")
    private WebElement lookButton;

    private WebDriver driver;
    private static final String URL = "http://192.168.112.131/opencart/upload/index.php?route=account/order";

    public void lookClick() {
        lookButton.click();
    }

    public void openPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }
}
