package com.stone.testingtool.basictest.testcollection;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author guocang.shi
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet=new TreeSet();
        treeSet.add("abc");
        treeSet.add("abf");
        treeSet.add("acc");
        treeSet.add("aef");

        Iterator iterator =treeSet.iterator();
        while(iterator.hasNext())
        {
            sop(iterator.next());
        }
    }

    // 输出
    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
