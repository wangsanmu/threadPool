package com.wangsen.oder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangsen
 * @data 2018/5/3 20:53
 * @des  存放无序 不允许元素重复
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<String>();
        sets.add("垃圾");
        sets.add("水电费");
        sets.add("佛挡杀佛");
        sets.add("饿认识的");
        sets.add("饿认识的");
        Iterator<String> iterator = sets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
