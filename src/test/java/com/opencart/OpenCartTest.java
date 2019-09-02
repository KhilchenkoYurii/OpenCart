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
   // private NewAddressPage newAddressPage;
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
        editAddressPage = PageFactory.initElements(driver,EditAddressPage.class);
    }

    @AfterMethod
    public void toAddressBook() {
       // addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        //addressBookPage.openPage(driver);
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
        editAddressPage.selectZone("Kara");
       // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }
    @Test(groups = "edit")
    public void editAddressNumbers() {
        editAddressPage.inputFirstname("12345");
        editAddressPage.inputLastname("12345");
        editAddressPage.inputCompany("12345");
        editAddressPage.inputAddress1("12345");
        editAddressPage.inputCity("12345");
        editAddressPage.inputPostcode("12345");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }

    @Test(groups = "edit")
    public void editAddressSpecSymbols() {
        editAddressPage.inputFirstname("!@#$%");
        editAddressPage.inputLastname("!@#$%");
        editAddressPage.inputCompany("!@#$%");
        editAddressPage.inputAddress1("!@#$%");
        editAddressPage.inputCity("!@#$%");
        editAddressPage.inputPostcode("!@#$%");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }

    @Test(groups = "edit")
    public void editAddressEmptyData() {
        editAddressPage.inputFirstname("");
        editAddressPage.inputLastname("");
        editAddressPage.inputCompany("");
        editAddressPage.inputAddress1("");
        editAddressPage.inputCity("");
        editAddressPage.inputPostcode("");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }

    @Test(groups = "edit")
    public void editAddressMinSymbols() {
        editAddressPage.inputFirstname("a");
        editAddressPage.inputLastname("a");
        editAddressPage.inputCompany("a");
        editAddressPage.inputAddress1("aaa");
        editAddressPage.inputCity("aa");
        editAddressPage.inputPostcode("aa");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }

    @Test(groups = "edit")
    public void editAddressMaxSymbols() {
        editAddressPage.inputFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCompany("a");
        editAddressPage.inputAddress1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCity("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputPostcode("aaaaaaaaaa");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }

    @Test(groups = "edit")
    public void editAddressUnderMaxSymbols() {
        editAddressPage.inputFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCompany("aa");
        editAddressPage.inputAddress1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCity("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputPostcode("aaaaaaaaaaa");
        editAddressPage.selectCountry("Togo");

        //Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
    }
    @Test(groups = "edit")
    public void editBackButton() {
        editAddressPage.clickBackButton();
    }

    @Test
    public void deleteAddress() {
    addressBookPage.deleteClick();
}

    @Test(groups = "create")
    public void createAddressNormalData() {
        editAddressPage.inputFirstname("andrii");
        editAddressPage.inputLastname("Iatskiv");
        editAddressPage.inputCompany("hzCompany");
        editAddressPage.inputAddress1("Lychakivska street");
        editAddressPage.inputCity("Kyiv");
        editAddressPage.inputPostcode("30037");
        editAddressPage.selectCountry("Togo");
        editAddressPage.selectZone("Kara");
        // editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
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