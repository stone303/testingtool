package com.stone.testingtool.basictest.testfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author guocang.shi
 */
public class TestFileRw {

    public static void main(String[] args) {
        /**
         * 需求：在硬盘上创建一个文件，并且写入数据
         */
        // 一被初始化就必须要有被操作的文件
        // 如果不指定位置，就创建在同目录下
        // 如果目录下存在同名文件，覆盖
        try {
            FileWriter fileWriter = new FileWriter("D:/workspace/github/testtemp/test.txt",true);
            // 写入数据到内存
           // fileWriter.write("abcde");
            // 关闭流 关闭之前会刷新，和flush的区别在于flush刷新后流可以继续工作
            //fileWriter.close();

            // 为了提高写入流的效率加入了缓冲技术
            BufferedWriter bufw = new BufferedWriter(fileWriter);
            //写入数据
            bufw.write("hello");
            //换行
            bufw.newLine();

            bufw.write("你好");
            //只要用到了缓冲区，就需要刷新
            bufw.flush();

            //缓冲区关闭的就是关联的流
            bufw.close();

            // 刷新该流的缓冲
            // fileWriter.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
