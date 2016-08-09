package com.example.eventapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageview);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioImage);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            // 지금 선택한 것에 대한 정보 : checkedId
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId)
                {
                    case R.id.apeach:
                        imageView.setImageResource(R.drawable.apeach);
                        break;

                    case R.id.cons:
                        imageView.setImageResource(R.drawable.cons);
                        break;

                    case R.id.frodo:
                        imageView.setImageResource(R.drawable.frodo);
                        break;

                    case R.id.jayg:
                        imageView.setImageResource(R.drawable.jayg);
                        break;

                    case R.id.tube:
                        imageView.setImageResource(R.drawable.tube);
                        break;
                }
            }
        });


    }
}
