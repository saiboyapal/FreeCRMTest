package com.crm.qa.tests;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginPageTest extends Testbase {
    LoginPage loginPage;
    HomePage homePage;

    public loginPageTest() {
        super();
    }

    @BeforeTest
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageTitleTest(){
        String sTitle = loginPage.loginPageTitle();
        Assert.assertEquals( sTitle,"Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority = 2)
    public void validateCRMLogoTest(){
        Assert.assertTrue(loginPage.crmLogDisplayed());
    }

    @Test(priority = 3)
    public void validateLoginTest(){
        homePage = loginPage.login(prop.getProperty("emailID"),prop.getProperty("password"));
        String sTitle = homePage.homePageTitle();
        Assert.assertEquals( sTitle,"Cogmento CRM");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
