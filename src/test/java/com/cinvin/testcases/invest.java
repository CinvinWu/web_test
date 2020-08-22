package com.cinvin.testcases;

import com.cinvin.common.BasePage;
import com.cinvin.common.BaseTest;
import com.cinvin.constants.Constants;
import com.cinvin.listener.TestngRetry;
import com.cinvin.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Author:Cinvin
//标题
public class invest extends BaseTest {
    String loanTitle="";
    @BeforeMethod
    public void setup(){
        openBrowser("chrome");
        browserMaxmize();
        createBidData();
        getUrl(Constants.LOGIN_URL);
        //前置操作-登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typePhone(Constants.INVEST_MOBILEPHONE);
        loginPage.typePassword(Constants.INVEST_PASSWORD);
        loginPage.clickButton();


    }
    public void createBidData(){
        getUrl(Constants.BACKSTAGE_URL);
        BackStageLoginPage backStageLoginPage=new BackStageLoginPage(driver);
        //后台登录操作
        backStageLoginPage.typeAdmin(Constants.BACKSTAGE_USERNAME);
        backStageLoginPage.typePwd(Constants.BACKSTAGE_PASSWROD);
        backStageLoginPage.typeCode(Constants.BACKSTAGE_VERIFYCODE);
        backStageLoginPage.clickLogin();
        //后胎加标
        BackStageIndexPage backStageIndexPage=new BackStageIndexPage(driver);
        backStageIndexPage.clickLoanManage();
        backStageIndexPage.clickAddBid();
        backStageIndexPage.typeBorrower(Constants.BORROWER_MOBILEPHONE);
        long currentTimeMillis = System.currentTimeMillis();
        loanTitle="测试"+currentTimeMillis;
        backStageIndexPage.typeLoanTitle(loanTitle);
        backStageIndexPage.typeLoanRate("10");
        backStageIndexPage.typeLoanTerm("5");
        backStageIndexPage.typeLoanLimit("500000");
        backStageIndexPage.typeBidTerm("5");
        backStageIndexPage.clickRiskControl();
        backStageIndexPage.typeEvaluteValue("2000000");
        backStageIndexPage.clickProjectImport();
        backStageIndexPage.typeCountry("深圳");
        backStageIndexPage.typeOccupation("测试");
        backStageIndexPage.typeAge("20");
        backStageIndexPage.clickCommit();

        //标的三次审核
        backStageIndexPage.clickLatestBid();
        backStageIndexPage.clickVerify();
        backStageIndexPage.clickVerifyPass();

        backStageIndexPage.clickLatestBid();
        backStageIndexPage.clickVerify();
        backStageIndexPage.clickVerifyPass();

        backStageIndexPage.clickLatestBid();
        backStageIndexPage.clickVerify();
        backStageIndexPage.clickVerifyPass();

    }
    @Test(retryAnalyzer = TestngRetry.class)
    public void testInvestSuccess(){
        //1、根据项目的标题选择对应的抢投标元素，点击
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickRushtobid(loanTitle);
        InvestPage investPage = new InvestPage(driver);
        //2、投资之前获取到用户的可用余额、标的可投资金额
        String beforeLeaveAmount = investPage.getUserLeaveAmount();
        double beforeBidLeaveAmount = investPage.getBidLeaveAmount();
        //3、进入到投资页面输入投资金额
        investPage.typeInvestAmount("1000");
        //4、点击投资按钮
        investPage.clickInvestButton();
        //断言 -- 根据投标成功！的提示信息与否做断言
        Assert.assertTrue(investPage.isInvestSuccessExist());
        //刷新浏览器
        browserRefresh();
        //5、投资之后获取到用户的可用余额、标的剩余可投资金额
        //Assert.assertEquals();
        double afterBidLeaveAmount = investPage.getBidLeaveAmount();
        String afterLeaveAmount = investPage.getUserLeaveAmount();
        double actualValue = Double.valueOf(beforeLeaveAmount) - Double.valueOf(afterLeaveAmount);
        //断言-用户的余额是否减少了对应的
        Assert.assertEquals(actualValue,1000);
        int actualBidAmount = (int) ((beforeBidLeaveAmount-afterBidLeaveAmount)*10000);
        //断言--标的金额是否减少了对应的
        Assert.assertEquals(actualBidAmount,1000);
        //数据库查询？？？没有必要去做的 接口阶段保证的
    }

    @AfterMethod
    public void tearDownMethod(){
        quitBrowser();
    }
}
