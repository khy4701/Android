package com.example.intent2proejct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        // 돌아올 주소, 이동할 주소
        // 명시적 인텐트
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);

        EditText age = (EditText)findViewById(R.id.edAge);
        EditText name = (EditText)findViewById(R.id.edName);
        EditText phone = (EditText)findViewById(R.id.edPhone);

        Contact contact = new Contact(R.drawable.apeach, name.getText().toString(),age.getText().toString(),phone.getText().toString() );
        intent.putExtra("contact",contact);

        startActivity(intent);
    }
}
