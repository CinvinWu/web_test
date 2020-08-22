package com.cinvin.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//Author:Cinvin
//标题
public class webdemo2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=DriverUtils.getDriver("chrome");
        //进入社区
        driver.get("http://www.lemfix.com/");
        Thread.sleep(2000);
        //点击登录
        driver.findElement(By.xpath("//a[text()='登录']")).click();
        Thread.sleep(2000);
        //输入用户名
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Cinvin");
        //输入密码
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("0110019591");
        //点击登录
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);
        //点击文章
        driver.findElement(By.xpath("//a[@title='Flutter 自动化测试-集成测试篇']")).click();
        Thread.sleep(2000);
        //下拉到评论框
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('reply-button').scrollIntoView(0)");
        //输入回帖内容
        driver.findElement(By.id("reply_body")).sendKeys("666");
        //点击提交回复
        driver.findElement(By.xpath("//button[text()='提交回复']")).click();
    }
}
