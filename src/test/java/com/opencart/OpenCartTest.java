package com.opencart;

import com.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OpenCartTest
{
    @Test
    public void openCartTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        MainPage MainPage = PageFactory.initElements(driver, MainPage.class);
        MainPage.open();
        MainPage.clickOnAccount();
        MainPage.clickOnLogin();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logining();

        MyAccountPage myAccount = PageFactory.initElements(driver, MyAccountPage.class);
        myAccount.addressClick();

        AddressBookPage addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();

        EditAddressPage editAddressPage = PageFactory.initElements(driver,EditAddressPage.class);
        editAddressPage.setEdit();

    }
}