package com.wangsen.oder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangsen
 * @data 2018/5/3 15:33
 * @des
 */
public class User implements Comparable<User>{

    private int score;

    private int age;

    public User(int score,int age){
        super();
        this.score = score;
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int i =  this.getAge() - o.getAge();
//        if(i == 0 ){
//            return this.score - o.getScore();
//        }
        return i;
    }


    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(11,12));
        userList.add(new User(12,12));
        userList.add(new User(10,82));
        userList.add(new User(10,42));
        userList.add(new User(13,82));
        Collections.sort(userList);
        for(User user:userList){
            System.out.println(user.getAge()+"................."+user.getScore());
        }
    }

}
