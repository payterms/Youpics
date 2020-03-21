package ru.payts.youpics.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {
    @Expose
    @SerializedName("id")
    public String id;
    @Expose
    @SerializedName("webformatURL")
    public String webformatURL;
    @Expose
    @SerializedName("imageWidth")
    public String imageWidth;
    @Expose
    @SerializedName("imageHeight")
    public String imageHeight;
    @Expose
    @SerializedName("imageSize")
    public String imageSize;
    @Expose
    @SerializedName("views")
    public int views;
}
