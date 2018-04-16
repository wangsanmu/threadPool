package com.wangsen.callback;

import java.util.List;

/**
 * @Des :回调机制
 * @author wangsen
 * @data 2018/4/13 20:53
 */
public class Teacher implements Callback,Runnable{

    private Student student;

    private List<Student> studentList;

    public Teacher(List<Student> list){
        this.studentList = list;
    }

    public Teacher(Student student){
        this.student = student;
    }

    public void askQuestion(){
        student.resolveQuestion(this);
    }

    @Override
    public void tallAnswer(int answer) {
        System.out.println("知道了你的答案是:"+answer);
    }

    @Override
    public void run() {

    }
}
