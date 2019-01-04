package com.example.user.openCV;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class DoneActivity_ur extends AppCompatActivity {
    TextView okay;
    TextView finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatfinish_ur);

        // popupt창 사이즈 지정
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 1); //Display 사이즈의 100%
        int height = (int) (display.getHeight() * 0.4);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        okay = findViewById(R.id.yes_ur);
        finish = findViewById(R.id.cancle_ur);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.yes_ur:
                        intent = new Intent(getApplicationContext(), TreatActivity_underleft.class);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.cancle_ur:
                        intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        };
        okay.setOnClickListener(onClickListener);
        finish.setOnClickListener(onClickListener);
    }
}
