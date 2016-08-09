package com.example.busproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class StationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        Intent intent = getIntent();

        String busRouteId = intent.getStringExtra("busRouteId");
        String busRouteNm = intent.getStringExtra("busRouteNm");

        Log.e("StationActivity", "busRouteId :" + busRouteId +"busRouteNm :" + busRouteNm);

        TextView txtbusRouteNm = (TextView)findViewById(R.id.txtbusRouteNm);
        txtbusRouteNm.setText(busRouteNm);

        StationAsyncTask asyncTask = new StationAsyncTask(StationActivity.this);
        asyncTask.execute(busRouteId,busRouteNm);

    }
}
