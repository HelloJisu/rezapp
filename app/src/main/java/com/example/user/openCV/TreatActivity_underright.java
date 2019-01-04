package com.example.user.openCV;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class TreatActivity_underright extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt;
    String wrinkle_string;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back;
    LinearLayout component;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    RelativeLayout treatback, underright_layout,treat_default;
    int undercount=0, data=0, level=0, timer_sec, count=0;
    ImageView u_tright_line1,u_tright_line2,u_tright_line3,u_tright_line4,u_tright_line5,u_tright_line6,
            u_tright_line7,u_tright_line8,u_tright_line9,u_tright_line10,u_tright_line11,u_tright_line12,u_tright_line13;
    TimerTask second;
    String part;
    AnimationDrawable utrani1,utrani2,utrani3,utrani4,utrani5,utrani6,utrani7,utrani8,utrani9,utrani10,utrani11,utrani12,utrani13;


    public void animation() {
        second = new TimerTask() {
            @Override
            public void run() {
                Log.e("카운터",String.valueOf(count));
                count++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            if (count == 1) {
                                u_tright_line8.setBackgroundResource(R.drawable.underrightanim1);
                                utrani8 = (AnimationDrawable) u_tright_line8.getBackground();
                                utrani8.start();
                            }
                            if (count == 2) {
                                utrani8.stop();
                                u_tright_line8.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line9.setBackgroundResource(R.drawable.underrightanim1);
                                utrani9 = (AnimationDrawable) u_tright_line9.getBackground();
                                utrani9.start();
                                u_tright_txt1.setText("5 left");
                            }
                            if (count == 3) {
                                utrani9.stop();
                                u_tright_line9.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line10.setBackgroundResource(R.drawable.underrightanim1);
                                utrani10 = (AnimationDrawable) u_tright_line10.getBackground();
                                utrani10.start();
                                u_tright_txt1.setText("4 left");
                            }
                            if (count == 4) {
                                utrani10.stop();
                                u_tright_line10.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line11.setBackgroundResource(R.drawable.underrightanim1);
                                utrani11 = (AnimationDrawable) u_tright_line11.getBackground();
                                utrani11.start();
                                u_tright_txt1.setText("3 left");
                            }
                            if (count == 5) {
                                utrani11.stop();
                                u_tright_line11.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line12.setBackgroundResource(R.drawable.underrightanim1);
                                utrani12 = (AnimationDrawable) u_tright_line12.getBackground();
                                utrani12.start();
                                u_tright_txt1.setText("2 left");
                            }
                            if (count == 6) {
                                utrani12.stop();
                                u_tright_line12.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line13.setBackgroundResource(R.drawable.underrightanim1);
                                utrani13 = (AnimationDrawable) u_tright_line13.getBackground();
                                utrani13.start();
                                u_tright_txt1.setText("1 left");
                            }
                            if (count == 7) {
                                utrani13.stop();
                                u_tright_line13.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line1.setBackgroundResource(R.drawable.underrightanim2);
                                utrani1 = (AnimationDrawable) u_tright_line1.getBackground();
                                utrani1.start();
                                u_tright_txt1.setText("0 left");
                                u_tright_txt2.setText("7 left");
                            }
                            if (count == 8) {
                                utrani1.stop();
                                u_tright_line1.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line2.setBackgroundResource(R.drawable.underrightanim2);
                                utrani2 = (AnimationDrawable) u_tright_line2.getBackground();
                                utrani2.start();
                                u_tright_txt2.setText("6 left");
                            }
                            if (count == 9) {
                                utrani2.stop();
                                u_tright_line2.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line3.setBackgroundResource(R.drawable.underrightanim2);
                                utrani3 = (AnimationDrawable) u_tright_line3.getBackground();
                                utrani3.start();
                                u_tright_txt2.setText("5 left");
                            }
                            if (count == 10) {
                                utrani3.stop();
                                u_tright_line3.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line4.setBackgroundResource(R.drawable.underrightanim2);
                                utrani4 = (AnimationDrawable) u_tright_line4.getBackground();
                                utrani4.start();
                                u_tright_txt2.setText("4 left");
                            }
                            if (count == 11) {
                                utrani4.stop();
                                u_tright_line4.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line5.setBackgroundResource(R.drawable.underrightanim2);
                                utrani5 = (AnimationDrawable) u_tright_line5.getBackground();
                                utrani5.start();
                                u_tright_txt2.setText("3 left");
                            }
                            if (count == 12) {
                                utrani5.stop();
                                u_tright_line5.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line6.setBackgroundResource(R.drawable.underrightanim2);
                                utrani6 = (AnimationDrawable) u_tright_line6.getBackground();
                                utrani6.start();
                                u_tright_txt2.setText("2 left");
                            }
                            if (count == 13) {
                                utrani6.stop();
                                u_tright_line6.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line7.setBackgroundResource(R.drawable.underrightanim2);
                                utrani7 = (AnimationDrawable) u_tright_line7.getBackground();
                                utrani7.start();
                                u_tright_txt2.setText("1 left");
                            } if (count >= 14) {
                                u_tright_line7.setBackgroundResource(R.drawable.line1finish);
                                component_txt.setText("GOOD JOB");
                                u_tright_txt1.setText("DONE");
                                u_tright_txt1.setTextColor(Color.parseColor("#9E0958"));
                                u_tright_txt2.setText("DONE");
                                u_tright_txt2.setTextColor(Color.parseColor("#9E0958"));
                                data=25;
                        }
                        if(count==15){
                            //Intent intent = new Intent(getApplicationContext(), DoneActivity_ul.class);
                            //startActivity(intent);
                            databaseReference.child("result").child("underrigh_data").setValue(data);
                            back.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 10000);

    }

    public void onStart() {
        super.onStart();
        wrinkle_txt.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                wrinkle_string = dataSnapshot.getValue(String.class);
                if (wrinkle_string.equals("A")) {
                    level = 1;
                }
                if (wrinkle_string.equals("B")) {
                    level = 2;
                }
                if (wrinkle_string.equals("C")) {
                    level = 3;
                }
                if(level==1){
                    underleft.setImageResource(R.drawable.underrightlevel1);
                    underright.setImageResource(R.drawable.underleftlevel1);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 1,\nAND SELECT STARTIG AREA");
                }
                if(level==2){
                    underleft.setImageResource(R.drawable.underrightlevel2);
                    underright.setImageResource(R.drawable.underleftlevel2);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 2,\nAND SELECT STARTIG AREA");
                }
                if(level==3){
                    underleft.setImageResource(R.drawable.underrightlevel3);
                    underright.setImageResource(R.drawable.underleftlevel3);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 3,\nAND SELECT STARTIG AREA");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_underright);

        Resources res = getResources();
        final Drawable  cheekrightimg= res.getDrawable(R.drawable.cheekrightimg);
        final Drawable  cheekleftimg= res.getDrawable(R.drawable.cheekleftimg);
        final Drawable  cheekunderrightimg= res.getDrawable(R.drawable.cheekunderimg);
        final Drawable  cheekunderleftimg= res.getDrawable(R.drawable.cheekunderleft);
        //값 받아오기

        wrinkle_txt = databaseReference.child("result").child("winkle");
        forehead =  (ImageView)findViewById(R.id.forehead_ur);
        underleft =  (ImageView)findViewById(R.id.underleft_ur);
        underright =  (ImageView)findViewById(R.id.underright_ur);
        cheekl =  (ImageView)findViewById(R.id.cheek_left_ur);
        cheekr =  (ImageView)findViewById(R.id.cheek_right_ur);
        mouth =  (ImageView)findViewById(R.id.mouth_ur);
        eyeleft = (ImageView)findViewById(R.id.eyeleft_ur);
        eyeright=(ImageView)findViewById(R.id.eyeright_ur);
        component_txt=(TextView)findViewById(R.id.componenttxt_ur);
        treatback = (RelativeLayout)findViewById(R.id.treatayout_ur);
        underright_layout=(RelativeLayout)findViewById(R.id.u_trigh_layout);
        treat_default=(RelativeLayout)findViewById(R.id.treat_default_ur);
        back=(ImageView)findViewById(R.id.backw_ur);
        u_tright_line1=(ImageView)findViewById(R.id.u_tright_line1);
        u_tright_line2=(ImageView)findViewById(R.id.u_tright_line2);
        u_tright_line3=(ImageView)findViewById(R.id.u_tright_line3);
        u_tright_line4=(ImageView)findViewById(R.id.u_tright_line4);
        u_tright_line5=(ImageView)findViewById(R.id.u_tright_line5);
        u_tright_line6=(ImageView)findViewById(R.id.u_tright_line6);
        u_tright_line7=(ImageView)findViewById(R.id.u_tright_line7);
        u_tright_line8=(ImageView)findViewById(R.id.u_tright_line8);
        u_tright_line9=(ImageView)findViewById(R.id.u_tright_line9);
        u_tright_line10=(ImageView)findViewById(R.id.u_tright_line10);
        u_tright_line11=(ImageView)findViewById(R.id.u_tright_line11);
        u_tright_line12=(ImageView)findViewById(R.id.u_tright_line12);
        u_tright_line13=(ImageView)findViewById(R.id.u_tright_line13);
        u_tright_txt1=(TextView)findViewById(R.id.u_tright_txt1);
        u_tright_txt2=(TextView)findViewById(R.id.u_tright_txt2);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);

        underright_layout.setVisibility(View.INVISIBLE);

        eyeleft.setClickable(false);
        eyeright.setClickable(false);
        cheekl.setClickable(false);
        cheekr.setClickable(false);
        forehead.setClickable(false);
        if(level==1){
            underleft.setImageResource(R.drawable.underleftlevel1);
            underright.setImageResource(R.drawable.underrightlevel1);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 1,\nAND SELECT STARTIG AREA");
        }
        if(level==2){
            underleft.setImageResource(R.drawable.underleftlevel2);
            underright.setImageResource(R.drawable.underrightlevel2);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 2,\nAND SELECT STARTIG AREA");
        }
        if(level==3){
            underleft.setImageResource(R.drawable.underleftlevel3);
            underright.setImageResource(R.drawable.underrightlevel3);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 3,\nAND SELECT STARTIG AREA");
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                level=1;

                switch (v.getId()) {
                    case R.id.backw_ur:
                        Intent intent = new Intent(getBaseContext(), TreatActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                    case R.id.underright_ur:
                            animation();
                            treatback.setBackground(cheekrightimg);
                            treat_default.setVisibility(View.INVISIBLE);
                            underright_layout.setVisibility(View.VISIBLE);
                        component_txt.setText("THIS COLUMN HAS 7 LINES.\nPLACE THE DEVIECE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE.");
                        undercount=0;
                        back.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };
        back.setOnClickListener(onClickListener);
        forehead.setOnClickListener(onClickListener);
        underleft.setOnClickListener(onClickListener);
        underright.setOnClickListener(onClickListener);
        cheekl.setOnClickListener(onClickListener);
        cheekr.setOnClickListener(onClickListener);
        mouth.setOnClickListener(onClickListener);
        eyeleft.setOnClickListener(onClickListener);
        eyeright.setOnClickListener(onClickListener);
    }
}
