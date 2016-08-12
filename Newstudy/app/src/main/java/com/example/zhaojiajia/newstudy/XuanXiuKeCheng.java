package com.example.zhaojiajia.newstudy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class XuanXiuKeCheng extends AppCompatActivity {
    private Intent intent;
    private Student student;
    private TextView nameView;
    private RadioButton boyRadio;
    private RadioButton girlRadio;
    private TextView ageView;
    private String name;
    private String sex;
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuan_xiu_ke_cheng);
        ActivityManager.add(this);
        nameView = (TextView) findViewById(R.id.xxkc_nameedit);
        boyRadio = (RadioButton) findViewById(R.id.xxkc_boy);
        girlRadio = (RadioButton) findViewById(R.id.xxkc_girl);
        ageView = (TextView) findViewById(R.id.xxkc_ageedit);
        Button button = (Button) findViewById(R.id.xxkc_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessage();
                intent = new Intent(XuanXiuKeCheng.this, XuanXiuKeCheng_2.class);
                setMessage();
                if(name!=null&&sex!=null&age!=null) {
                  student=new Student(name,sex,age);
                    intent.putExtra("student",student);
                    startActivity(intent);
                }
            }
        });
    }

    public void setMessage() {
        if (nameView.getText().toString() == "" ||nameView.getText().toString() .equals("") || ageView.getText().toString() == "" ||ageView.getText().toString() .equals("") || (!boyRadio.isChecked() && !girlRadio.isChecked())) {
            Toast.makeText(XuanXiuKeCheng.this, "请全部填写", Toast.LENGTH_SHORT).show();
            return;
        }
        name = nameView.getText().toString();
        if (boyRadio.isChecked()) {
            sex = boyRadio.getText().toString();
        }
        if (girlRadio.isChecked()) {
            sex = girlRadio.getText().toString();
        }
        try {
            age = Integer.parseInt(ageView.getText().toString());
        } catch (Exception e) {
            Toast.makeText(XuanXiuKeCheng.this, "年龄请输入数字", Toast.LENGTH_SHORT).show();
        }
    }
}
