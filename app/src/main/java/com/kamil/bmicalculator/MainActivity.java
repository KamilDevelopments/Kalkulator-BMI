package com.kamil.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.kamil.android.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText mMessageEditText;
    private EditText poleTekstowe2;
    int lbs=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleTekstowe2 = (EditText)findViewById(R.id.editText5);
        mMessageEditText = (EditText) findViewById(R.id.editText4);

    }

    public void launchSecondActivity(View view) {
        TextView weighteng =(TextView) findViewById(R.id.textView2);
        TextView heighteng =(TextView) findViewById(R.id.textView3);
        TextView weightam =(TextView) findViewById(R.id.textView2);
        TextView heightam =(TextView) findViewById(R.id.textView3);
        //przełącznik lbs/kg
        Switch sw = findViewById(R.id.switch1);
        if (!sw.isChecked()){
            heighteng.setText(R.string.heighteng);
            weighteng.setText(R.string.weighteng);
            lbs=1;
        } else {
            heightam.setText(R.string.heightam);
            weightam.setText(R.string.weightam);
            lbs=2;
        }

    }

    public void send(View view) {

            //Sprawdzenie czy użytkownik wpisał obie wartości i podał prawidłowe dane
            if (mMessageEditText.getText().toString().isEmpty() && poleTekstowe2.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), (R.string.toast1), Toast.LENGTH_LONG);
                View view1 = toast.getView();
                view1.setBackgroundResource(R.color.lblue);
                toast.show();
                return;
            }

            //Sprawdzenie czy użytkownik wpisał wage i czy jest ona prawidłowa
            if (mMessageEditText.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), (R.string.toast2), Toast.LENGTH_LONG);
                View view1 = toast.getView();
                view1.setBackgroundResource(R.color.lblue);
                toast.show();
                return;

            }
            //Sprawdzenie czy użytkownik wpisał wzrost
            if (poleTekstowe2.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), (R.string.toast3), Toast.LENGTH_LONG);
                View view1 = toast.getView();
                view1.setBackgroundResource(R.color.lblue);
                toast.show();
                return;
            }
            if (!poleTekstowe2.getText().toString().isEmpty()&&!mMessageEditText.getText().toString().isEmpty()) {
            int waga = Integer.parseInt(mMessageEditText.getText().toString());
            int wzrost = Integer.parseInt(poleTekstowe2.getText().toString());
            if(waga<3||waga>400||wzrost>400||wzrost<20) {
                Toast toast = Toast.makeText(getApplicationContext(), (R.string.toast4), Toast.LENGTH_LONG);
                View view1 = toast.getView();
                view1.setBackgroundResource(R.color.lblue);
                toast.show();
                return;
            }
        }
            //Intent wysyłający wagę, wzrost i ustawienie kg/lbs
            Intent intentWszystko = new Intent(this, SecondActivity.class);
            intentWszystko.putExtra("waga", mMessageEditText.getText().toString());
            intentWszystko.putExtra("wzrost", poleTekstowe2.getText().toString());
            intentWszystko.putExtra("lbs", lbs);
            startActivity(intentWszystko);
        }

}