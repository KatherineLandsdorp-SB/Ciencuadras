package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RunnerLogin extends BaseTest {
    StepsLogin steps;

    @Test(id = 37)
    public void loginWithoutRegistration() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(37);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");

        steps = new StepsLogin(mobileElements);
        steps.loginTabClick("commons_loginTab")
                .fillAll("commons_emailField",mail,"commons_passField",password,
                "commons_buttonLogin")
                .assertVerifyCase("commons_labelLoginFail",validate);

        DriverMobileBase.quitDriver();
    }

    @Test(id = 38)
    public void loginWithEmptyFields() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(38);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");

        steps = new StepsLogin(mobileElements);
        steps.loginTabClick("commons_loginTab")
                .fillAll("commons_emailField",mail,"commons_passField",password,
                        "commons_buttonLogin")
                .assertVerifyCase("commons_labelLoginFail2",validate);

        DriverMobileBase.quitDriver();
    }

    @Test(id = 42)
    public void loginWithInvalidMailFormat() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(42);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");

        steps = new StepsLogin(mobileElements);
        steps.loginTabClick("commons_loginTab")
                .fillAll("commons_emailField",mail,"commons_passField",password,
                "commons_buttonLogin")
                .assertVerifyCase("commons_labelLoginFail3",validate);

        DriverMobileBase.quitDriver();
    }

    @Test(id = 43)
    public void loginSuccessfully() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(43);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");

        steps = new StepsLogin(mobileElements);
        steps.loginTabClick("commons_loginTab")
                .fillAll("commons_emailField",mail,"commons_passField",password,
                        "commons_buttonLogin");
                //.assertVerifyCase("commons_labelLoginFail3",validate);

        DriverMobileBase.quitDriver();
    }
   /* @Test(id = 38)
    public void loginWithoutRegistratio2n() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(38);
        steps = new StepsLogin(elements);
        steps.loginTabClick()
                .fillAll();
        DriverMobileBase.quitDriver();
    }*/







/*    @Test(id = 38)
    public void loginWithEmptyFields() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(38);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");
        steps = new StepsLogin(elements);
        //steps.loginTabClick("commons_loginTab")
                //.fillMail("commons_emailField",mail)
                //.fillPassword("commons_passField",password)
                //.clickLoginButton("commons_buttonLogin")
                //.clickLoginButton("commons_buttonLogin")
                //.assertLoginFail("commons_labelLoginFail2",validate);

        DriverMobileBase.quitDriver();
    }*/
    /*@Test(id = 39)
    public void loginRemember() throws Exception {
        DriverMobileBase.getDriver();
        Data.initData(39);
        String mail = Data.getDataField("mail");
        String password = Data.getDataField("password");
        String validate = Data.getAssertField("validate");
        steps = new StepsLogin(elements);
        /*steps.loginTabClick("commons_loginTab")
                .fillMail("commons_emailField",mail)
                .fillPassword("commons_passField",password)
                .clickLoginButton("commons_buttonLogin")
                .clickLoginButton("commons_buttonLogin")
                .assertLoginFail("commons_labelLoginFail2",validate);*/

  //      DriverMobileBase.quitDriver();
//    }

    /*@Test(id = 2)
    public void WebAmazonTest() throws Exception {
        WebDriver driverWeb = DriverWebBase.getDriver();
        driverWeb.get("https://www.amazon.com/-/es/b?ie=UTF8&node=20574825011");
        WebElement element = driverWeb.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("computador");
        element.submit();
        DriverWebBase.quitDriver();
    }
*/
  /*  @Test(id = 3)
    public void WebAmazonTest2() throws Exception {
        WebDriver driverWeb = DriverWebBase.getDriver();
        driverWeb.get("https://www.amazon.com/-/es/b?ie=UTF8&node=20574825011");
        WebElement element = driverWeb.findElement(By.id("twotabsearchtextbox"));
        element.sendKeys("bicicleta");
        element.submit();
        DriverWebBase.quitDriver();
    }*/
}
