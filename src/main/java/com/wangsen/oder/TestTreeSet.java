package com.wangsen.oder;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wangsen
 * @data 2018/5/3 21:08
 * @des 顺便测试final 的用处指向对象不能再指向其他对象
 */
public class TestTreeSet {

    private static User user = new User(1,11);

    public static void main(String[] args) {
        User user1 = new User(11,1);
        user = user1;
        TreeSet<Student> treeSets = new TreeSet<Student>();
        treeSets.add(new Student(11,"王森"));
        treeSets.add(new Student(11,"王森2"));
        treeSets.add(new Student(133,"王森"));
        treeSets.add(new Student(1,"王森4"));
        treeSets.add(new Student(3,"王森3"));
        Iterator<Student> iterator = treeSets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
