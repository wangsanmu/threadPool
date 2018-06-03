package com.wangsen.oder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangsen
 * @data 2018/5/3 20:51
 * @des 存放顺序有序
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("王森");
        list.add("两件事");
        list.add("打扫房间");
        list.add("打扫房间");
        for(String s : list){
            System.out.println(s);
        }
    }
}
