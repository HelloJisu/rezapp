package com.example.user.openCV;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MoistureActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    ImageButton imageButton;
    ImageView moisture_image;
    TextView cancel, status, okay, again, moisture_status, result_grade, result_per;
    RelativeLayout moisture_result;
    SeekBar progress;
    Handler mHandler = null;
    String grade, per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moisture);

        // popupt창 사이즈 지정
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int)(display.getWidth() * 1); //Display 사이즈의 100%
        int height = (int)(display.getHeight() * 1);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        imageButton = findViewById(R.id.imageButton);
        cancel = findViewById(R.id.cancel);
        progress = findViewById(R.id.progress);
        status = findViewById(R.id.status);
        okay = findViewById(R.id.okay);
        again = findViewById(R.id.again);
        moisture_image = findViewById(R.id.moisture_image);
        moisture_result = findViewById(R.id.moisture_result);
        moisture_status = findViewById(R.id.moisture_status);
        result_grade = findViewById(R.id.result_grade);
        result_per = findViewById(R.id.result_per);

        moisture_result.setVisibility(View.INVISIBLE);


        okay.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);

        progress.setPadding(0,0,0,0);


        // seekbar 터치 막기
        progress.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        Random rand = new Random();
        int r = rand.nextInt(3);
        switch (r) {
            case 0:
                grade = "A"; per = "100%"; break;
            case 1:
                grade = "B"; per = "90%";break;
            case 2:
                grade = "C"; per = "80%";break;
        }

        databaseReference.child("result").child("moisture").setValue(grade);


        mHandler = new Handler();

        Thread t = new Thread(new Runnable() {
            int now=10;
            @Override
            public void run() {
                // UI 작업 X
                while (now < progress.getMax()) {
                    now++;
                    Log.i("NOW:  ", String.valueOf(now));
                    try {
                        //progress.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, now, getResources().getDisplayMetrics());
                        //progress.requestLayout();
                        if (now % 20 == 0) {
                            Thread.sleep(1000);
                        }
                        progress.setProgress(now);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // UI 작업 O
                        status.setText("Completed");
                        cancel.setVisibility(View.INVISIBLE);
                        okay.setVisibility(View.VISIBLE);
                        moisture_image.setVisibility(View.INVISIBLE);
                        result_grade.setText(grade);
                        result_per.setText(per +" of moisture \n contained");
                        moisture_result.setVisibility(View.VISIBLE);
                        moisture_status.setText("Done! Good job.");
                    }
                });
            }
        });
        t.start();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.okay:
                        finish();
                    case R.id.again:
                        finish();
                    case R.id.imageButton: case R.id.cancel:
                        finish();
                        break;
                }
            }
        };
        imageButton.setOnClickListener(onClickListener);
        cancel.setOnClickListener(onClickListener);
        okay.setOnClickListener(onClickListener);
        again.setOnClickListener(onClickListener);

    }
}