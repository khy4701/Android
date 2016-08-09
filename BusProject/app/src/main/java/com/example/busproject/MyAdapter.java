package com.example.busproject;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-04.
 */
public class MyAdapter extends ArrayAdapter<BusVO> {

    private Context context;
    private int resource;
    private List<BusVO> objects;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int resource, List<BusVO> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if( convertView == null)
        {
            convertView = inflater.inflate(resource,null);

            holder = new ViewHolder();

            holder.txtRouteId = (TextView)convertView.findViewById(R.id.txtRouteId);
            holder.txtRouteType = (TextView)convertView.findViewById(R.id.txtRouteType);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        BusVO bus = objects.get(position);
        holder.txtRouteId.setText("RouteId : " +bus.getBusRouteId());
        holder.txtRouteType.setText("RouteType : " +bus.getRouteType());

        return convertView;
    }

    class ViewHolder{
        TextView txtRouteId;
        TextView txtRouteType;
    }
}
