package com.example.zhaojiajia.newstudy;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by zhaojiajia on 2016/8/10.
 */
public class Student  implements Serializable  {
    private String name;
    private String sex;
    private int age;

    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
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
}
