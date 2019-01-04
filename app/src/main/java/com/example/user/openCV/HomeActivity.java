package com.example.user.openCV;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class HomeActivity extends AppCompatActivity {

    int per = 0, perr=0;
    double perwidth=0;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt, moisture_txt, skintype_txt, wrinklemain_txt, moisturemain_txt, crdata, cldata, urdata, uldata;
    long crdataint, cldataint, urdataint, uldataint;
    int crdataint1, cldataint2, urdataint3, uldataint4;
    String wrinkle_string, moisture_string, skintype_string;
    RelativeLayout card, skin_type, design_bottom_sheet, dashboard, toolbar;
    LinearLayout moisture, wrinkles, toolbar_dash;
    ImageView image, layer1, layer2, arrow, logo;
    Button treatbtn, historyBtn;
    BottomSheetBehavior bottomSheetBehavior;
    View line_main3;
    TextView skintype_result, moisture_score, wrinkle_score, moisture_status, wrinkle_status, moisture_score_main, wrinkle_score_main, question, weekend_main2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 값 받아오기
        moisture = findViewById(R.id.moisture);
        wrinkles = findViewById(R.id.wrinkles);
        toolbar_dash = findViewById(R.id.toolbar_dash);
        skin_type = findViewById(R.id.skin_type);
        card = findViewById(R.id.sdcond);
        design_bottom_sheet = findViewById(R.id.design_bottom_sheet);
        dashboard = findViewById(R.id.dashboard);
        toolbar = findViewById(R.id.toolbar);
        image = findViewById(R.id.image);
        layer1 = findViewById(R.id.layer1);
        layer2 = findViewById(R.id.layer2);
        arrow = findViewById(R.id.arrow_dash);
        treatbtn = findViewById(R.id.treatBtn);
        skintype_result = findViewById(R.id.skintype_result);
        moisture_score = findViewById(R.id.moisture_score);
        wrinkle_score = findViewById(R.id.wrinkle_score);
        moisture_status = findViewById(R.id.moisture_status);
        wrinkle_status = findViewById(R.id.wrinkle_status);
        moisture_score_main = findViewById(R.id.moisture_result_main);
        wrinkle_score_main = findViewById(R.id.wrinkle_result_main);
        logo = findViewById(R.id.logo);
        question = findViewById(R.id.question);
        historyBtn = findViewById(R.id.historyBtn);
        ImageView monCheck, tueCheck, wedCheck, thuCheck, friCheck;
        monCheck = findViewById(R.id.monCheck);
        tueCheck = findViewById(R.id.tueCheck);
        wedCheck = findViewById(R.id.wedCheck);
        thuCheck = findViewById(R.id.thuCheck);
        friCheck = findViewById(R.id.friCheck);
        line_main3 = findViewById(R.id.line_main3);
        weekend_main2 = findViewById(R.id.weekend_main2);

// check
        // check
        //Calendar cal = Calendar.getInstance();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        //cal.setTimeZone(time);
        int day = cal.get(Calendar.DAY_OF_WEEK);    // 1=일 2=월 3=화 4=수 5=목 6=금 7=토// 1=일 2=월 3=화 4=수 5=목 6=금 7=토
        switch (day) {
            case 2: // 월
                monCheck.setImageResource(R.drawable.ximg);
                tueCheck.setImageResource(R.drawable.noncheck);
                wedCheck.setImageResource(R.drawable.noncheck);
                thuCheck.setImageResource(R.drawable.noncheck);
                friCheck.setImageResource(R.drawable.noncheck);
                break;
            case 3: // 화
                monCheck.setImageResource(R.drawable.ximg);
                tueCheck.setImageResource(R.drawable.check);
                wedCheck.setImageResource(R.drawable.noncheck);
                thuCheck.setImageResource(R.drawable.noncheck);
                friCheck.setImageResource(R.drawable.noncheck);
                break;
            case 4: // 수
                monCheck.setImageResource(R.drawable.ximg);
                tueCheck.setImageResource(R.drawable.check);
                wedCheck.setImageResource(R.drawable.check);
                thuCheck.setImageResource(R.drawable.noncheck);
                friCheck.setImageResource(R.drawable.noncheck);
                break;
            case 5: // 목
                monCheck.setImageResource(R.drawable.ximg);
                tueCheck.setImageResource(R.drawable.check);
                wedCheck.setImageResource(R.drawable.check);
                thuCheck.setImageResource(R.drawable.check);
                friCheck.setImageResource(R.drawable.noncheck);
                break;
            case 6: // 금
                monCheck.setImageResource(R.drawable.ximg);
                tueCheck.setImageResource(R.drawable.check);
                wedCheck.setImageResource(R.drawable.check);
                thuCheck.setImageResource(R.drawable.check);
                friCheck.setImageResource(R.drawable.check);
                break;
        }

        // init the Bottom Sheet Behavior
        bottomSheetBehavior = BottomSheetBehavior.from(design_bottom_sheet);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        // 시작할 때 DashBoard와 기계 이미지 안보이게 하기
        dashboard.setVisibility(View.INVISIBLE);
        image.setVisibility(View.INVISIBLE);
        layer1.setVisibility(View.INVISIBLE);
        layer2.setVisibility(View.INVISIBLE);

        Random rand = new Random();
        int r = rand.nextInt(3);

        switch (r) {
            case 0:
                perr=25;
                break;
            case 1:
                perr=50;
                break;
            case 2:
                perr=75;
                break;
        }


        // set hideable or not
        bottomSheetBehavior.setHideable(false);

        //animation
        final Animation scaletranslate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_scaletranslate);
        final Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_alpha);
        final Animation alpha2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_alpha2);
        final Animation scaletranslate2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_scaletranslate2);

        wrinkle_txt = databaseReference.child("result").child("winkle");
        moisture_txt = databaseReference.child("result").child("moisture");
        skintype_txt = databaseReference.child("result").child("skintype");
        wrinklemain_txt = databaseReference.child("result").child("winkle");
        moisturemain_txt = databaseReference.child("result").child("moisture");
        crdata = databaseReference.child("result").child("cheekright_data");
        cldata = databaseReference.child("result").child("cheekleft_data");
        urdata = databaseReference.child("result").child("underrigh_data");
        uldata = databaseReference.child("result").child("underleft_data");

        // set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

            @Override
            public void onStateChanged(@NonNull View view, int i) {
                dashboard.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                layer1.setVisibility(View.INVISIBLE);
                layer2.setVisibility(View.INVISIBLE);

                // Dash -> Home으로 Dragging 해도 화면 전환이 되지 않게 함
                if (i == 1) {      //STATE_DRAGGING
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

                // Dash 화면
                if (i == 3) {      //STATE_EXPANDED
                    dashboard.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                    layer1.setVisibility(View.VISIBLE);
                    layer2.setVisibility(View.VISIBLE);
                }
            }

            // 슬라이드시 화면 보이게
            @Override
            public void onSlide(@NonNull View view, float v) {
            }

        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            Intent intent;

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.treatBtn:
                        intent = new Intent(getApplicationContext(), LoadingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.moisture:
                        intent = new Intent(getApplicationContext(), MoistureActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.wrinkles:
                        intent = new Intent(getApplicationContext(), WrinklesActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.skin_type:
                        intent = new Intent(getApplicationContext(), SkintypeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.toolbar:
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        dashboard.setVisibility(View.VISIBLE);
                        dashboard.startAnimation(alpha);
                        layer1.setVisibility(View.VISIBLE);
                        layer2.setVisibility(View.VISIBLE);
                        layer1.startAnimation(alpha);
                        layer2.startAnimation(alpha);
                        image.startAnimation(scaletranslate);
                        toolbar.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.arrow_dash:
                    case R.id.toolbar_dash:
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        dashboard.startAnimation(alpha2);
                        layer1.setVisibility(View.INVISIBLE);
                        layer2.setVisibility(View.INVISIBLE);
                        layer1.startAnimation(alpha2);
                        layer2.startAnimation(alpha2);
                        image.startAnimation(scaletranslate2);
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.logo:
                        databaseReference.child("result").child("skintype").setValue("No data yet");
                        databaseReference.child("result").child("moisture").setValue("-");
                        databaseReference.child("result").child("winkle").setValue("-");
                        databaseReference.child("result").child("cheekright_data").setValue(0);
                        databaseReference.child("result").child("cheekleft_data").setValue(0);
                        databaseReference.child("result").child("underleft_data").setValue(0);
                        databaseReference.child("result").child("underrigh_data").setValue(0);

                        break;
                    case R.id.historyBtn:
                        intent = new Intent(getApplicationContext(), SkinhistoryActivity.class);
                        startActivity(intent);
                }
            }
        };
        historyBtn.setOnClickListener(onClickListener);
        moisture.setOnClickListener(onClickListener);
        wrinkles.setOnClickListener(onClickListener);
        skin_type.setOnClickListener(onClickListener);
        toolbar.setOnClickListener(onClickListener);
        toolbar_dash.setOnClickListener(onClickListener);
        arrow.setOnClickListener(onClickListener);
        treatbtn.setOnClickListener(onClickListener);
        logo.setOnClickListener(onClickListener);

        perwidth = line_main3.getWidth();
        Log.e("퍼", String.valueOf(per));
        line_main3.getLayoutParams().width = (per*9);
        if(per*9>840){
            line_main3.getLayoutParams().width = 837;
        }
        line_main3.requestLayout();

        if(per>100){
            per=100;
        }

        weekend_main2.setText(per + "%");
    }

//database
public void onStart() {
    super.onStart();
    wrinkle_txt.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            wrinkle_string=dataSnapshot.getValue(String.class);
            wrinkle_score.setText(wrinkle_string);
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    wrinklemain_txt.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            wrinkle_string=dataSnapshot.getValue(String.class);
            wrinkle_score_main.setText(wrinkle_string);
            if(wrinkle_string.equals("-") || wrinkle_string.equals(null)){
                wrinkle_status.setText("");
            }
            else{
                wrinkle_status.setText("Good Balance!");
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    moisture_txt.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            moisture_string =dataSnapshot.getValue(String.class);
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    moisture_score.setText(moisture_string);
                }
            }, 500);
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    moisturemain_txt.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            moisture_string =dataSnapshot.getValue(String.class);
            moisture_score_main.setText(moisture_string);

            if(moisture_string.equals("-") || moisture_string.equals(null)){
                moisture_status.setText("");
            }
            else{
                moisture_status.setText("Great!");
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    crdata.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            crdataint=dataSnapshot.getValue(long.class);
            if(crdataint>25){
                crdataint=25;
            }
            Log.e("야", String.valueOf(crdataint));
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    cldata.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            cldataint=dataSnapshot.getValue(long.class);
            if(cldataint>25){
                cldataint=25;
            }
            Log.e("야", String.valueOf(cldataint));

        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    urdata.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            urdataint=dataSnapshot.getValue(long.class);
            if(urdataint>25){
                urdataint=25;
            }
            Log.e("야", String.valueOf(urdataint));
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    uldata.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            uldataint=dataSnapshot.getValue(long.class);
            if(uldataint>25){
                uldataint=25;
            }
            Log.e("야", String.valueOf(uldataint));

        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });
    skintype_txt.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            skintype_string =dataSnapshot.getValue(String.class);
            skintype_result.setText(skintype_string);
            if(skintype_string.equals("No data yet") || skintype_string.equals(null)){
                question.setText("Do you want to find out your skin type?");
            }
            else{
                question.setText("");
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) { }
    });

}
}