package com.udinus.uas_13037_13038_13048_13065;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void clickNauval(View view) {
        Intent i = new Intent(AboutUs.this,  AboutNauval.class);
        startActivity(i);
    }public void clickDinita(View view) {
        Intent i = new Intent(AboutUs.this,  AboutDinita.class);
        startActivity(i);
    }public void clickLeno(View view) {
        Intent i = new Intent(AboutUs.this,  AboutLeno.class);
        startActivity(i);
    }public void clickNurul(View view) {
        Intent i = new Intent(AboutUs.this,  AboutNurul.class);
        startActivity(i);
    }
}