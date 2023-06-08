package com.stone.testingtool.testfame.testng;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author guocang.shi
 */
@Test(groups= "group2")
public class TestCase1 {
    @Test(enabled=true)
    @Parameters({"param1", "param2"})
    public void TestNgLearn1(String param1, int param2) {
        System.out.println("this is TestNG test case1, and param1 is:"+param1+"; param2 is:"+param2);
    }

    @Test(dependsOnMethods= {"TestNgLearn1"})
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }
}
