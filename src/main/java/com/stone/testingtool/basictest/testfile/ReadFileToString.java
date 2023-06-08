package com.stone.testingtool.basictest.testfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author guocang.shi
 */
public class ReadFileToString {

    public static void main(String[] args) throws IOException {
        String fileName="D:/workspace/github/testtemp/test.txt";
        List<String> content = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
