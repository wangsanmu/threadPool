package com.wangsen.oder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangsen
 * @data 2018/5/3 15:29
 * @des
 */
public class NumOder {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(2);
        nums.add(1);
        nums.add(5);
        nums.add(7);
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }
}
