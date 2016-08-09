package com.example.busproject;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 한국정보기술 on 2016-08-05.
 */
public class StationAdapter extends ArrayAdapter<StationVO>{

    private Context context;
    private int resource;
    private List<StationVO> objects;
    private LayoutInflater inflater;

    public StationAdapter(Context context, int resource, List<StationVO> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if( convertView == null)
        {
            convertView = inflater.inflate(resource,null);

            holder = new ViewHolder();

            holder.txtStationNm = (TextView)convertView.findViewById(R.id.txtStationNm);
            holder.txtStationNo = (TextView)convertView.findViewById(R.id.txtStationNo);
            holder.txtTime = (TextView)convertView.findViewById(R.id.txtTime);
            holder.txtIsStop = (TextView)convertView.findViewById(R.id.txtStop);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        StationVO station = objects.get(position);
        holder.txtStationNm.setText(station.getStationNm());
        holder.txtStationNo.setText(station.getStationNo() + "  |   ");
        holder.txtTime.setText(station.getBeginTm()+" ~ " + station.getLastTm());
        if(station.getIsStop()) {
            holder.txtIsStop.setText("도착");
            holder.txtIsStop.setTextColor(Color.parseColor("#ff0000"));
        }
        else {
            holder.txtIsStop.setText("미도착");
            holder.txtIsStop.setTextColor(Color.parseColor("#000000"));
        }

        return convertView;
    }

    class ViewHolder{
        TextView txtStationNm;
        TextView txtTime;
        TextView txtStationNo;
        TextView txtIsStop;
    }


}
