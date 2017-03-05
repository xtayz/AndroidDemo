package com.zhanghao.androiddemo.chapter3;

/**
 * Created by haozhang on 2017/3/5.
 */

public class Chapter {

    private String name;
    private int imageName;
    private Class aClass;

    public Chapter(String name, int imageName, Class aClass) {
        this.name = name;
        this.imageName = imageName;
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public int getImageName() {
        return imageName;
    }

    public Class getaClass() {
        return aClass;
    }
}
