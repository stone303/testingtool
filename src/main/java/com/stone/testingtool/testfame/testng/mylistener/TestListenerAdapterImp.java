package com.stone.testingtool.testfame.testng.mylistener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @author guocang.shi
 *
 * 执行测试方法后执行，主要用于记录log信息，根据执行结果的不同调用不同的方法。
 */
public class TestListenerAdapterImp extends TestListenerAdapter {
    private int m_count = 0;

    @Override
    public void onTestFailure(ITestResult tr) {
        log(tr.getName()+ "--Test method failed\n");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log(tr.getName()+ "--Test method skipped\n");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log(tr.getName()+ "--Test method success\n");
    }

    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}
