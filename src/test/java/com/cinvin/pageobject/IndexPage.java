package com.cinvin.pageobject;

import com.cinvin.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Author:Cinvin
//标题
public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver){
        super(driver);
    }
    //主页的昵称元素
    //private By nicknameBy = By.xpath("//a[contains(text(),'"+userNickname+"')]");
    //主页的退出元素
    private By quitBy = By.linkText("退出");
    //主页的登录元素
    private By loginBy = By.linkText("登录");

    //抢投标元素定位
    //private By rushToBidBy = By.xpath()

    //点击抢投标 -参数为项目的标题
    public void clickRushtobid(String bidTitle){
        click(By.xpath("//span[contains(text(),'"+bidTitle+"')]/parent::div/parent::a/following-sibling::div[1]//a[text()='抢投标']"));
    }

    public void clickLogin(){
        //waitElementClickable(driver,loginBy).click();
        click(loginBy);
    }

    public void clickQuit(){
        //waitElementClickable(driver,quitBy).click();
        click(quitBy);
    }

    public boolean isNicknameVisible(String userNickname){
        return isElementVisible(By.xpath("//a[contains(text(),'"+userNickname+"')]"));
        //return waitElementVisible(driver,By.xpath("//a[contains(text(),'"+userNickname+"')]")).isDisplayed();
    }
}
