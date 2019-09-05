package com.opencart.OtherPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class is a Main page with all needed parameters
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class MyAccountPage {

    /** This variable for link on Address Book page */
    @FindBy(xpath = "//a[text()='Address Book']" )
    private WebElement addressLink;

    /** This variable for link on Order History page */
    @FindBy(xpath = "//a[text()='Order History' and @class]")
    private WebElement historyLink;

    /** This method for click on Address Book lick */
    public void addressClick() {
        addressLink.click();
    }

    /** This method for click on Order History lick */
    public void historyLink() {
        historyLink.click();
    }
}
