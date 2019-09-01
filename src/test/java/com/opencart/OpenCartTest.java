package com.opencart;

import com.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestNG;
import org.testng.annotations.*;

public class OpenCartTest
{
    private WebDriver driver;
    private EditAddressPage editAddressPage;
    private NewAddressPage newAddressPage;
    private AddressBookPage addressBookPage;

    @BeforeClass
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();

        MainPage MainPage = PageFactory.initElements(driver, MainPage.class);
        MainPage.open();
        MainPage.clickOnAccount();
        MainPage.clickOnLogin();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.logining();

        MyAccountPage myAccount = PageFactory.initElements(driver, MyAccountPage.class);
        myAccount.addressClick();
    }
    @BeforeGroups(groups = "edit")
    public void toEdit() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();
        editAddressPage = PageFactory.initElements(driver,EditAddressPage.class);
    }

    @BeforeGroups(groups = "create")
    public void toCreate() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.newAddressClick();
        newAddressPage = PageFactory.initElements(driver,NewAddressPage.class);
    }

    @AfterMethod
    public void toAddressBook() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.openPage(driver);
    }
    @Test(groups = "edit")
    public void editAddressNormalData() {
        editAddressPage.inputFirstname("andrii");
        editAddressPage.inputLastname("Iatskiv");
        editAddressPage.inputCompany("hzCompany");
        editAddressPage.inputAddress1("Lychakivska street");
        editAddressPage.inputCity("Kyiv");
        editAddressPage.inputPostcode("30037");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
    }
    @Test(groups = "edit")
    public void editAddressNumbers() {
    }

    @Test(groups = "edit")
    public void editAddressSpecSymbols() {
    }

    @Test(groups = "edit")
    public void editAddressEmptyData() {
    }

    @Test(groups = "edit")
    public void editAddressMinSymbols() {
    }

    @Test(groups = "edit")
    public void editAddressMaxSymbols() {
        AddressBookPage addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();
    }

    @Test(groups = "edit")
    public void editAddressUnderMaxSymbols() {
        AddressBookPage addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();
    }
    @Test(groups = "edit")
    public void editBackButton() {

    }

    @Test
    public void deleteAddress() {

}
    @Test(groups = "create")
    public void createAddressNormalData() {

    }
    @Test(groups = "create")
    public void createAddressNumbers() {

    }

    @Test(groups = "create")
    public void createAddressSpecSymbols() {

    }

    @Test(groups = "create")
    public void createAddressEmptyData() {

    }

    @Test(groups = "create")
    public void createAddressMinSymbols() {

    }

    @Test(groups = "create")
    public void createAddressMaxSymbols() {

    }

    @Test(groups = "create")
    public void createAddressUnderMaxSymbols() {

    }

    @Test(groups = "create")
    public void createBackButton() {

    }

}