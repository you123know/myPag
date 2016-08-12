package com.example.zhaojiajia.newstudy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by zhaojiajia on 2016/8/8.
 */
public class MyAdapter extends BaseAdapter {
    private List<Item> list;









































    private Context context;

    public MyAdapter(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
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
        View view = View.inflate(context, R.layout.listitem, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.text);
        Item item = list.get(position);
        imageView.setImageResource(item.getImage());
        textView.setText(item.getText());
        return view;
    }
}
