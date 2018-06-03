package com.wangsen.refect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangsen
 * @data 2018/4/20 19:00
 * @des
 */
public class PersonTest {


    public static void main(String[] args) {
        Person person = new Person();
        person.setName("wangsen");
        person.setGender("楠");
        person.setAge(11);
        getPersonTest(person);
    }

    public static void getPersonTest(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            String  fileName = "get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            try {
                Method getter = object.getClass().getMethod(fileName);
                String value =  getter.invoke(object)+"";
                if(value == null || "" == value){
                    System.out.println("不能为空");
                }else{
                    System.out.println(value);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
