package com.example.adapterviewproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-01.
 */
public class MyAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> objects;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 한 항목에 관한 것. ( 위치, 한 항목, ListView )
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if( convertView == null) {
            Log.e("ConverView", "null" + position);
            convertView = inflater.inflate(resource, null);

            holder = new ViewHolder();

            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtTel = (TextView) convertView.findViewById(R.id.txtTel);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        Contact contact = objects.get(position);
        holder.imageView.setImageResource(contact.getImageId());
        holder.txtName.setText(contact.getName());
        holder.txtTel.setText(contact.getPhone());

        return convertView;
    }

    @Override
    public void remove(Contact object) {
        super.remove(object);
    }

    @Override
    public void sort(Comparator<? super Contact> comparator) {
        super.sort(comparator);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void add(Contact object) {
        super.add(object);
    }

    // 뷰 홀더 클래스
    class ViewHolder{
        ImageView imageView;
        TextView txtName;
        TextView txtTel;
    }
}
