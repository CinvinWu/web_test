package com.cinvin.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//Author:Cinvin
//标题
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //1.得到test注解的参数对象reterAnalyzer
        IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
        //2.判断@Test注解里面有没有加上reterAnalyzer参数
        if (retryAnalyzer==null){
            //3.给retryAnalyzer设置值：重试机制监听类
            annotation.setRetryAnalyzer(TestngRetry.class);
        }
    }
}
