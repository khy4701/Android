package com.example.activitylifecycle2project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtName ;
    ImageView imageView;

    static final int IMAGE_ACTIVTY_REQUEST_CODE = 10000;
    static final int NAME_ACTIVTY_REQUEST_CODE = 20000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int image_id = 0;
        String name = null;
        switch(requestCode)
        {
            case IMAGE_ACTIVTY_REQUEST_CODE:
                if(resultCode == RESULT_OK)
                    image_id = data.getIntExtra("image", 0);
                else
                    image_id = R.drawable.apeach;

                imageView.setImageResource(image_id);
                break;

            case NAME_ACTIVTY_REQUEST_CODE:
                if(resultCode == RESULT_OK)
                    name = data.getStringExtra("name");
                else
                    name = new String("이름 작성 안함");

                txtName.setText(name);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtName);
        imageView = (ImageView) findViewById(R.id.imageView);

        Button btnImage = (Button) findViewById(R.id.btnImage);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivityForResult(intent,IMAGE_ACTIVTY_REQUEST_CODE);
            }
        });

        Button btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // manifest에서 지정한 Intent로 이동
                Intent intent = new Intent("action.myaction");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
              /*  Intent intent = new Intent(MainActivity.this, NameActivity.class);
                startActivityForResult(intent,NAME_ACTIVTY_REQUEST_CODE);*/
            }
        });


    }
}
