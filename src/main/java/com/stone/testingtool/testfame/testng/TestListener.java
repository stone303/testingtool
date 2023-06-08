package com.stone.testingtool.testfame.testng;

import com.stone.testingtool.testfame.testng.mylistener.IHookableImp;
import com.stone.testingtool.testfame.testng.mylistener.IInvokedMethodListenerImp;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author guocang.shi
 */
@Listeners(IHookableImp.class)
public class TestListener {

    @Test
    public void case1(){
        System.out.println("case1方法");
    }



}
