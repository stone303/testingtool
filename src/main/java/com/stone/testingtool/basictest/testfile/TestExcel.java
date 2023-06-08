package com.stone.testingtool.basictest.testfile;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author guocang.shi
 *
 * 常用的Workbook实现类有HSSFWorkbook（用于处理.xls格式的Excel文件）和XSSFWorkbook（用于处理.xlsx格式的Excel文件）。
 */
public class TestExcel {

    public static void main(String[] args)  {
        try {
            // 打开Excel文件
            File file = new File("D:/workspace/github/testtemp/事件记录.xls");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(inputStream);

            // 读取第一个工作表
            Sheet sheet = workbook.getSheetAt(0);

            // 遍历每一行
            for (Row row : sheet) {
                // 遍历每一列
                for (Cell cell : row) {
                    // 输出单元格的值
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            // 关闭文件流
            inputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
