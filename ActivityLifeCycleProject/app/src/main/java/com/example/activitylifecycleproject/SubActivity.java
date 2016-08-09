package com.example.activitylifecycleproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Button btn_goMain = (Button) findViewById(R.id.btn_goMain);
        btn_goMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("Sub Activity","onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Sub Activity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Sub Activity","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Sub Activity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Sub Activity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Sub Activity","onDestroy()");
    }
}
