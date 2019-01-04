package com.example.user.openCV;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class WrinklesActivity extends AppCompatActivity {


    ImageButton imageButton;
    TextView ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrinkles);

        // popupt창 사이즈 지정
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 1); //Display 사이즈의 100%
        int height = (int) (display.getHeight() * 1);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        imageButton = findViewById(R.id.imageButton);
        ready = findViewById(R.id.ready);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ready:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    case R.id.imageButton:
                        finish();
                        break;
                }
            }
        };
        imageButton.setOnClickListener(onClickListener);
        ready.setOnClickListener(onClickListener);

    }
}
