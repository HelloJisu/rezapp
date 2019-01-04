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

public class TreatActivity_cheekleft extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt;
    String wrinkle_string;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back;
    LinearLayout component;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    RelativeLayout treatback,treat_default,cheekleft_layout;
    int cheekcount=0, data=0, level=0, timer_sec, count=0;
    ImageView c_tleft_line1,c_tleft_line2,c_tleft_line3,c_tleft_line4,c_tleft_line5,c_tleft_line6,c_tleft_line7,c_tleft_line8
            ,c_tleft_line9,c_tleft_line10,c_tleft_line11,c_tleft_line12,c_tleft_line13,c_tleft_line14,c_tleft_line15,c_tleft_line16,c_tleft_line17
            ,c_tleft_line18,c_tleft_line19,c_tleft_line20,c_tleft_line21,c_tleft_line22;
    TimerTask second;
    String part;
    AnimationDrawable ctlani1,ctlani2,ctlani3,ctlani4,ctlani5,ctlani6,ctlani7,ctlani8,ctlani9,ctlani10,ctlani11,ctlani12,ctlani13,ctlani14,ctlani15
            ,ctlani16,ctlani17,ctlani18,ctlani19,ctlani20,ctlani21,ctlani22;


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
                                c_tleft_line15.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani15 = (AnimationDrawable) c_tleft_line15.getBackground();
                                ctlani15.start();
                            }
                            if (count == 2) {
                                ctlani15.stop();
                                c_tleft_line15.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line16.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani16 = (AnimationDrawable) c_tleft_line16.getBackground();
                                ctlani16.start();
                                c_tleft_txt1.setText("7 left");
                            }
                            if (count == 3) {
                                ctlani16.stop();
                                c_tleft_line16.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line17.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani17 = (AnimationDrawable) c_tleft_line17.getBackground();
                                ctlani17.start();
                                c_tleft_txt1.setText("6 left");
                            }
                            if (count == 4) {
                                ctlani17.stop();
                                c_tleft_line17.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line18.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani18 = (AnimationDrawable) c_tleft_line18.getBackground();
                                ctlani18.start();
                                c_tleft_txt1.setText("5 left");
                            }
                            if (count == 5) {
                                ctlani18.stop();
                                c_tleft_line18.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line19.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani19 = (AnimationDrawable) c_tleft_line19.getBackground();
                                ctlani19.start();
                                c_tleft_txt1.setText("4 left");
                            }
                            if (count == 6) {
                                ctlani19.stop();
                                c_tleft_line19.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line20.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani20 = (AnimationDrawable) c_tleft_line20.getBackground();
                                ctlani20.start();
                                c_tleft_txt1.setText("3 left");
                            }
                            if (count == 7) {
                                ctlani20.stop();
                                c_tleft_line20.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line21.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani21 = (AnimationDrawable) c_tleft_line21.getBackground();
                                ctlani21.start();
                                c_tleft_txt1.setText("2 left");
                            }
                            if (count == 8) {
                                ctlani21.stop();
                                c_tleft_line21.setBackgroundResource(R.drawable.line321finish);
                                c_tleft_line22.setBackgroundResource(R.drawable.cheekleftanim1);
                                ctlani22 = (AnimationDrawable) c_tleft_line22.getBackground();
                                ctlani22.start();
                                c_tleft_txt1.setText("1 left");
                            }
                            if (count == 9) {
                                ctlani22.stop();
                                c_tleft_line22.setBackgroundResource(R.drawable.line123finish);
                                c_tleft_line1.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani1 = (AnimationDrawable) c_tleft_line1.getBackground();
                                ctlani1.start();
                                c_tleft_txt1.setText("0 left");
                            }
                            if (count == 10) {
                                ctlani1.stop();
                                c_tleft_line1.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line2.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani2 = (AnimationDrawable) c_tleft_line2.getBackground();
                                ctlani2.start();
                                c_tleft_txt2.setText("13 left");
                            }
                            if (count == 11) {
                                ctlani2.stop();
                                c_tleft_line2.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line3.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani3 = (AnimationDrawable) c_tleft_line3.getBackground();
                                ctlani3.start();
                                c_tleft_txt2.setText("12 left");
                            }
                            if (count == 12) {
                                ctlani3.stop();
                                c_tleft_line3.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line4.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani4 = (AnimationDrawable) c_tleft_line4.getBackground();
                                ctlani4.start();
                                c_tleft_txt2.setText("11 left");
                            }
                            if (count == 13) {
                                ctlani4.stop();
                                c_tleft_line4.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line5.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani5 = (AnimationDrawable) c_tleft_line5.getBackground();
                                ctlani5.start();
                                c_tleft_txt2.setText("10 left");
                            }
                            if (count == 14) {
                                ctlani5.stop();
                                c_tleft_line5.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line6.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani6 = (AnimationDrawable) c_tleft_line6.getBackground();
                                ctlani6.start();
                                c_tleft_txt2.setText("9 left");
                            }
                            if (count == 15) {
                                ctlani6.stop();
                                c_tleft_line6.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line7.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani7 = (AnimationDrawable) c_tleft_line7.getBackground();
                                ctlani7.start();
                                c_tleft_txt2.setText("8 left");
                            }
                            if (count == 16) {
                                ctlani7.stop();
                                c_tleft_line7.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line8.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani8 = (AnimationDrawable) c_tleft_line8.getBackground();
                                ctlani8.start();
                                c_tleft_txt2.setText("7 left");
                            }
                            if (count == 17) {
                                ctlani8.stop();
                                c_tleft_line8.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line9.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani9 = (AnimationDrawable) c_tleft_line9.getBackground();
                                ctlani9.start();
                                c_tleft_txt2.setText("6 left");
                            }
                            if (count == 18) {
                                ctlani9.stop();
                                c_tleft_line9.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line10.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani10 = (AnimationDrawable) c_tleft_line10.getBackground();
                                ctlani10.start();
                                c_tleft_txt2.setText("5 left");
                            }
                            if (count == 19) {
                                ctlani10.stop();
                                c_tleft_line10.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line11.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani11 = (AnimationDrawable) c_tleft_line11.getBackground();
                                ctlani11.start();
                                c_tleft_txt2.setText("4 left");
                            }
                            if (count == 20) {
                                ctlani11.stop();
                                c_tleft_line11.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line12.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani12 = (AnimationDrawable) c_tleft_line12.getBackground();
                                ctlani12.start();
                                c_tleft_txt2.setText("3 left");
                            }
                            if (count == 21) {
                                ctlani12.stop();
                                c_tleft_line12.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line13.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani13 = (AnimationDrawable) c_tleft_line13.getBackground();
                                ctlani13.start();
                                c_tleft_txt2.setText("2 left");
                            }
                            if (count == 22) {
                                ctlani13.stop();
                                c_tleft_line13.setBackgroundResource(R.drawable.line5finish);
                                c_tleft_line14.setBackgroundResource(R.drawable.cheekleftanim2);
                                ctlani14 = (AnimationDrawable) c_tleft_line14.getBackground();
                                ctlani14.start();
                                c_tleft_txt2.setText("1 left");
                            }if (count >= 22) {
                            c_tleft_line14.setBackgroundResource(R.drawable.line5finish);
                            component_txt.setText("GOOD JOB");
                            c_tleft_txt1.setText("DONE");
                            c_tleft_txt1.setTextColor(Color.parseColor("#9E0958"));
                            c_tleft_txt2.setText("DONE");
                            c_tleft_txt2.setTextColor(Color.parseColor("#9E0958"));
                            data = 25;

                        }
                            if(count==23){
                                databaseReference.child("result").child("cheekleft_data").setValue(data);
                                //Intent intent = new Intent(getApplicationContext(), DoneActivity_cl.class);
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
                if (level == 1) {
                    cheekl.setImageResource(R.drawable.cheekleftlevel1);
                    cheekr.setImageResource(R.drawable.cheekrightlevel1);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 1,\nAND SELECT STARTIG AREA");
                }
                if (level == 2) {
                    cheekl.setImageResource(R.drawable.cheekleftlevel2);
                    cheekr.setImageResource(R.drawable.cheekrightlevel2);
                    component_txt.setText("PLEASE SET THE DEVICE\nON LEVEL 2,\nAND SELECT STARTIG AREA");
                }
                if (level == 3) {
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
        setContentView(R.layout.activity_treat_cheekleft);

        Resources res = getResources();
        final Drawable  cheekrightimg= res.getDrawable(R.drawable.cheekrightimg);
        final Drawable  cheekleftimg= res.getDrawable(R.drawable.cheekleftimg);
        final Drawable  cheekunderrightimg= res.getDrawable(R.drawable.cheekunderimg);
        final Drawable  cheekunderleftimg= res.getDrawable(R.drawable.cheekunderleft);

        //값 받아오기

        forehead =  (ImageView)findViewById(R.id.forehead_cl);
        underleft =  (ImageView)findViewById(R.id.underleft_cl);
        underright =  (ImageView)findViewById(R.id.underright_cl);
        cheekl =  (ImageView)findViewById(R.id.cheek_left_cl);
        cheekr =  (ImageView)findViewById(R.id.cheek_right_cl);
        mouth =  (ImageView)findViewById(R.id.mouth_cl);
        eyeleft = (ImageView)findViewById(R.id.eyeleft_cl);
        eyeright=(ImageView)findViewById(R.id.eyeright_cl);
        component_txt=(TextView)findViewById(R.id.componenttxt_cl);
        treatback = (RelativeLayout)findViewById(R.id.treatayout_cl);
        treat_default=(RelativeLayout)findViewById(R.id.treat_default_cl);
        cheekleft_layout=(RelativeLayout)findViewById(R.id.c_tleft_layout);
        back=(ImageView)findViewById(R.id.backw_cl);
        c_tleft_line1=(ImageView)findViewById(R.id.c_tleft_line1);
        c_tleft_line2=(ImageView)findViewById(R.id.c_tleft_line2);
        c_tleft_line3=(ImageView)findViewById(R.id.c_tleft_line3);
        c_tleft_line4=(ImageView)findViewById(R.id.c_tleft_line4);
        c_tleft_line5=(ImageView)findViewById(R.id.c_tleft_line5);
        c_tleft_line6=(ImageView)findViewById(R.id.c_tleft_line6);
        c_tleft_line7=(ImageView)findViewById(R.id.c_tleft_line7);
        c_tleft_line8=(ImageView)findViewById(R.id.c_tleft_line8);
        c_tleft_line9=(ImageView)findViewById(R.id.c_tleft_line9);
        c_tleft_line10=(ImageView)findViewById(R.id.c_tleft_line10);
        c_tleft_line11=(ImageView)findViewById(R.id.c_tleft_line11);
        c_tleft_line12=(ImageView)findViewById(R.id.c_tleft_line12);
        c_tleft_line13=(ImageView)findViewById(R.id.c_tleft_line13);
        c_tleft_line14=(ImageView)findViewById(R.id.c_tleft_line14);
        c_tleft_line15=(ImageView)findViewById(R.id.c_tleft_line15);
        c_tleft_line16=(ImageView)findViewById(R.id.c_tleft_line16);
        c_tleft_line17=(ImageView)findViewById(R.id.c_tleft_line17);
        c_tleft_line18=(ImageView)findViewById(R.id.c_tleft_line18);
        c_tleft_line19=(ImageView)findViewById(R.id.c_tleft_line19);
        c_tleft_line20=(ImageView)findViewById(R.id.c_tleft_line20);
        c_tleft_line21=(ImageView)findViewById(R.id.c_tleft_line21);
        c_tleft_line22=(ImageView)findViewById(R.id.c_tleft_line22);
        u_tright_txt1=(TextView)findViewById(R.id.u_tright_txt1);
        u_tright_txt2=(TextView)findViewById(R.id.u_tright_txt2);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);

        cheekleft_layout.setVisibility(View.INVISIBLE);

        wrinkle_txt = databaseReference.child("result").child("winkle");

        eyeleft.setClickable(false);
        eyeright.setClickable(false);
        underleft.setClickable(false);
        underright.setClickable(false);
        forehead.setClickable(false);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                level=1;

                switch (v.getId()) {
                    case R.id.backw_cl:
                        Intent intent = new Intent(getBaseContext(), TreatActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();
                        break;

                    case R.id.cheek_left_cl:
                        animation();
                        treatback.setBackground(cheekunderleftimg);
                        treat_default.setVisibility(View.INVISIBLE);
                        cheekleft_layout.setVisibility(View.VISIBLE);
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
