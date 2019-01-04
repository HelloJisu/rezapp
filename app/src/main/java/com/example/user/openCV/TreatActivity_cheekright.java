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

public class TreatActivity_cheekright extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt;
    String wrinkle_string;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back;
    LinearLayout component;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    RelativeLayout treatback, treat_default,cheekright_layout;
    int cheekcount=0, data=0, level=0, timer_sec, count=0;
    ImageView c_tright_line1,c_tright_line2,c_tright_line3,c_tright_line4,c_tright_line5,c_tright_line6,c_tright_line7,c_tright_line8
            ,c_tright_line9,c_tright_line10,c_tright_line11,c_tright_line12,c_tright_line13,c_tright_line14,c_tright_line15,c_tright_line16,c_tright_line17
            ,c_tright_line18,c_tright_line19,c_tright_line20,c_tright_line21,c_tright_line22;
    TimerTask second;
    String part;
    AnimationDrawable ctrani1,ctrani2,ctrani3,ctrani4,ctrani5,ctrani6,ctrani7,ctrani8,ctrani9,ctrani10,ctrani11,ctrani12,ctrani13,ctrani14,ctrani15
            ,ctrani16,ctrani17,ctrani18,ctrani19,ctrani20,ctrani21,ctrani22;


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
                                c_tright_line15.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani15 = (AnimationDrawable) c_tright_line15.getBackground();
                                ctrani15.start();
                            }
                            if (count == 2) {
                                ctrani15.stop();
                                c_tright_line15.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line16.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani16 = (AnimationDrawable) c_tright_line16.getBackground();
                                ctrani16.start();
                                c_tright_txt1.setText("7 left");
                            }
                            if (count == 3) {
                                ctrani16.stop();
                                c_tright_line16.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line17.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani17 = (AnimationDrawable) c_tright_line17.getBackground();
                                ctrani17.start();
                                c_tright_txt1.setText("6 left");
                            }
                            if (count == 4) {
                                ctrani17.stop();
                                c_tright_line17.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line18.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani18 = (AnimationDrawable) c_tright_line18.getBackground();
                                ctrani18.start();
                                c_tright_txt1.setText("5 left");
                            }
                            if (count == 5) {
                                ctrani18.stop();
                                c_tright_line18.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line19.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani19 = (AnimationDrawable) c_tright_line19.getBackground();
                                ctrani19.start();
                                c_tright_txt1.setText("4 left");
                            }
                            if (count == 6) {
                                ctrani19.stop();
                                c_tright_line19.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line20.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani20 = (AnimationDrawable) c_tright_line20.getBackground();
                                ctrani20.start();
                                c_tright_txt1.setText("3 left");
                            }
                            if (count == 7) {
                                ctrani20.stop();
                                c_tright_line20.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line21.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani21 = (AnimationDrawable) c_tright_line21.getBackground();
                                ctrani21.start();
                                c_tright_txt1.setText("2 left");
                            }
                            if (count == 8) {
                                ctrani21.stop();
                                c_tright_line21.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line22.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani22 = (AnimationDrawable) c_tright_line22.getBackground();
                                ctrani22.start();
                                c_tright_txt1.setText("1 left");
                            }
                            if (count == 9) {
                                ctrani22.stop();
                                c_tright_line22.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line1.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani1 = (AnimationDrawable) c_tright_line1.getBackground();
                                ctrani1.start();
                                c_tright_txt1.setText("0 left");
                            }
                            if (count == 10) {
                                ctrani1.stop();
                                c_tright_line1.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line2.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani2 = (AnimationDrawable) c_tright_line2.getBackground();
                                ctrani2.start();
                                c_tright_txt2.setText("13 left");
                            }
                            if (count == 11) {
                                ctrani2.stop();
                                c_tright_line2.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line3.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani3 = (AnimationDrawable) c_tright_line3.getBackground();
                                ctrani3.start();
                                c_tright_txt2.setText("12 left");
                            }
                            if (count == 12) {
                                ctrani3.stop();
                                c_tright_line3.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line4.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani4 = (AnimationDrawable) c_tright_line4.getBackground();
                                ctrani4.start();
                                c_tright_txt2.setText("11 left");
                            }
                            if (count == 13) {
                                ctrani4.stop();
                                c_tright_line4.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line5.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani5 = (AnimationDrawable) c_tright_line5.getBackground();
                                ctrani5.start();
                                c_tright_txt2.setText("10 left");
                            }
                            if (count == 14) {
                                ctrani5.stop();
                                c_tright_line5.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line6.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani6 = (AnimationDrawable) c_tright_line6.getBackground();
                                ctrani6.start();
                                c_tright_txt2.setText("9 left");
                            }
                            if (count == 15) {
                                ctrani6.stop();
                                c_tright_line6.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line7.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani7 = (AnimationDrawable) c_tright_line7.getBackground();
                                ctrani7.start();
                                c_tright_txt2.setText("8 left");
                            }
                            if (count == 16) {
                                ctrani7.stop();
                                c_tright_line7.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line8.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani8 = (AnimationDrawable) c_tright_line8.getBackground();
                                ctrani8.start();
                                c_tright_txt2.setText("7 left");
                            }
                            if (count == 17) {
                                ctrani8.stop();
                                c_tright_line8.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line9.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani9 = (AnimationDrawable) c_tright_line9.getBackground();
                                ctrani9.start();
                                c_tright_txt2.setText("6 left");
                            }
                            if (count == 18) {
                                ctrani9.stop();
                                c_tright_line9.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line10.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani10 = (AnimationDrawable) c_tright_line10.getBackground();
                                ctrani10.start();
                                c_tright_txt2.setText("5 left");
                            }
                            if (count == 19) {
                                ctrani10.stop();
                                c_tright_line10.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line11.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani11 = (AnimationDrawable) c_tright_line11.getBackground();
                                ctrani11.start();
                                c_tright_txt2.setText("4 left");
                            }
                            if (count == 20) {
                                ctrani11.stop();
                                c_tright_line11.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line12.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani12 = (AnimationDrawable) c_tright_line12.getBackground();
                                ctrani12.start();
                                c_tright_txt2.setText("3 left");
                            }
                            if (count == 21) {
                                ctrani12.stop();
                                c_tright_line12.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line13.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani13 = (AnimationDrawable) c_tright_line13.getBackground();
                                ctrani13.start();
                                c_tright_txt2.setText("2 left");
                            }
                            if (count == 22) {
                                ctrani13.stop();
                                c_tright_line13.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line14.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani14 = (AnimationDrawable) c_tright_line14.getBackground();
                                ctrani14.start();
                                c_tright_txt2.setText("1 left");
                            } if (count >= 22) {
                                c_tright_line14.setBackgroundResource(R.drawable.line1finish);
                                component_txt.setText("GOOD JOB");
                                c_tright_txt1.setText("DONE");
                                c_tright_txt1.setTextColor(Color.parseColor("#9E0958"));
                                c_tright_txt2.setText("DONE");
                                c_tright_txt2.setTextColor(Color.parseColor("#9E0958"));
                                data=25;

                            }
                            if(count==23){
                                databaseReference.child("result").child("cheekright_data").setValue(data);
                                //Intent intent = new Intent(getApplicationContext(), DoneActivity_cr.class);
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
                    cheekl.setImageResource(R.drawable.cheekleftlevel1);
                    cheekr.setImageResource(R.drawable.cheekrightlevel1);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 1,\nAND SELECT STARTIG AREA");
                }
                if(level==2){
                    cheekl.setImageResource(R.drawable.cheekleftlevel2);
                    cheekr.setImageResource(R.drawable.cheekrightlevel2);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 2,\nAND SELECT STARTIG AREA");
                }
                if(level==3){
                    cheekl.setImageResource(R.drawable.cheekleftlevel3);
                    cheekr.setImageResource(R.drawable.cheekrightlevel3);
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
        setContentView(R.layout.activity_treat_cheekright);

        Resources res = getResources();
        final Drawable  cheekrightimg= res.getDrawable(R.drawable.cheekrightimg);
        final Drawable  cheekleftimg= res.getDrawable(R.drawable.cheekleftimg);
        final Drawable  cheekunderrightimg= res.getDrawable(R.drawable.cheekunderimg);
        final Drawable  cheekunderleftimg= res.getDrawable(R.drawable.cheekunderleft);
        //값 받아오기

        forehead =  (ImageView)findViewById(R.id.forehead_cr);
        underleft =  (ImageView)findViewById(R.id.underleft_cr);
        underright =  (ImageView)findViewById(R.id.underright_cr);
        cheekl =  (ImageView)findViewById(R.id.cheek_left_cr);
        cheekr =  (ImageView)findViewById(R.id.cheek_right_cr);
        mouth =  (ImageView)findViewById(R.id.mouth_cr);
        eyeleft = (ImageView)findViewById(R.id.eyeleft_cr);
        eyeright=(ImageView)findViewById(R.id.eyeright_cr);
        component_txt=(TextView)findViewById(R.id.componenttxt_cr);
        treatback = (RelativeLayout)findViewById(R.id.treatayout_cr);
        treat_default=(RelativeLayout)findViewById(R.id.treat_default_cr);
        cheekright_layout=(RelativeLayout)findViewById(R.id.c_tright_layout);
        back=(ImageView)findViewById(R.id.backw_cr);
        c_tright_line1=(ImageView)findViewById(R.id.c_tright_line1);
        c_tright_line2=(ImageView)findViewById(R.id.c_tright_line2);
        c_tright_line3=(ImageView)findViewById(R.id.c_tright_line3);
        c_tright_line4=(ImageView)findViewById(R.id.c_tright_line4);
        c_tright_line5=(ImageView)findViewById(R.id.c_tright_line5);
        c_tright_line6=(ImageView)findViewById(R.id.c_tright_line6);
        c_tright_line7=(ImageView)findViewById(R.id.c_tright_line7);
        c_tright_line8=(ImageView)findViewById(R.id.c_tright_line8);
        c_tright_line9=(ImageView)findViewById(R.id.c_tright_line9);
        c_tright_line10=(ImageView)findViewById(R.id.c_tright_line10);
        c_tright_line11=(ImageView)findViewById(R.id.c_tright_line11);
        c_tright_line12=(ImageView)findViewById(R.id.c_tright_line12);
        c_tright_line13=(ImageView)findViewById(R.id.c_tright_line13);
        c_tright_line14=(ImageView)findViewById(R.id.c_tright_line14);
        c_tright_line15=(ImageView)findViewById(R.id.c_tright_line15);
        c_tright_line16=(ImageView)findViewById(R.id.c_tright_line16);
        c_tright_line17=(ImageView)findViewById(R.id.c_tright_line17);
        c_tright_line18=(ImageView)findViewById(R.id.c_tright_line18);
        c_tright_line19=(ImageView)findViewById(R.id.c_tright_line19);
        c_tright_line20=(ImageView)findViewById(R.id.c_tright_line20);
        c_tright_line21=(ImageView)findViewById(R.id.c_tright_line21);
        c_tright_line22=(ImageView)findViewById(R.id.c_tright_line22);
        u_tright_txt1=(TextView)findViewById(R.id.u_tright_txt1);
        u_tright_txt2=(TextView)findViewById(R.id.u_tright_txt2);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);


        cheekright_layout.setVisibility(View.INVISIBLE);

        wrinkle_txt = databaseReference.child("result").child("winkle");
        eyeleft.setClickable(false);
        eyeright.setClickable(false);
        underleft.setClickable(false);
        underright.setClickable(false);
        forehead.setClickable(false);
        if(level==1){
            cheekl.setImageResource(R.drawable.cheekleftlevel1);
            cheekr.setImageResource(R.drawable.cheekrightlevel1);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 1,\nAND SELECT STARTIG AREA");
        }
        if(level==2){
            cheekl.setImageResource(R.drawable.cheekleftlevel2);
            cheekr.setImageResource(R.drawable.cheekrightlevel2);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 2,\nAND SELECT STARTIG AREA");
        }
        if(level==3){
            cheekl.setImageResource(R.drawable.cheekleftlevel3);
            cheekr.setImageResource(R.drawable.cheekrightlevel3);
            component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 3,\nAND SELECT STARTIG AREA");
        }

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                level=1;

                switch (v.getId()) {
                    case R.id.backw_cr:
                        Intent intent = new Intent(getBaseContext(), TreatActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;

                    case R.id.cheek_right_cr:
                            animation();
                            treatback.setBackground(cheekunderrightimg);
                            treat_default.setVisibility(View.INVISIBLE);
                            cheekright_layout.setVisibility(View.VISIBLE);
                        component_txt.setText("THIS COLUMN HAS 7 LINES.\nPLACE THE DEVIECE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE.");
                        cheekcount=0;
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
