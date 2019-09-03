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

public class OpenCartTest {
    private WebDriver driver;
    private EditAddressPage editAddressPage;
    private AddressBookPage addressBookPage;
    private String assureString;

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

    @AfterClass(alwaysRun = true)
    public void exit() {
        driver.close();
    }

    @BeforeGroups(groups = "edit")
    public void toEdit() {
        assureString = "Your address has been successfully updated";
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.editClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    @BeforeGroups(groups = "create")
    public void toCreate() {
        assureString = "Your address has been successfully inserted";
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.newAddressClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    @AfterMethod(groups = "create")
    public void toAddressBookCreate() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.openPage(driver);
        addressBookPage.newAddressClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

    @AfterMethod(groups = "edit")
    public void toAddressBookEdit() {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.openPage(driver);
        addressBookPage.editClick();
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
    }

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
        Assert.assertEquals(editAddressPage.getErorrText(), "First Name must be between 1 and 32 characters!");
    }

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
        Assert.assertEquals(editAddressPage.getErorrText(), "First Name must be between 1 and 32 characters!");

    }

    @Test(groups = {"edit", "create"})
    public void editBackButton() {
        editAddressPage.clickBackButton();
        Assert.assertEquals(driver.getCurrentUrl(), "http://192.168.112.131/opencart/upload/index.php?route=account/address");
    }

    @Test
    public void deleteAddress() throws InterruptedException {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        Thread.sleep(1000);
        addressBookPage.deleteClick();
        Assert.assertEquals(addressBookPage.getUpdateText(), "Your address has been successfully deleted");

    }

    @Test
    public void deleteAddressNeg() throws InterruptedException {
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        addressBookPage.deleteClick();
        Thread.sleep(1000);
        Assert.assertEquals(addressBookPage.getWarningText(), "Warning: You can not delete your default address!");

    }
}