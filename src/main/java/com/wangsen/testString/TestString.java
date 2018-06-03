package com.wangsen.testString;

/**
 * @author wangsen
 * @data 2018/5/10 21:15
 * @des
 */
public class TestString {

    public static final String a = "hellow";

    public static void main(String[] args) {
        String s = "hellow";
        String s1 =  "llow";
        System.out.println(s == "he"+"llow");
        System.out.println(s == s1+"llow");
        System.out.println(s == a);
        System.out.println(s == TestString.a);
        System.out.println(s == TestString.A.A);
        System.out.println(s == new TestString().new B().b);
    }

    static class  A {
        public static String A = "hellow";
    }

    class B {
        public String b = "hellow";
    }

}
