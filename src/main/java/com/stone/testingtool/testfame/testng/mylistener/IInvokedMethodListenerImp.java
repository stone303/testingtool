package com.stone.testingtool.testfame.testng.mylistener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * @author guocang.shi
 *
 * //IINvokedmethodl：TestNG在调用方法前、后启用该监听器，常用于日志的采集。
 */
public class IInvokedMethodListenerImp implements IInvokedMethodListener {
    //TestNG在调用方法前、后启用该监听器，常用于日志的采集。
    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        // TODO Auto-generated method stub
        //获取执行的@Test方法
        System.out.println(iTestResult.getName());
    }
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        // TODO Auto-generated method stub
        //获取执行的@Test方法
        System.out.println(iTestResult.getName());
    }
}
