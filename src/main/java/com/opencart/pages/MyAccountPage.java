package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

    @FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[3]/a" )
    private WebElement addressLink;

    public void addressClick() {
        addressLink.click();
    }
}
