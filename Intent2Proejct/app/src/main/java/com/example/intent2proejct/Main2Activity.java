package com.example.intent2proejct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtName = null;
    TextView txtAge = null;
    TextView txtPhone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        // Activity에 설정된 위젯의 아이디 가져오기
        txtName = (TextView) findViewById(R.id.txtView1);
        txtAge = (TextView) findViewById(R.id.txtView2);
        txtPhone = (TextView) findViewById(R.id.txtView3);
        ImageView imageView = (ImageView) findViewById(R.id.image2);

        // Contact 클래스값 읽어와 변수 설정
        Contact contact = (Contact) intent.getExtras().get("contact");
        String name = contact.getName();
        String age = contact.getAge();
        String phone = contact.getPhone();
        int image_id = contact.getImageId();

        // 설정 변수들 Activity의 위젯들에게 적용
        txtName.setText(name);
        txtAge.setText(age);
        txtPhone.setText(phone);
        imageView.setImageResource(image_id);

        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 암시적 인텐트
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+txtPhone.getText().toString()));

                startActivity(intent1);
            }
        });
    }

    public void onClick(View v)
    {
        finish();
    }
}
