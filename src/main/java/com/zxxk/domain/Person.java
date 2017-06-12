package com.zxxk.domain;

/**
 * Created by Administrator on 2017/6/12.
 */
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    private  String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private  int age;
}
