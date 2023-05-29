package com.stone.testingtool.testmocjkio;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.*;


/**
 * @author guocang.shi
 */
public class SimpleTest {

    @Test
    public void test(){
        // 创建Mock对象，参数可以是类或者接口
        List<String> list = mock(List.class);

        list.add("one");
        // 获取mock对象的实际方法，获取size，结果为0
        System.out.println("mockList.size(): " + list.size());
        // toString方法
        System.out.println("mockList's toString is: " + list);
        // 调用mock对象的方法

        //设置方法的预期返回值
        when(list.get(0)).thenReturn("zuozewei");
        when(list.get(1)).thenThrow(new RuntimeException("test exception"));

        String result = list.get(0);

        // 验证mock对象mockList的add方法是否被调用了一次
        Mockito.verify(list).add("one");
        //验证方法调用
        //verify(list).get(1);

        //断言，list的第一个元素是否是"zuozwei"
        Assert.assertEquals(result,"zuozewei");

    }

}
