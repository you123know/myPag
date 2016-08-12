package com.example.zhaojiajia.newstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

public class StudentView extends AppCompatActivity {
    private ListView listView;
    private List<Student> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        ActivityManager.add(this);
        Intent intent = getIntent();
        list = ((Course) intent.getSerializableExtra("student")).getList();
        listView = (ListView) findViewById(R.id.stulistview);
        BaseAdapter baseAdapter = new StuAdapter(this, list);
        listView.setAdapter(baseAdapter);
    }
}
