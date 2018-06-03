package com.wangsen.oder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wangsen
 * @data 2018/5/3 21:07
 * @des hashMap 无序 containKey要重写hashcode 和  equals
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("wangsen","32423");
        map.put("wangsen","32421");
        map.put("wangsen1","32421");
        map.put("wangsen2","32421");
        map.put("wangsen3","32421");
        map.put("wangsen4","32421");
        map.put("wangsen5","32421");
        map.put("wangsen6","32421");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String,String> entry:entries){
            System.out.println(entry.getKey()+"------------"+entry.getValue());
        }
        if(map.containsKey("wangsen")){
            System.out.println("有wangsen");
        }

        Map<Student,String> map1 = new HashMap<Student,String>();
        map1.put(new Student(11,"王森"),"王");
        map1.put(new Student(12,"王森"),"王");
        map1.put(new Student(14,"王森"),"王");
        map1.put(new Student(10,"王森"),"王");
        map1.put(new Student(11,"王森"),"王");
        if(map1.containsKey(new Student(11,"王森"))){
            System.out.println("有wangsen");
        }
    }
}

