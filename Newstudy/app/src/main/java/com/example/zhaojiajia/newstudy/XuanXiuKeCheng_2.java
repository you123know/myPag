package com.example.zhaojiajia.newstudy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class XuanXiuKeCheng_2 extends AppCompatActivity {
    private List<Course> list;
    private BaseAdapter baseAdapter;
    private ListView listView;
    private MyApplication myApplication;
    private int select = -1;
    private Button button;
    private Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuan_xiu_ke_cheng_2);
        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("student");
        myApplication = (MyApplication) getApplication();
        ActivityManager.add(this);
        listView = (ListView) findViewById(R.id.xxkc2_list);
        list = myApplication.listone;
        button = (Button) findViewById(R.id.xxkc2_button);
        baseAdapter = new CourseAdapter(-1, this, list);
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                baseAdapter = new CourseAdapter(position, XuanXiuKeCheng_2.this, list);
                listView.setAdapter(baseAdapter);
                select = position;
                Log.e("select的值", select + "");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (select != -1) {
                    new AlertDialog.Builder(XuanXiuKeCheng_2.this)
                            .setTitle("你确认选择" + list.get(select).getCourseName() + "这门课吗?")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.e("select的值", select + "");
                                    int a = list.get(select).addStudent(student);
                                    if (a == 2) {
                                        Toast.makeText(XuanXiuKeCheng_2.this, "选择成功", Toast.LENGTH_SHORT).show();

                                    } else if (a == 0) {
                                        Toast.makeText(XuanXiuKeCheng_2.this, "不能重复选择", Toast.LENGTH_SHORT).show();
                                    } else if (a == 1) {
                                        Toast.makeText(XuanXiuKeCheng_2.this, "人数已满", Toast.LENGTH_SHORT).show();
                                    }
                                    select=-1;
                                    baseAdapter = new CourseAdapter(-1, XuanXiuKeCheng_2.this, list);
                                    listView.setAdapter(baseAdapter);
                                }
                            })
                            .setNeutralButton("否", null)
                            .create()
                            .show();

                } else {
                    Toast.makeText(XuanXiuKeCheng_2.this, "请选择一门科目", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
