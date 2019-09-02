package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

    @FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[3]/a" )
    private WebElement addressLink;

    @FindBy(css = "#column-right > div > a:nth-child(6)")
    private WebElement historyLink;

    public void addressClick() {
        addressLink.click();
    }

    public void historyLink() {
        historyLink.click();
    }
}
