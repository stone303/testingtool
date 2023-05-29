package com.stone.testingtool.testmocjkio;

import com.stone.testingtool.testmockito.MockitoAnnotationStartup;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MockitoTest  extends MockitoAnnotationStartup {

    /**注解得到的mock对象
     * 等价于
     List<String> mock = Mockito.mock(List.class) */
    @Mock
    List<String> mockList;

    @Test
    public void testRaw(){
        List<String> mock = Mockito.mock(List.class);
        mock.add("one");
        mock.add("one");
        Mockito.verify(mock, Mockito.times(2)).add("one");

        Mockito.when(mock.size()).thenReturn(100);
        assertEquals(100, mock.size());

    }

    @Test
    public void testAnno(){
        mockList.add("one");
        mockList.add("one");
        Mockito.verify(mockList, Mockito.times(2)).add("one");

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

    }


}
