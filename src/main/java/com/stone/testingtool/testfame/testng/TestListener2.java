package com.stone.testingtool.testfame.testng;

import com.stone.testingtool.testfame.testng.mylistener.IInvokedMethodListenerImp;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author guocang.shi
 */
@Listeners(IInvokedMethodListenerImp.class)
public class TestListener2 {
    @Test
    public void case2(){
        System.out.println("执行了case2测试方法");
    }

}
