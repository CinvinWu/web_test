package com.cinvin.constants;

import com.cinvin.common.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

//Author:Cinvin
//标题
public class ScreenShot{
    public static void takeScreenShot(WebDriver driver){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        long currentTimeMillis = System.currentTimeMillis();
        String picpath=System.getProperty("user.dir")+"\\"+"screenshot"+currentTimeMillis+".png";
        File targetFile=new File(picpath);
        try {
            FileUtils.copyFile(srcFile,targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] takeScreenShotByte(WebDriver driver){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        byte[] arr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return arr;
    }
}
