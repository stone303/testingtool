package com.stone.testingtool.testfame.testng;

import org.testng.annotations.Test;

public class ExceptionTest {
    //TestNG预期异常测试
    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
        System.out.println("After division the value of i is :"+ i);
    }

    @Test(enabled=false)
    public void TestNgLearn1() {
        System.out.println("this is TestNG test case1");
    }

    @Test
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }

    @Test(timeOut = 5000) // time in mulliseconds
    public void testThisShouldPass() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(timeOut = 1000)
    public void testThisShouldFail() {
        while (true){
            // do nothing
        }
    }
}
