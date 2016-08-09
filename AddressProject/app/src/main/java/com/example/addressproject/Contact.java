package com.example.addressproject;

import java.io.Serializable;

/**
 * Created by 한국정보기술 on 2016-08-02.
 */
public class Contact implements Serializable{

    private int image_id;
    private String name;
    private String phone_num;
    private String email;

    public Contact()
    {}

    public Contact(int image_id, String name, String phone_num, String email) {
        this.image_id = image_id;
        this.name = name;
        this.phone_num = phone_num;
        this.email = email;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
