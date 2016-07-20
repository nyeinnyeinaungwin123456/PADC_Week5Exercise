package com.anastatia.testing.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nyein Nyein on 7/18/2016.
 */
public class AttractionVO {

    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String desc;

    @SerializedName("images")
    private String[] images;



    public AttractionVO() {
    }

    public AttractionVO(String title, String[] images, String desc) {
        this.title = title;
        this.images = images;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String[] getImages() {
        return images;
    }

    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
