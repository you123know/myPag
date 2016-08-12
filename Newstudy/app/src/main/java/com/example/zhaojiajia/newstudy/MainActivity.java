package com.example.zhaojiajia.newstudy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private BaseAdapter myAdapter;
    private Intent intent;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApplication=(MyApplication) getApplication();
        ActivityManager.add(this);
        listView = (ListView) findViewById(R.id.listview);
        myAdapter = new MyAdapter(myApplication.list, MainActivity.this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {
                    intent = new Intent(MainActivity.this, XuanXiuKeCheng.class);
                    startActivity(intent);
                }
                if (id == 1) {
                    intent = new Intent(MainActivity.this, TestOne.class);
                    startActivity(intent);
                }
                if (id == 5) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("你确认退出吗？")
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityManager.closeAll();
                                }
                            })
                            .setNegativeButton("否", null)
                            .create()
                            .show();
                }



                /*  跳转*/
                //  Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                // intent.putExtra("anyone", new String("哈哈"));
                //startActivity(intent);
                /* 接受跳转*/
                // Intent intent = getIntent();
                // String message = intent.getStringExtra("anyone");
            }
        });
    }
}
