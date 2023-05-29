package com.stone.testingtool.testmocjkio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.List;

public class WhenTest {
    @Test
    public void Test() {
        List mock = Mockito.mock(List.class);
        Mockito.when(mock.size()).thenReturn(-1);
        System.out.println("mock.size():" + mock.size());


        // 连续存根
        Mockito.when(mock.size()).thenReturn(1).thenReturn(2).thenReturn(3);
        for (int i = 1; i <= 5; i++) {
            System.out.println("=====连续存根方式1：=====： " + mock.size());
        }

        Mockito.when(mock.size()).thenReturn(1, 2, 3);
        for (int i = 1; i <= 5; i++) {
            System.out.println("#####连续存根方式2：#####： " + mock.size());
        }

        // 模拟异常
        Mockito.when(mock.size()).thenThrow(new RuntimeException(), new NullPointerException());
        try {
            mock.size();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            mock.size();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
