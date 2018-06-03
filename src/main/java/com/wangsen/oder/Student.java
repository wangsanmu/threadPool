package com.wangsen.oder;

/**
 * @author wangsen
 * @data 2018/5/3 20:41
 * @des
 */
public class Student implements Comparable<Student>{

    private int age;

    private String name;

    private String weight;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        
    }

    @Override
    public int compareTo(Student student) {
        int i = this.getName().compareTo(student.getName());
        if(i == 0){
          return  this.getAge() - student.getAge();

        }
        return i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return weight != null ? weight.equals(student.weight) : student.weight == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
