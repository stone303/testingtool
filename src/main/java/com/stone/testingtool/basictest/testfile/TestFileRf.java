package com.stone.testingtool.basictest.testfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author guocang.shi
 */
public class TestFileRf {

    public static void main(String[] args) {

        try {
            // 创建一个读取流对象和文件相关联
            FileReader fr = new FileReader("D:/workspace/github/testtemp/test.txt");
            // 为了提高效率，加入缓冲技术
            BufferedReader bfr = new BufferedReader(fr);

            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
