package com.cinvin.listener;

import com.cinvin.common.BaseTest;
import com.cinvin.constants.ScreenShot;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

//Author:Cinvin
//标题
public class TestResultlistener implements IHookable {

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        //获取异常不为空
        if (iTestResult.getThrowable()!=null){
            BaseTest baseTest =(BaseTest) iTestResult.getInstance();
            byte[] arr = ScreenShot.takeScreenShotByte(baseTest.driver);
            saveScreenshot(arr);
        }
    }
    //value:附件名 type：附件类型
    @Attachment(value="Page Screen",type="image/png")
    public byte[] saveScreenshot(byte[] screenShot){
        return screenShot;
    }
}
