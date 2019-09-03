package com.opencart;

import com.opencart.AddressBookPages.AddressBookPage;
import com.opencart.AddressBookPages.EditAddressPage;
import com.opencart.OrderHistoryPages.OrderDetailPage;
import com.opencart.OrderHistoryPages.OrderHistoryPage;
import com.opencart.OrderHistoryPages.ReturnOrderPage;
import com.opencart.OtherPages.LoginPage;
import com.opencart.OtherPages.MainPage;
import com.opencart.OtherPages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrderHistoryTest {

    private WebDriver driver;
    private OrderHistoryPage orderHistoryPage;
    private OrderDetailPage orderDetailPage;

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
        myAccount.historyLink();
        orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
    }
    @AfterMethod
    public void toHistoryPage() {
        orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
        orderHistoryPage.openPage(driver);
    }
    @AfterClass
    public void exit() {
        driver.close();
    }

    @Test
    public void orderDetailTest() {
        orderHistoryPage.lookClick();
        Assert.assertEquals(driver.getCurrentUrl(),"http://192.168.112.131/opencart/upload/index.php?route=account/order/info&order_id=3");
    }

    @Test
    public void reOrderTest() throws InterruptedException{
        orderHistoryPage.lookClick();
        orderDetailPage = PageFactory.initElements(driver,OrderDetailPage.class);
        orderDetailPage.reorderButtonClick();
        Thread.sleep(1000);
        Assert.assertEquals(orderDetailPage.getActionMessage(),"Success: You have added iPhone to your shopping cart!\n" +
                "×");
    }

    @Test
    public void returnOrderTest() throws InterruptedException{
        orderHistoryPage.lookClick();
        orderDetailPage = PageFactory.initElements(driver,OrderDetailPage.class);
        orderDetailPage.returnButtonClick();
        ReturnOrderPage returnOrderPage = PageFactory.initElements(driver, ReturnOrderPage.class);
        returnOrderPage.selectReturnReason();
        returnOrderPage.submitButtonClick();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"http://192.168.112.131/opencart/upload/index.php?route=account/return/success");
    }



}
