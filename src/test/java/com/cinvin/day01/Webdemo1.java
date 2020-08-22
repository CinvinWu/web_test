package com.cinvin.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Author:Cinvin
//标题
public class Webdemo1 {
    public static void main(String[] args) {
        WebDriver driver=DriverUtils.getDriver("chrome");
        driver.get("C:\\Users\\10725\\Desktop\\作业\\web\\web03\\iframe\\a.html");
        //定位a输入框元素
        WebElement aaElement = driver.findElement(By.xpath("//input[@id='aa']"));
        //输入AAA
        aaElement.sendKeys("AAA");
        //跳转到b.html的iframe
        driver.switchTo().frame(driver.findElement(By.id("bframe")));
        //输入BBB
        driver.findElement(By.id("bb")).sendKeys("BBB");
        //跳转到c.html的iframe
        driver.switchTo().frame(driver.findElement(By.id("cframe")));
        //输入CCC
        driver.findElement(By.id("cc")).sendKeys("CCC");
        //回到b.html的iframe
        driver.switchTo().parentFrame();
        //清除b输入框的内容并输入DDD
        driver.findElement(By.id("bb")).clear();
        driver.findElement(By.id("bb")).sendKeys("DDD");
        //回到a.html输入完成
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='aa']")).clear();
        driver.findElement(By.xpath("//input[@id='aa']")).sendKeys("完成");
    }
}
