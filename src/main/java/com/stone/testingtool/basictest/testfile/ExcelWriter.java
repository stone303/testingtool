package com.stone.testingtool.basictest.testfile;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author guocang.shi
 */
public class ExcelWriter {

    public static void main(String[] args) {
        try {
            // 创建Excel文件
            Workbook workbook = WorkbookFactory.create(true);
            Sheet sheet = workbook.createSheet("Sheet1");

            // 写入数据
            Row row = sheet.createRow(0);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue("Hello");
            Cell cell2 = row.createCell(1);
            cell2.setCellValue("World");

            // 保存Excel文件
            FileOutputStream outputStream = new FileOutputStream(new File("D:/workspace/github/testtemp/test.xlsx"));
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
