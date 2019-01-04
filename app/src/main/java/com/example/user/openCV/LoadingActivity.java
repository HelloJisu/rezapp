package com.example.user.openCV;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity {

    TextView loadingtxt;
    int count = -1;
    TimerTask second;

    private void startLoading() {
        second = new TimerTask() {
            @Override
            public void run() {
                Log.e("카운터", String.valueOf(count));
                count++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        switch (count) {
                            case 0:
                                loadingtxt.setText("GETTING YOUR SKIN CONDITION DATA.");
                                break;
                            case 1:
                                loadingtxt.setText("GETTING YOUR SKIN CONDITION DATA..");
                                break;
                            case 2:
                                loadingtxt.setText("GETTING YOUR SKIN CONDITION DATA...");
                                break;
                            case 3:
                                loadingtxt.setText("ADJUSTING THE LEVEL SETTING.");
                                break;
                            case 4:
                                loadingtxt.setText("ADJUSTING THE LEVEL SETTING..");
                                break;
                            case 5:
                                loadingtxt.setText("ADJUSTING THE LEVEL SETTING...");
                                break;
                            case 7:
                                loadingtxt.setText("MAPPING CARE ZONE.");
                                break;
                            case 8:
                                loadingtxt.setText("MAPPING CARE ZONE..");
                                break;
                            case 9:
                                loadingtxt.setText("MAPPING CARE ZONE...");
                                break;
                            case 10:
                                Intent intent = new Intent(getBaseContext(), TreatActivity.class);
                                startActivity(intent);
                                overridePendingTransition(0, 0);
                                finish();
                        }
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        startLoading();

        loadingtxt = (TextView)findViewById(R.id.loadingText);
    }
}
