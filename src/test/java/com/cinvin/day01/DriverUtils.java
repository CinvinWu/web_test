package com.cinvin.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Author:Cinvin
//标题
public class DriverUtils {
    public  static WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrom.driver","src\\test\\Resources\\chromedriver.exe");
            ChromeDriver chromeDriver=new ChromeDriver();
            return chromeDriver;
        }
        return null;
    }
}
