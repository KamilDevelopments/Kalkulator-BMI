package com.kamil.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.kamil.android.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

     //odebranie wartości z activity main
    Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.textView7);
        TextView textView1 = (TextView) findViewById(R.id.textView5);
        TextView textView2 = (TextView) findViewById(R.id.textView12);
        //przypisanie wartości do zmiennych
        Float waga = Float.parseFloat(intent.getStringExtra("waga"));
        Float wzrost = Float.parseFloat(intent.getStringExtra("wzrost"));
        int lbs = intent.getIntExtra("lbs",1);

        //działanie do BMI
        if(lbs==2){
        waga=waga/2;
        wzrost=wzrost*254;
        wzrost=wzrost/100 ;
        }
        wzrost=wzrost/100;
        Float BMI = waga / (wzrost*wzrost);
        //Wypisanie BMI i komentarza
        String s = String.format("%.2f", BMI);
        if(BMI>25){
            float lose = BMI-25;
            float ile = (lose * (wzrost*wzrost));

            if(lbs==1) {
                String k = String.format("%.2f", ile);
                textView2.setText(getString(R.string.weightlose) + " " + k + " " + getString(R.string.weightlose2));
            }
            if(lbs==2) {
                ile=ile*2;
                String k = String.format("%.2f", ile);
                textView2.setText(getString(R.string.weightlose) + " " + k + " " + getString(R.string.weightlose3));
            }
        }
        if(BMI<18.5){
            double lose =BMI-18.5;
            lose=lose*-1;
            double ile = (lose * (wzrost*wzrost));

            if(lbs==1) {
                String k = String.format("%.2f", ile);
                textView2.setText(getString(R.string.weightgain) + " " + k + " " + getString(R.string.weightgain2));
            }
            if(lbs==2) {
                ile=ile*2;
                String k = String.format("%.2f", ile);
                textView2.setText(getString(R.string.weightgain) + " " + k + " " + getString(R.string.weightgain3));
            }
        }
    if(BMI<16){
        textView.setText(R.string.BMI1);
        }
        if(BMI>=16 & BMI<17){
            textView.setText(R.string.BMI2);
        }
        if(BMI>=17 & BMI<18.5){
            textView.setText(R.string.BMI3);
        }
        if(BMI>=18.5 & BMI<25){
            textView.setText(R.string.BMI4);
        }
        if(BMI>=25 & BMI<30){
            textView.setText(R.string.BMI5);
        }
        if(BMI<=35 & BMI>30){
            textView.setText(R.string.BMI6);
        }
        if(BMI<=40 & BMI>35){
            textView.setText(R.string.BMI7);
        }
        if(BMI>40){
            textView.setText(R.string.BMI8);
        }


        textView1.setText(s);
        int bmi=Math.round(BMI);
        bmi=bmi/2;
        SeekBar seekBarMy = findViewById(R.id.seekBar3);
        seekBarMy.setProgress(bmi);

        seekBarMy.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

    }

}
