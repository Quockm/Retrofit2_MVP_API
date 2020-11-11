package com.example.retrofit2_mvp_api.Adapter;

/**
 * Created by QuocKM on 10,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public class StaticRvModel {

    private int image;
    private String text;

    public StaticRvModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
