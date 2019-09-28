package com.opencart.OrderHistoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a page Order History with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class OrderHistoryPage {

    /** This variable is a base url fo this page */
    private static final String URL = "http://192.168.112.133/opencart/upload/index.php?route=account/order";

    /** This variable is button Look Order */
    private WebElement lookButton;

    public OrderHistoryPage(WebDriver driver) {
        this.lookButton = driver.findElement(By.xpath("//td[contains(text(),'#3')]/following-sibling::td/a[contains(@class,'btn btn-info')]"));
    }

    /** This a personal web driver on page Order History */
    private WebDriver driver;

    /** This method for click on button Look Order */
    public void lookClick() {
        lookButton.click();
    }

    /** This method opening page Order History  */
    public void openPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }
}
