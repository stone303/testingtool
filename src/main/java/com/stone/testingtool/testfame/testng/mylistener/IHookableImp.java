package com.stone.testingtool.testfame.testng.mylistener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

/**
 * @author guocang.shi
 * TestNG在测试方法执行前执行，常用于授权检查。
 */
public class IHookableImp implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        ConstructorOrMethod method = iTestResult.getMethod().getConstructorOrMethod();
        String name = method.getName();
        System.out.println("测试method是 "+name);
        System.out.println("开始执行~");
        //测试用例开始执行
        iHookCallBack.runTestMethod(iTestResult);
        System.out.println("结束~");
    }
}
