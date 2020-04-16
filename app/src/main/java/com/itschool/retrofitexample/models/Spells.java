package com.itschool.retrofitexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Spells implements Serializable
{

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    private final static long serialVersionUID = -1999861895331033410L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Spells() {
    }

    /**
     *
     * @param count
     * @param results
     */
    public Spells(int count, List<Result> results) {
        super();
        this.count = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}