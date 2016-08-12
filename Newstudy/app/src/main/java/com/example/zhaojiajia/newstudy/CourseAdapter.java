package com.example.zhaojiajia.newstudy;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/9.
 */
public class CourseAdapter extends BaseAdapter {

    private int selectNum;
    private List<Course> list;
    private Context context;

    public CourseAdapter(int selectNum, Context context, List<Course> list) {
        this.selectNum = selectNum;
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.courseitem, null);
        final Course course = list.get(position);
        TextView index = (TextView) view.findViewById(R.id.index);
        TextView courseName = (TextView) view.findViewById(R.id.coursename);
        TextView teacher = (TextView) view.findViewById(R.id.teacher);
        TextView stuNum = (TextView) view.findViewById(R.id.studentNum);
        TextView maxNum = (TextView) view.findViewById(R.id.maxNum);
        index.setText(position + 1 + "");
        courseName.setText(course.getCourseName());
        teacher.setText(course.getTeacher().getName());
        stuNum.setText(course.getList().size() + "");
        maxNum.setText(course.getMaxNum() + "");
        if (position == selectNum) {
            view.setBackgroundResource(R.color.colorSkyblue);
        } else {
            view.setBackgroundResource(R.color.colorWhite);
        }
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TeacherView.class);
                intent.putExtra("teacher", course.getTeacher());
                context.startActivity(intent);
            }
        });
        stuNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentView.class);
                intent.putExtra("student", course);
                context.startActivity(intent);
            }
        });

        return view;

    }
}
