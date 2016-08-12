package com.example.zhaojiajia.newstudy;

/**
 * Created by zhaojiajia on 2016/8/8.
 */
public class Item {
    private String text;
    private int image;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Item(String text, int image) {

        this.text = text;
        this.image = image;
    }
}
