package com.example.zhaojiajia.newstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TeacherView extends AppCompatActivity {
    private Teacher teacher;
    private TextView teacherName;
    private TextView teacherSex;
    private TextView teacherAge;
    private TextView teacherMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view);
        ActivityManager.add(this);
        teacherName = (TextView) findViewById(R.id.teachernames);
        teacherSex = (TextView) findViewById(R.id.teachersexs);
        teacherAge = (TextView) findViewById(R.id.teacherages);
        teacherMessage = (TextView) findViewById(R.id.teachermessages);
        Intent intent = getIntent();
        teacher = (Teacher) intent.getSerializableExtra("teacher");
        if (teacher != null) {
            teacherName.setText(teacher.getName());
            teacherAge.setText(teacher.getAge() + "岁");
            teacherSex.setText(teacher.getSex());
            teacherMessage.setText(teacher.getMessage());
        }
    }
}
