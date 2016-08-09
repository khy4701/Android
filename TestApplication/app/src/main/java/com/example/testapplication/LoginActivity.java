package com.example.testapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    public static int TIME_OUT = 1001;

    TextView txtId = null;
    TextView txtPassword = null;
    ProgressDialog progressDialog= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        txtId = (TextView) findViewById(R.id.input_id);
        txtPassword = (TextView) findViewById(R.id.input_password);

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String id = txtId.getText().toString();
                String pw = txtPassword.getText().toString();

                if(id.equals("khy4701") && pw.equals("1234"))
                {
                    progressDialog = ProgressDialog.show(LoginActivity.this, "",
                            "로딩 중입니다. 잠시 기다려주세요", true);

                    mHandler.sendEmptyMessageDelayed(TIME_OUT, 3000);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "아이디 및 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            // Handler 생성
            Handler mHandler = new Handler(){
                public void handleMessage(Message msg) {
                    if (msg.what == TIME_OUT) { // 타임아웃이 발생하면
                        progressDialog.dismiss(); // ProgressDialog를 종료
                    }
                }
            };
        });

    }

}
