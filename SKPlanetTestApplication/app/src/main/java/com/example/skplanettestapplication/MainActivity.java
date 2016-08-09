package com.example.skplanettestapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.skp.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.fragmentView);
        TMapView tmapview = new TMapView(this);
        tmapview.setSKPMapApiKey("c5f5eeb7-effc-3f38-ad31-a4ee970b0bb9");
        relativeLayout.addView(tmapview);
        setContentView(relativeLayout);

    }


}
