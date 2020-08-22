package com.cinvin.pageobject;

import com.cinvin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InvestPage extends BasePage {

    public InvestPage(WebDriver driver) {
        super(driver);
    }

    //投资金额的输入框
    private By investAmountInputBy = By.xpath("//input[@data-url='/Invest/invest']");
    //投资按钮
    private By investButtonBy = By.xpath("//button[text()='投标']");
    //投资成功的提示
    private By investSuccessTipsBy = By.xpath("//div[text()='投标成功！']");
    //标的剩余金额
    private  By bidLeaveAmountBy = By.className("mo_span4");



    public void typeInvestAmount(String investAmount) {
        type(investAmountInputBy, investAmount);
    }

    public void clickInvestButton() {
        click( investButtonBy);
    }

    public String getUserLeaveAmount(){
       return getElementAttributeValue(investAmountInputBy,"data-amount");
    }

    public double getBidLeaveAmount(){
        String bidLeaveAmount = waitElementVisible(bidLeaveAmountBy).getText();
        return Double.valueOf(bidLeaveAmount);
    }

    public boolean isInvestSuccessExist() {
        return isElementVisible(investSuccessTipsBy);
    }
}
