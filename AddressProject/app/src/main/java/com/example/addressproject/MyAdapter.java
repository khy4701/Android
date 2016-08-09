package com.example.addressproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-02.
 */
public class MyAdapter extends ArrayAdapter<Contact>{

    private Context context;
    private int resource;
    private List<Contact> objects;
    LayoutInflater inflater;

    public MyAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource = resource;
        this.objects = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        Contact contact = null;
        LinearLayout layout = null;
        Button btnDelete = null;

        if( convertView == null)
        {
            convertView = inflater.inflate(resource,null);
            holder = new ViewHolder();

            holder.imageView = (ImageView)convertView.findViewById(R.id.item_image);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.item_email);
            holder.txtName = (TextView) convertView.findViewById(R.id.item_name);
            holder.txtTel = (TextView) convertView.findViewById(R.id.item_phone);
            holder.btnChange = (Button) convertView.findViewById(R.id.btnChange);
            holder.btnDelete  = (Button) convertView.findViewById(R.id.btnDelete);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        contact = objects.get(position);
        holder.imageView.setImageResource(contact.getImage_id());
        holder.txtEmail.setText(contact.getEmail());
        holder.txtName.setText(contact.getName());
        holder.txtTel.setText(contact.getPhone_num());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(objects.get(position));
            }
        });


        return convertView;
    }

    @Override
    public void remove(Contact object) {
        super.remove(object);
    }

    class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtTel;
        TextView txtEmail;
        Button btnChange;
        Button btnDelete;
    }
}
