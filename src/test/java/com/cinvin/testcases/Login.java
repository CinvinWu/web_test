package com.cinvin.testcases;

import com.cinvin.common.BaseTest;
import com.cinvin.constants.Constants;
import com.cinvin.day01.DriverUtils;
import com.cinvin.listener.TestngRetry;
import com.cinvin.pageobject.IndexPage;
import com.cinvin.pageobject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.*;

import java.security.PublicKey;

//Author:Cinvin
//标题
public class Login extends BaseTest {
    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        //打开浏览器
        openBrowser(Constants.BROWSER_NAME);
        //打开登陆页面
        getUrl(Constants.LOGIN_URL);
        //浏览器最大化
        browserMaxmize();
    }
    @Test(dataProvider = "getLoginFailureDatas001")
    public void testLoginFailure_001(String phone, String password, String expectedValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typePhone(phone);
        loginPage.typePassword(password);
        loginPage.clickButton();
        //等待提示信息出来 --显示等待
        //断言 --根据页面的提示信息-此账号没有经过授权，请联系管理员
        Assert.assertEquals(loginPage.getCenterInfoText(),expectedValue);
    }

    @Test(retryAnalyzer= TestngRetry.class,dataProvider ="getLoginFailureDatas002")
    public void testLoginFailure002(String phone, String password, String expectedValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typePhone(phone);
        loginPage.typePassword(password);
        loginPage.clickButton();
        //断言
        Assert.assertEquals(loginPage.getPhoneErrorInfoText(),expectedValue);
    }
    @DataProvider
    public Object[][] getLoginFailureDatas001() {
        Object[][] datas = {{"15859019266", "123456", "此账号没有经过授权，请联系管理员!"},
                {"13323234545", "LEMON123456", "帐号或密码错误!"},
                {"13323234545", "lemon1234567890", "帐号或密码错误!"},
                {"13323234545", "le", "帐号或密码错误!"},
                {"13323234545", "lemon 123456", "帐号或密码错误!"},
        };
        return datas;

    }
    @DataProvider
    public Object[][] getLoginFailureDatas002() {
        Object[][] datas = {
                {"", "123456", "请输入手机号"},
                {"1585901925", "123456", "请输入正确的手机号"},
                {"158590192534", "123456", "请输入正确的手机号"},
                {"1585901925%", "123456", "请输入正确的手机号"},
                {"13323234545", "","请输入密码"},
        };
        return datas;

    }

    @AfterMethod
    public void TearDownTest(){
//        driver.close();
        quitBrowser();
    }

}
