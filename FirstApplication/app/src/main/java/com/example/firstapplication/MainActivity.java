package com.example.firstapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xml을 불러 읽어와 수행하는 코드
        // 자동 Import : Alt+Enter
        setContentView(R.layout.activity_main2);

        Log.e("test","testLog");

        // 이벤트 등록 방법2 --> xml 건드리지 않고 설정 가능
        // listener를 implements 해야 함
        Button btn3=  (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        Button btn4=  (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        Button btn5 = (Button)findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼 5 눌림" ,Toast.LENGTH_SHORT).show();

            }
        });

        Button btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(new EventListener());
    }

    public void btnClick(View view)
    {
        // 이벤트 등록시, View에 자동으로 데이터가 들어옴.
        Log.e("Event", Integer.toString(view.getId()));

        switch(view.getId()){
            case R.id.btn1 :
                Toast.makeText(getApplicationContext(), "버튼 1 눌림" ,Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn2 :
                Toast.makeText(getApplicationContext(), "버튼 2 눌림" ,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btn3 :
                Toast.makeText(getApplicationContext(), "버튼 3 눌림" ,Toast.LENGTH_SHORT).show();

                break;

            case R.id.btn4 :
                Toast.makeText(getApplicationContext(), "버튼 4 눌림" ,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class EventListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "버튼 6 눌림" ,Toast.LENGTH_SHORT).show();

        }
    }
}
