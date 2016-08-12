package com.example.zhaojiajia.newstudy;

import java.io.Serializable;

/**
 * Created by zhaojiajia on 2016/8/10.
 */
public class Teacher implements Serializable {
    private String name;
    private String sex;
    private int age;
    private String message;

    public Teacher(String name, String sex, int age, String message) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
