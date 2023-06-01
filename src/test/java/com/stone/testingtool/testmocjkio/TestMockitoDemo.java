package com.stone.testingtool.testmocjkio;

import com.stone.testingtool.testmockito.Calculator;
import com.stone.testingtool.testmockito.Testmock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/***
//这是一个类级别的注释。它用于保持测试干净并改善调试。
//它还会检测测试中可用的未使用的存根, 并使用@Mock注释对模拟进行初始化。
//@RunWith批注在org.mockito.junit包中可用。以下代码段显示了如何使用@RunWith批注：

 它允许创建字段级参数捕获器。它与Mockito的verify()方法一起使用, 以获取调用方法时传递的值。
 //创建一个实例，简单的说是这个Mock可以调用真实代码的方法，其余用@Mock(或@Spy)注解创建的mock将被注入到用该实例中。@InjectMocks
 // 注：ToDoService 不能是接口，而是一个具体实现类

 //Mock 对函数的调用均执行mock(即虚假函数)，不执行真正部分。
 Spy对函数的调用均执行真正部分。


 */
@RunWith(MockitoJUnitRunner.class)
public class TestMockitoDemo {


    //异常断言 方式1  @Test(expected=RuntimeException.class) 在运行时忽略某个异常
    //异常断言 方式2   @Rule 能够验证异常信息,及异常

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void mockTest01() {

        List list = mock(List.class);

        doThrow(new RuntimeException("test")).when(list).add(1);
            //执行时抛出异常
        exception.expect(RuntimeException.class);
        exception.expectMessage("test");//够验证异常信息
        list.add(1);


    }

    @Test(expected=RuntimeException.class)
    public void mockTest02() {
        try {
            List list = mock(List.class);

            doThrow(new RuntimeException("test")).when(list).add(1);
            //执行时抛出异常
            list.add(1);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    @Test
    public void mockTest03() {
        LinkedList mockedList = mock(LinkedList.class);

        // 使用内置的anyInt()参数匹配器
        when(mockedList.get(anyInt())).thenReturn("element");
        // 使用自定义的参数匹配器(在isValid()函数中返回你自己的匹配器实现)
//输出element
        System.out.println(mockedList.get(999));
// 你也可以验证参数匹配器
        verify(mockedList).get(anyInt());
    }


    //verifyNoMoreInteractions验证冗余互动行为
    @Test(expected = NoInteractionsWanted.class)
    @SuppressWarnings("unchecked")
    public void mockTest04() {
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        verify(list, times(2)).add(anyInt());
        // 检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到
        // 所以下面的代码会通过
        verifyNoMoreInteractions(list);
        List list2 = mock(List.class);
        list2.add(1);
        list2.add(2);
        verify(list2).add(1);
        // 检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常
        verifyNoMoreInteractions(list2);

    }
    //thenAnswer为回调做测试桩
    //InvocationOnMock 用于表示对 Mock 对象的方法调用。它包含了方法调用的相关信息，例如方法名、参数、Mock 对象等。
    @Test
    public void testThenAnswer()
    {
        Calculator calculator = mock(Calculator.class);

        when(calculator.add(anyInt(), anyInt()))
                .thenAnswer((InvocationOnMock invocation) -> {
                    Object[] args = invocation.getArguments();
                    int result = ((int) args[0] + (int) args[1]) / 2;
                    return result;
                });
        System.out.println(calculator.add(5,9));

        Testmock testmock = mock(Testmock.class);
        // 运行为泛型接口Answer打桩
        when(testmock.someMethod(anyString())).thenAnswer(new Answer() {
             public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock().toString();
                 try {
                     Object methodname = invocation.callRealMethod().toString();
                     return "called with arguments: " + args[0].toString() + mock + methodname;
                 } catch (Throwable throwable) {
                     throwable.printStackTrace();
                 }
                 return "called with arguments: " + args[0].toString() + mock;
            }
        });

        System.out.println(testmock.someMethod("foo"));

    }


}
