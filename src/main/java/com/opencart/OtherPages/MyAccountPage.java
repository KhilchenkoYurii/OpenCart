package com.opencart.OtherPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

    @FindBy(xpath = "//a[text()='Address Book']" )
    private WebElement addressLink;

    @FindBy(xpath = "//a[text()='Order History' and @class]")
    private WebElement historyLink;

    public void addressClick() {
        addressLink.click();
    }

    public void historyLink() {
        historyLink.click();
    }
}
