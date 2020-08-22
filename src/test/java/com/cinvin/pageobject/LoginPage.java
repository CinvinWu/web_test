package com.cinvin.pageobject;

import com.cinvin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Author:Cinvin
//标题
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    //手机号输入框定位
    private By phoneBy=By.name("phone");
    //密码输入框
    private By passwordBy=By.name("password");
    //登录定位
    private By loginbuttonBy=By.xpath("//button[text()='登录']");
    //页面中间提示信息
    private By centerContentBy=By.xpath("//div[@class='layui-layer-content']");
    //输入框提示信息
    private By inputContentBy=By.xpath("//div[@class='form-error-info']");
    //输入手机号
    public void typePhone(String register_phone){
        type(phoneBy,register_phone);
    }
    //输入密码
    public void typePassword(String register_password){
        type(passwordBy,register_password);
    }
    //点击登录
    public void clickButton(){
        click(loginbuttonBy);
    }
    public String getCenterInfoText(){
        //获取中间提示信息
        return getElementText(centerContentBy);
    }
    public String getPhoneErrorInfoText(){
        //获取输入框提示信息
        return getElementText(inputContentBy);
    }
}
