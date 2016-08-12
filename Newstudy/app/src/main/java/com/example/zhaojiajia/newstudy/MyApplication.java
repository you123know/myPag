package com.example.zhaojiajia.newstudy;

import android.app.Application;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/10.
 */
public class MyApplication extends Application {
    public List<Item> list = new ArrayList<Item>();
    public List<Course> listone = new ArrayList<Course>();

    @Override
    public void onCreate() {
        super.onCreate();
        list.add(new Item("选修课程", R.drawable.xxkc));
        list.add(new Item("课程信息", R.drawable.kcxx));
        list.add(new Item("查讯学生信息", R.drawable.xsxx));
        list.add(new Item("课程详细信息", R.drawable.xxkcxx));
        list.add(new Item("帮助", R.drawable.bz));
        list.add(new Item("退出系统", R.drawable.tcxt));
        Teacher teacher1 = new Teacher("王立峰", "男", 32, "专业JAVA基础");
        Teacher teacher2 = new Teacher("张存利", "男", 30, "HTML基础");
        Teacher teacher3 = new Teacher("贺雅薇", "女", 25, "生活老师");
        Course course1 = new Course("JAVA", 20, teacher1);
        Course course2 = new Course("HTML", 20, teacher2);
        Course course3 = new Course("测试", 2, teacher3);
        listone.add(course1);
        listone.add(course2);
        listone.add(course3);
    }
}
