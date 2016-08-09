package com.example.activitylifecycleproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Button btn_fourth = (Button) findViewById(R.id.btn4);
        btn_fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 결과값을 intent에 저장하고 setResult 함수를 통해 결과값 저장 --> MainActivity에서 onActivityResult()에 데이터 전달.

                // RESULT_OK는
                Intent intent = new Intent();
                intent.putExtra("abc","hi4");

                //setResult(RESULT_CANCELED, intent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
