package com.opencart;

import com.opencart.AddressBookPages.AddressBookPage;
import com.opencart.AddressBookPages.EditAddressPage;
import com.opencart.OtherPages.LoginPage;
import com.opencart.OtherPages.MainPage;
import com.opencart.OtherPages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 *  This class for testing Address Book page
 *
 * @version 1.0
 * @author Yurii Khilchenko
 */
public class OpenCartTest {

    /** This variable is a personal web driver */
    private WebDriver driver;

    /** This variable is a Edit Address page */
    private EditAddressPage editAddressPage;

    /** This variable is a Address Book page */
    private AddressBookPage addressBookPage;

    /** This variable for ensure equals Warning/Success message with expected string */
    private String assureString;

    /** This Before Class method open Main Page, login as user and go to Address Book page */
    @BeforeClass(alwaysRun = true)
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

    /** This After Class method close web driver */
    @AfterClass(alwaysRun = true)
    public void exit() {
        driver.close();
    }

    /** This Before Groups method go to Edit Address page */
    @BeforeGroups(groups = "edit")
    public void toEdit() {
        assureString = "Your address has been successfully updated";
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    /** This Before Groups method go to Add New Address page */
    @BeforeGroups(groups = "create")
    public void toCreate() {
        assureString = "Your address has been successfully inserted";
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.newAddressClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    /** This method return at Edit Address page after everyone test from group Create */
    @AfterMethod(groups = "create")
    public void toAddressBookCreate() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.openPage(driver);
        addressBookPage.newAddressClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    /** This method return at Edit Address page after everyone test from group Edit */
    @AfterMethod(groups = "edit")
    public void toAddressBookEdit() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.openPage(driver);
        addressBookPage.editClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    /** This method test Add New Address and Edit Address page with normal data in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressNormalData() throws InterruptedException {
        editAddressPage.inputFirstname("andrii");
        editAddressPage.inputLastname("Iatskiv");
        editAddressPage.inputCompany("hzCompany");
        editAddressPage.inputAddress1("Lychakivska street");
        editAddressPage.inputCity("Kyiv");
        editAddressPage.inputPostcode("30037");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Assert.assertEquals(addressBookPage.getUpdateText(), assureString);
    }

    /** This method test Add New Address and Edit Address page with number in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressNumbers() throws InterruptedException {
        editAddressPage.inputFirstname("12345");
        editAddressPage.inputLastname("12345");
        editAddressPage.inputCompany("12345");
        editAddressPage.inputAddress1("12345");
        editAddressPage.inputCity("12345");
        editAddressPage.inputPostcode("12345");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Assert.assertEquals(addressBookPage.getUpdateText(), assureString);
    }

    /** This method test Add New Address and Edit Address page with special symbols in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressSpecSymbols() throws InterruptedException {
        editAddressPage.inputFirstname("!@#$%");
        editAddressPage.inputLastname("!@#$%");
        editAddressPage.inputCompany("!@#$%");
        editAddressPage.inputAddress1("!@#$%");
        editAddressPage.inputCity("!@#$%");
        editAddressPage.inputPostcode("!@#$%");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Assert.assertEquals(addressBookPage.getUpdateText(), assureString);
    }

    /** This method test Add New Address and Edit Address page with empty data in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressEmptyData() throws InterruptedException {
        editAddressPage.inputFirstname("");
        editAddressPage.inputLastname("");
        editAddressPage.inputCompany("");
        editAddressPage.inputAddress1("");
        editAddressPage.inputCity("");
        editAddressPage.inputPostcode("");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        Assert.assertEquals(editAddressPage.getErrorText(), "First Name must be between 1 and 32 characters!");
    }

    /** This method test Add New Address and Edit Address page with minimum input symbols in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressMinSymbols() throws InterruptedException {
        editAddressPage.inputFirstname("a");
        editAddressPage.inputLastname("a");
        editAddressPage.inputCompany("a");
        editAddressPage.inputAddress1("aaa");
        editAddressPage.inputCity("aa");
        editAddressPage.inputPostcode("aa");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Assert.assertEquals(addressBookPage.getUpdateText(), assureString);
    }

    /** This method test Add New Address and Edit Address page with maximum input symbols in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressMaxSymbols() throws InterruptedException {
        editAddressPage.inputFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCompany("a");
        editAddressPage.inputAddress1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCity("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputPostcode("aaaaaaaaaa");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickYesDefault();
        editAddressPage.clickContinueButton();
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Assert.assertEquals(addressBookPage.getUpdateText(), assureString);
    }

    /** This method test Add New Address and Edit Address page with under maximum input symbols in input fields */
    @Test(groups = {"edit", "create"})
    public void editAddressUnderMaxSymbols() throws InterruptedException {
        editAddressPage.inputFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCompany("aa");
        editAddressPage.inputAddress1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputCity("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        editAddressPage.inputPostcode("aaaaaaaaaaa");
        editAddressPage.selectCountry("Togo");
        Thread.sleep(1000);
        editAddressPage.selectZone("Kara");
        editAddressPage.clickNoDefault();
        editAddressPage.clickContinueButton();
        Assert.assertEquals(editAddressPage.getErrorText(), "First Name must be between 1 and 32 characters!");

    }

    /** This method test Back button in Add New Address and Edit Address pages */
    @Test(groups = {"edit", "create"})
    public void editBackButton() {
        editAddressPage.clickBackButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://192.168.112.133/opencart/upload/index.php?route=account/address");
    }

    /** This method test delete button in Address Book page */
    @Test
    public void deleteAddress() throws InterruptedException {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Thread.sleep(1000);
        addressBookPage.deleteClick();
        Assert.assertEquals(addressBookPage.getUpdateText(), "Your address has been successfully deleted");

    }
}