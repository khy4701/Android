package com.example.activitylifecycle2project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Button btnExit = (Button)findViewById(R.id.btnNameActivity_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edName = (EditText)findViewById(R.id.edName);
                String name = edName.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name",name);

                if( name.equals("") )
                    setResult(RESULT_CANCELED,intent);
                else
                    setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
