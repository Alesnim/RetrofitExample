package com.itschool.retrofitexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Spell implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("index")
    @Expose
    private String index;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private List<String> desc = null;
    @SerializedName("higher_level")
    @Expose
    private List<String> higherLevel = null;
    @SerializedName("range")
    @Expose
    private String range;
    @SerializedName("components")
    @Expose
    private List<String> components = null;
    @SerializedName("material")
    @Expose
    private String material;
    @SerializedName("ritual")
    @Expose
    private boolean ritual;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("concentration")
    @Expose
    private boolean concentration;
    @SerializedName("casting_time")
    @Expose
    private String castingTime;
    @SerializedName("level")
    @Expose
    private int level;
    @SerializedName("school")
    @Expose
    private School school;
    @SerializedName("classes")
    @Expose
    private List<ClassDND> classes = null;
    @SerializedName("subclasses")
    @Expose
    private List<Subclass> subclasses = null;
    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = -6613405161848944976L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Spell() {
    }

    /**
     *
     * @param components
     * @param ritual
     * @param level
     * @param classes
     * @param index
     * @param range
     * @param concentration
     * @param url
     * @param duration
     * @param castingTime
     * @param higherLevel
     * @param material
     * @param school
     * @param name
     * @param id
     * @param subclasses
     * @param desc
     */
    public Spell(String id, String index, String name, List<String> desc, List<String> higherLevel, String range, List<String> components, String material, boolean ritual, String duration, boolean concentration, String castingTime, int level, School school, List<ClassDND> classes, List<Subclass> subclasses, String url) {
        super();
        this.id = id;
        this.index = index;
        this.name = name;
        this.desc = desc;
        this.higherLevel = higherLevel;
        this.range = range;
        this.components = components;
        this.material = material;
        this.ritual = ritual;
        this.duration = duration;
        this.concentration = concentration;
        this.castingTime = castingTime;
        this.level = level;
        this.school = school;
        this.classes = classes;
        this.subclasses = subclasses;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public List<String> getHigherLevel() {
        return higherLevel;
    }

    public void setHigherLevel(List<String> higherLevel) {
        this.higherLevel = higherLevel;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isConcentration() {
        return concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<ClassDND> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDND> classes) {
        this.classes = classes;
    }

    public List<Subclass> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(List<Subclass> subclasses) {
        this.subclasses = subclasses;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "id='" + id + '\'' +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", desc=" + desc +
                ", higherLevel=" + higherLevel +
                ", range='" + range + '\'' +
                ", components=" + components +
                ", material='" + material + '\'' +
                ", ritual=" + ritual +
                ", duration='" + duration + '\'' +
                ", concentration=" + concentration +
                ", castingTime='" + castingTime + '\'' +
                ", level=" + level +
                ", school=" + school +
                ", classes=" + classes +
                ", subclasses=" + subclasses +
                ", url='" + url + '\'' +
                '}';
    }
}