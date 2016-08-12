package com.example.zhaojiajia.newstudy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/10.
 */
public class StuAdapter extends BaseAdapter {
    private Context context;
    private List<Student> list;

    public StuAdapter(Context context, List<Student> list) {
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
        View view = View.inflate(context, R.layout.stuitem, null);
        TextView index = (TextView) view.findViewById(R.id.stunum);
        TextView stuName = (TextView) view.findViewById(R.id.stuname);
        TextView stusex = (TextView) view.findViewById(R.id.stusex);
        TextView stuage = (TextView) view.findViewById(R.id.stuage);
        Student studnet = list.get(position);
        index.setText(position + 1 + "");
        stusex.setText(studnet.getSex());
        stuage.setText(studnet.getAge() + "");
        stuName.setText(studnet.getName());
        return view;
    }
}
