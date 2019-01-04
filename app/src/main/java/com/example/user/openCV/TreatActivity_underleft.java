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

public class TreatActivity_underleft extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt;
    String wrinkle_string;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back;
    LinearLayout component;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    RelativeLayout treatback, underleft_layout,treat_default;
    int undercount=0, data=0, level=0, timer_sec, count=0;
    ImageView u_tleft_line1,u_tleft_line2,u_tleft_line3,u_tleft_line4,u_tleft_line5,u_tleft_line6,
            u_tleft_line7,u_tleft_line8,u_tleft_line9,u_tleft_line10,u_tleft_line11,u_tleft_line12,u_tleft_line13;
    TimerTask second;
    String part;
    AnimationDrawable utlani1,utlani2,utlani3,utlani4,utlani5,utlani6,utlani7,utlani8,utlani9,utlani10,utlani11,utlani12,utlani13;


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
                                u_tleft_line8.setBackgroundResource(R.drawable.underleftanim1);
                                utlani8 = (AnimationDrawable) u_tleft_line8.getBackground();
                                utlani8.start();
                            }
                            if (count == 2) {
                                utlani8.stop();
                                u_tleft_line8.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line9.setBackgroundResource(R.drawable.underleftanim1);
                                utlani9 = (AnimationDrawable) u_tleft_line9.getBackground();
                                utlani9.start();
                                u_tleft_txt1.setText("5 left");
                            }
                            if (count == 3) {
                                utlani9.stop();
                                u_tleft_line9.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line10.setBackgroundResource(R.drawable.underleftanim1);
                                utlani10 = (AnimationDrawable) u_tleft_line10.getBackground();
                                utlani10.start();
                                u_tleft_txt1.setText("4 left");
                            }
                            if (count == 4) {
                                utlani10.stop();
                                u_tleft_line10.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line11.setBackgroundResource(R.drawable.underleftanim1);
                                utlani11 = (AnimationDrawable) u_tleft_line11.getBackground();
                                utlani11.start();
                                u_tleft_txt1.setText("3 left");
                            }
                            if (count == 5) {
                                utlani11.stop();
                                u_tleft_line11.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line12.setBackgroundResource(R.drawable.underleftanim1);
                                utlani12 = (AnimationDrawable) u_tleft_line12.getBackground();
                                utlani12.start();
                                u_tleft_txt1.setText("2 left");
                            }
                            if (count == 6) {
                                utlani12.stop();
                                u_tleft_line12.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line13.setBackgroundResource(R.drawable.underleftanim1);
                                utlani13 = (AnimationDrawable) u_tleft_line13.getBackground();
                                utlani13.start();
                                u_tleft_txt1.setText("1 left");
                            }
                            if (count == 7) {
                                utlani13.stop();
                                u_tleft_line13.setBackgroundResource(R.drawable.line9finish);
                                u_tleft_line1.setBackgroundResource(R.drawable.underleftanim2);
                                utlani1 = (AnimationDrawable) u_tleft_line1.getBackground();
                                utlani1.start();
                                u_tleft_txt1.setText("0 left");
                                u_tleft_txt2.setText("7 left");
                            }
                            if (count == 8) {
                                utlani1.stop();
                                u_tleft_line1.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line2.setBackgroundResource(R.drawable.underleftanim2);
                                utlani2 = (AnimationDrawable) u_tleft_line2.getBackground();
                                utlani2.start();
                                u_tleft_txt2.setText("6 left");
                            }
                            if (count == 9) {
                                utlani2.stop();
                                u_tleft_line2.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line3.setBackgroundResource(R.drawable.underleftanim2);
                                utlani3 = (AnimationDrawable) u_tleft_line3.getBackground();
                                utlani3.start();
                                u_tleft_txt2.setText("5 left");
                            }
                            if (count == 10) {
                                utlani3.stop();
                                u_tleft_line3.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line4.setBackgroundResource(R.drawable.underleftanim2);
                                utlani4 = (AnimationDrawable) u_tleft_line4.getBackground();
                                utlani4.start();
                                u_tleft_txt2.setText("4 left");
                            }
                            if (count == 11) {
                                utlani4.stop();
                                u_tleft_line4.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line5.setBackgroundResource(R.drawable.underleftanim2);
                                utlani5 = (AnimationDrawable) u_tleft_line5.getBackground();
                                utlani5.start();
                                u_tleft_txt2.setText("3 left");
                            }
                            if (count == 12) {
                                utlani5.stop();
                                u_tleft_line5.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line6.setBackgroundResource(R.drawable.underleftanim2);
                                utlani6 = (AnimationDrawable) u_tleft_line6.getBackground();
                                utlani6.start();
                                u_tleft_txt2.setText("2 left");
                            }
                            if (count == 13) {
                                utlani6.stop();
                                u_tleft_line6.setBackgroundResource(R.drawable.line5finish);
                                u_tleft_line7.setBackgroundResource(R.drawable.underleftanim2);
                                utlani7 = (AnimationDrawable) u_tleft_line7.getBackground();
                                utlani7.start();
                                u_tleft_txt2.setText("1 left");
                            } if (count >= 14) {
                                u_tleft_line7.setBackgroundResource(R.drawable.line5finish);
                                component_txt.setText("GOOD JOB");
                                u_tleft_txt1.setText("DONE");
                                u_tleft_txt1.setTextColor(Color.parseColor("#9E0958"));
                                u_tleft_txt2.setText("DONE");
                                u_tleft_txt2.setTextColor(Color.parseColor("#9E0958"));
                                data=25;

                            }
                            if(count==15){
                                databaseReference.child("result").child("underleft_data").setValue(data);
                                //Intent intent = new Intent(getApplicationContext(), DoneActivity_ul.class);
                                //startActivity(intent);
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
        setContentView(R.layout.activity_treat_underleft);

        Resources res = getResources();
        final Drawable  cheekrightimg= res.getDrawable(R.drawable.cheekrightimg);
        final Drawable  cheekleftimg= res.getDrawable(R.drawable.cheekleftimg);
        final Drawable  cheekunderrightimg= res.getDrawable(R.drawable.cheekunderimg);
        final Drawable  cheekunderleftimg= res.getDrawable(R.drawable.cheekunderleft);
        //값 받아오기

        forehead =  (ImageView)findViewById(R.id.forehead_ul);
        underleft =  (ImageView)findViewById(R.id.underleft_ul);
        underright =  (ImageView)findViewById(R.id.underright_ul);
        cheekl =  (ImageView)findViewById(R.id.cheek_left_ul);
        cheekr =  (ImageView)findViewById(R.id.cheek_right_ul);
        mouth =  (ImageView)findViewById(R.id.mouth_ul);
        eyeleft = (ImageView)findViewById(R.id.eyeleft_ul);
        eyeright=(ImageView)findViewById(R.id.eyeright_ul);
        component_txt=(TextView)findViewById(R.id.componenttxt_ul);
        treatback = (RelativeLayout)findViewById(R.id.treatayout_ul);
        underleft_layout=(RelativeLayout)findViewById(R.id.u_tleft_layout);
        treat_default=(RelativeLayout)findViewById(R.id.treat_default_ul);
        back=(ImageView)findViewById(R.id.backw_ul);
        u_tleft_line1=(ImageView)findViewById(R.id.u_tleft_line1);
        u_tleft_line2=(ImageView)findViewById(R.id.u_tleft_line2);
        u_tleft_line3=(ImageView)findViewById(R.id.u_tleft_line3);
        u_tleft_line4=(ImageView)findViewById(R.id.u_tleft_line4);
        u_tleft_line5=(ImageView)findViewById(R.id.u_tleft_line5);
        u_tleft_line6=(ImageView)findViewById(R.id.u_tleft_line6);
        u_tleft_line7=(ImageView)findViewById(R.id.u_tleft_line7);
        u_tleft_line8=(ImageView)findViewById(R.id.u_tleft_line8);
        u_tleft_line9=(ImageView)findViewById(R.id.u_tleft_line9);
        u_tleft_line10=(ImageView)findViewById(R.id.u_tleft_line10);
        u_tleft_line11=(ImageView)findViewById(R.id.u_tleft_line11);
        u_tleft_line12=(ImageView)findViewById(R.id.u_tleft_line12);
        u_tleft_line13=(ImageView)findViewById(R.id.u_tleft_line13);
        u_tright_txt1=(TextView)findViewById(R.id.u_tright_txt1);
        u_tright_txt2=(TextView)findViewById(R.id.u_tright_txt2);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);

        wrinkle_txt = databaseReference.child("result").child("winkle");
        underleft_layout.setVisibility(View.INVISIBLE);

        eyeleft.setClickable(false);
        eyeright.setClickable(false);
        cheekl.setClickable(false);
        cheekr.setClickable(false);
        forehead.setClickable(false);
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

        if(u_tleft_txt1.equals("DONE")){

        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                level=1;

                switch (v.getId()) {
                    case R.id.backw_ul:
                        Intent intent = new Intent(getBaseContext(), TreatActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                    case R.id.underleft_ul:
                            animation();
                            treatback.setBackground(cheekleftimg);
                            treat_default.setVisibility(View.INVISIBLE);
                            underleft_layout.setVisibility(View.VISIBLE);
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
