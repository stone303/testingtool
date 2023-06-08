package com.stone.testingtool.basictest.testcollection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author guocang.shi
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet h = new HashSet();
        h.add("hello 01");
        h.add("hello 02");
        h.add("hello 03");
        h.add("hello 04");

        // set取出只有一种办法，迭代器
        Iterator iterator = h.iterator();
        while (iterator.hasNext()) {
            sop(iterator.next());
        }

    }
    // 输出
    //HashSet 内部存储元素的顺序是根据元素的哈希值来决定的，而不是根据元素添加的顺序来决定的

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
