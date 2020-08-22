package com.cinvin.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Author:Cinvin
//标题
public class TestngRetry implements IRetryAnalyzer {
    public int maxRetryCount=2;
    public int currentRetryCount=0;
    private Logger logger=Logger.getLogger(TestngRetry.class);
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentRetryCount<maxRetryCount){
            currentRetryCount++;
            logger.info("当前运行第"+currentRetryCount+"次失败重试机制");
            return true;
        }else {
            return false;
        }
    }
}
