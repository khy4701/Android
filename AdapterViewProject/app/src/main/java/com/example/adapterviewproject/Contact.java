package com.example.adapterviewproject;


import java.io.Serializable;

/**
 * Created by 한국정보기술 on 2016-08-01.
 */
public class Contact implements Serializable {

    private int imageId;
    private String name;
    private String age;
    private String phone;

    public Contact(int imageId, String name, String age, String phone) {
        this.imageId = imageId;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
