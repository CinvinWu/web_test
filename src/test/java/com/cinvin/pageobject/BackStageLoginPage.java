package com.cinvin.pageobject;

import com.cinvin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Author:Cinvin
//标题
public class BackStageLoginPage extends BasePage {
    public BackStageLoginPage(WebDriver driver){
        super(driver);
    }
    //账号
    private By adminBy=By.xpath("//input[@name='admin_name']");
    //密码
    private By passwordBy=By.xpath("//input[@name='admin_pwd']");
    //验证码
    private By codeBy=By.xpath("//input[@name='code']");
    //登录后台
    private By loginBy=By.xpath("//button[text()='登陆后台']");
    //输入账号
    public void typeAdmin(String admin){
        type(adminBy,admin);
    }
    //输入密码
    public void typePwd(String password){
        type(passwordBy,password);
    }
    //输入验证码
    public void typeCode(String code){
        type(codeBy,code);
    }
//    点击登录后台
    public void clickLogin(){
        click(loginBy);
    }
}
