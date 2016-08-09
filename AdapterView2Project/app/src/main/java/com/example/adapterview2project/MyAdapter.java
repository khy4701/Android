package com.example.adapterview2project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-01.
 */
public class MyAdapter extends ArrayAdapter{

    private Context context;
    private int resource;
    private List<Contact> objects;

    public MyAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //  정의한 resource(item)을 view로 정의하고
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(resource,null);

        //, view의 하위 위젯 id를 읽어와 참조하는 것
        ImageView image = (ImageView) convertView.findViewById(R.id.image2);
        TextView txtPhone = (TextView) convertView.findViewById(R.id.txtPhoneNum);

        // List에서 객체 읽어와 이미지에 붙이기
        Contact contact = objects.get(position);
        image.setImageResource(contact.getImage_id());
        txtPhone.setText(contact.getPhone_num());

        return convertView;


    }

}
