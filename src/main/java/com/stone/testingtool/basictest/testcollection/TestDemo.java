package com.stone.testingtool.basictest.testcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author guocang.shi
 */
public class TestDemo {

    public static void main(String[] args) {
        /**
         * 按照字符串長度排序
         */
        TreeSet s = new TreeSet(new MyComparator());
        s.add("ffffffff");
        s.add("fffff");
        s.add("ff");
        s.add("ffffff");

        Iterator iterator = s.iterator();
        while (iterator.hasNext()) {
            sop(iterator.next());
        }
    }

    // 输出
    public static void sop(Object obj) {
        System.out.println(obj);
    }

    // 定义比较性
    static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.length() - s2.length();
        }
    }
}
