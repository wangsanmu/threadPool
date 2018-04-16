package com.wangsen.callback;

/**
 * @author wangsen
 * @data 2018/4/13 20:59
 */
public class CallBackTest {

    public static void main(String[] args) {
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();

    }
}
