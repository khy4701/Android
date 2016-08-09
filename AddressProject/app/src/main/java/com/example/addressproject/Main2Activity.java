package com.example.addressproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtPhone = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        Contact contact = (Contact)intent.getExtras().get("contact_info");


        ImageView imageView = (ImageView)findViewById(R.id.ImageView);
        TextView txtName = (TextView)findViewById(R.id.txtName);
        txtPhone = (TextView)findViewById(R.id.txtPhone);
        TextView txtEmail = (TextView)findViewById(R.id.txtEmail);
        Button btnExit = (Button)findViewById(R.id.btnClose);

        txtName.setText("이름 : "+contact.getName());

        txtPhone.setText("전화번호 : "+contact.getPhone_num());
        txtEmail.setText("이메일 : "+contact.getEmail());


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void goPhone(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+txtPhone.getText().toString()));
        startActivity(intent);
    }
}
