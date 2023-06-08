package com.stone.testingtool.testfame.testng;

import com.stone.testingtool.testfame.testng.mylistener.TestListenerAdapterImp;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author guocang.shi
 */

@Listeners(TestListenerAdapterImp.class)
public class TestListener4 {
    @Test
    public void case1(){
        System.out.println("执行了case1测试方法");
    }
}
