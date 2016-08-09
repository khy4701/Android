package com.example.adapterview2project;

/**
 * Created by 한국정보기술 on 2016-08-01.
 */
public class Contact {
    private int image_id;
    private String phone_num;

    public Contact(int image_id, String phone_num) {
        this.image_id = image_id;
        this.phone_num = phone_num;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
