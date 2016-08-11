package com.example.zhaojiajia.lovestudy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zhaojiajia on 2016/7/5.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Hope> list;

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
        return list.get(position).getId();
    }

    public MyAdapter(Context context, List<Hope> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.item, null);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView sex = (TextView) view.findViewById(R.id.sex);
        TextView age = (TextView) view.findViewById(R.id.age);
        TextView message = (TextView) view.findViewById(R.id.hope);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Hope hope = list.get(position);
        id.setText("-----" + hope.getId() + "-----");
        name.setText(hope.getUserName());
        sex.setText("性别：" + hope.getSex());
        age.setText("年龄：" + hope.getAge());
        message.setText(hope.getMessage());
        Picasso.with(context).load("http://192.168.23.1/img/" + hope.getUserImg()).into(img);

        return view;

    }
}
