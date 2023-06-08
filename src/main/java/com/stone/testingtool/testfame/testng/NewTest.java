package com.stone.testingtool.testfame.testng;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author guocang.shi
 *
 *
 *
 * @DataProvider 标记一种方法来提供测试方法的数据。 注释方法必须返回一个Object [] []，
 * 其中每个Object []可以被分配给测试方法的参数列表。 要从该DataProvider接收数据的@Test方法需要使用与此注释名称相等的dataProvider名称
 * @Factory 将一个方法标记为工厂，返回TestNG将被用作测试类的对象。 该方法必须返回Object []
 * @Listeners 定义测试类上的侦听器
 * @Parameters 描述如何将参数传递给@Test方法
 *
 */
public class NewTest {

    @Test
    public void f() {
        System.out.println("this is new test");
        Assert.assertTrue(true);
    }

    @Test(groups="group1")
    public void test1() {
        System.out.println("test1 from group1");
        Assert.assertTrue(true);
    }

    @Test(groups="group1")
    public void test11() {
        System.out.println("test11 from group1");
        Assert.assertTrue(true);
    }

    @Test(groups="group2")
    public void test2()
    {
        System.out.println("test2 from group2");
        Assert.assertTrue(true);
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("afterTest");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("afterClass");
    }

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("afterSuite");
    }

    //只对group1有效，即test1和test11
    @BeforeGroups(groups="group1")
    public void beforeGroups()
    {
        System.out.println("beforeGroups");
    }

    //只对group1有效，即test1和test11
    @AfterGroups(groups="group1")
    public void afterGroups()
    {
        System.out.println("afterGroups");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("afterMethod");
    }


}


