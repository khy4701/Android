package com.example.activitylifecycle2project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class ImageActivity extends AppCompatActivity {

    int checked_id = 0;
    int image_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Button btnExit = (Button)findViewById(R.id.btnImageActivity_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup_image);
                checked_id  = radioGroup.getCheckedRadioButtonId();

                switch(checked_id)
                {
                    case R.id.apeach:
                        image_id = R.drawable.apeach;
                        break;
                    case R.id.cons:
                        image_id = R.drawable.cons;
                        break;
                    case R.id.frodo:
                        image_id = R.drawable.frodo;
                        break;
                    case R.id.jayg:
                        image_id = R.drawable.jayg;
                        break;
                    case R.id.muzi:
                        image_id = R.drawable.muzi;
                        break;
                }

                Intent intent = new Intent();
                intent.putExtra("image",image_id);

                if( image_id == 0)
                    setResult(RESULT_CANCELED,intent);
                else
                    setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
