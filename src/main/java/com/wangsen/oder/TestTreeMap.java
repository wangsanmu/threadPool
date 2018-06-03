package com.wangsen.oder;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author wangsen
 * @data 2018/5/3 22:21
 * @des
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a","sdf");
        map.put("b","sdf1");
        map.put("c","sdf2");
        map.put("d","sdf2");
        map.put("lj","sdf2");
        map.put("f","sdf2");
        map.put("g","sdf2");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String,String> entry:entries){
            System.out.println(entry.getKey()+"-----------"+entry.getValue());
        }
    }
}
