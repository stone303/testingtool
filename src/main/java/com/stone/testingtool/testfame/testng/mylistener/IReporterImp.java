package com.stone.testingtool.testfame.testng.mylistener;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author guocang.shi
 *
 * IReporter：在测试方法执行后执行，通过遍历 xmlSuites 和 suites 能够获取所有测试方法的信息以及测试结果，后续可用于自定义测试报告。
 */
public class IReporterImp implements IReporter {
    //通过遍历 xmlSuites 和 suites 能够获取所有测试方法的信息以及测试结果，后续可用于自定义测试报告。
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String outputDirectory) {

        for(ISuite iSuite:iSuites){
            Map<String, ISuiteResult> iSuiteResultMap = iSuite.getResults();
            //获取所有执行的方法
            System.out.println("所有执行的方法："+iSuite.getAllInvokedMethods());
            //获取所有@Test标注的方法
            System.out.println("获取所有@Test标注的方法："+iSuite.getAllMethods());
            //获取suite标签的name属性
            System.out.println("suiteName："+iSuite.getName());
            //获取测试报告的输出路径
            System.out.println("输出路径："+iSuite.getOutputDirectory());
            System.out.println("报告路径："+outputDirectory);
            //获取并发方式
            System.out.println("并发方式："+iSuite.getParallel());

            for(ISuiteResult iSuiteResult:iSuiteResultMap.values()){
                ITestContext iTestContext = iSuiteResult.getTestContext();
                IResultMap iResultMap = iTestContext.getPassedTests();

                Set<ITestResult> iTestResultset = iResultMap.getAllResults();
                for(ITestResult iTestResult:iTestResultset){
                    //获取执行的Test方法
                    System.out.println("测试方法："+iTestResult.getName());
                    //获取执行结果
                    System.out.println("执行结果（1-成功，2-失败，3-skip）："+iTestResult.getStatus());
                    //获取开始执行的时间
                    System.out.println("开始时间："+iTestResult.getStartMillis());
                    //获取结束执行的时间
                    System.out.println("结束时间："+iTestResult.getEndMillis());
                }
            }
        }
    }
}
