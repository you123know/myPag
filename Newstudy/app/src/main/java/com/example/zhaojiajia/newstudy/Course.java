package com.example.zhaojiajia.newstudy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/10.
 */
public class Course implements Serializable {
    private String courseName;
    private Teacher teacher;
    private List<Student> list = new ArrayList<Student>();
    private int maxNum;

    public Course(String courseName, int maxNum, Teacher teacher) {
        this.courseName = courseName;
        this.maxNum = maxNum;
        this.teacher = teacher;
    }

    public int addStudent(Student student) {
        if (list.contains(student) ) {
            return 0;
        }
        if(list.size() >= maxNum){
            return 1;
        }
        list.add(student);
        return 2;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getList() {

        return list;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
