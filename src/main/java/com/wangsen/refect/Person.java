package com.wangsen.refect;

import java.io.Serializable;

/**
 * @author wangsen
 * @data 2018/4/20 18:59
 * @des
 */
public class Person implements Serializable{

    private String name;
    private String gender;
    private int age;

    public Person() {

    }
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
