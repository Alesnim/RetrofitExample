package com.itschool.retrofitexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClassDND implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = -8385946739164370836L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ClassDND() {
    }

    /**
     *
     * @param name
     * @param url
     */
    public ClassDND(String name, String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "ClassDND{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}