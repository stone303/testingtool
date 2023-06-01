package com.stone.testingtool.testmocjkio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest {

    /**注解得到的mock对象
     * 等价于
     List<String> mock = Mockito.mock(List.class) */
    @Mock
    List<String> mockList;

    @Test
    public void testRaw(){
        List<String> mock = mock(List.class);
        mock.add("one");
        mock.add("one");
        verify(mock, Mockito.times(2)).add("one");

        when(mock.size()).thenReturn(100);
        assertEquals(100, mock.size());

    }

    @Test
    public void testAnno(){
        mockList.add("one");
        mockList.add("one");
        verify(mockList, Mockito.times(2)).add("one");
        when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }

    @Test
    public void testVerify()
    {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(), 5);

        verify(mockedList, atLeastOnce()).add("one");//至少被调用了 1 次(atLeastOnce)
        verify(mockedList, times(1)).add("two");//被调用了 1 次(times(1))
        verify(mockedList, times(3)).add("three times");//被调用了 3 次(times(3))
        verify(mockedList, never()).isEmpty();//从未被调用(never)


    }
    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);

        // 对 spy.size() 进行定制.
        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");

        // 因为我们没有对 get(0), get(1) 方法进行定制,
        // 因此这些调用其实是调用的真实对象的方法.
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        Assert.assertEquals(spy.size(), 100);


        System.out.println(spy.get(1));
        System.out.println(spy.get(0));
        System.out.println(spy.size());
    }

}
