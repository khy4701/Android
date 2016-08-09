package com.example.activitylifecycleproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    static final int THIRD_ACTIVTY_REQUEST_CODE = 10000;
    static final int FOURTH_ACTIVTY_REQUEST_CODE = 20000;
    EditText editText;
    @Override
    protected void onStart() {
        super.onStart();

        Log.e("Main Activity","onStart()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = (String) savedInstanceState.get("edit");
        Log.e("Main Activity","onRestoreInstanceState()"+text);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Main Activity","onSaveInstanceState()");

        outState.putString("edit",editText.getText().toString()+"입니다");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Main Activity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main Activity","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main Activity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main Activity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Main Activity","onDestroy()");
    }

    // 화면 가로,세로 이동시 호출 되는 메소드
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("Main Activity","onConfigurationChanged()"+ newConfig.orientation );

        switch(newConfig.orientation){
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.land); break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main); break;
        }
    }

    // startActivityForResult(intent, result_value) --> result_value값이 requestCode값으로 .
    // requestCode :
    // resultCode: 성공, 실패
    // Intent data : 호출한 다른 Activity의 결과를 받아올 수 있는 파라미터.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("Main Activity","onActivityResult() : " + requestCode+ resultCode + data.getStringExtra("gg"));

        switch(requestCode)
        {
            case THIRD_ACTIVTY_REQUEST_CODE:
                if(resultCode == RESULT_OK)
                    Toast.makeText(MainActivity.this, "3번째 Activity :" +data.getStringExtra("gg") , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "3번째 Activity : 값 전송 실패", Toast.LENGTH_SHORT).show();

                break;

            case FOURTH_ACTIVTY_REQUEST_CODE:
                if(resultCode == RESULT_OK)
                    Toast.makeText(MainActivity.this, "4번째 Activity :" +data.getStringExtra("abc") , Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "4번째 Activity : 값 전송 실패", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Main Activity","onCreate()");

        editText = (EditText) findViewById(R.id.etText1);

        // 두번째 Activity로 이동
        Button btn_goSub = (Button) findViewById(R.id.btn_goSub);
        btn_goSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        // 세번째 Activity로 이동
        Button btn_third = (Button) findViewById(R.id.btn_goThird);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, ThirdActivity.class);

                // ThirdActivity가 종료 되면 onActivityResult 메소드 호출됨
                // MainActivity -> ThirdActiviy로 데이터 보낼 때, 3번째 파라미터값에 데이터 추가함
                startActivityForResult(intent,THIRD_ACTIVTY_REQUEST_CODE);
            }
        });

        Button btn_goFourth = (Button) findViewById(R.id.btn_goFourth);
        btn_goFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MainActivity.this, FourthActivity.class);

                // ThirdActivity가 종료 되면 onActivityResult 메소드 호출됨
                // MainActivity -> ThirdActiviy로 데이터 보낼 때, 3번째 파라미터값에 데이터 추가함
                startActivityForResult(intent,FOURTH_ACTIVTY_REQUEST_CODE);
            }
        });
    }
}
