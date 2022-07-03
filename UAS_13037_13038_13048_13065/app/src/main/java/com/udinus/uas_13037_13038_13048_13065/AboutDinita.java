package com.udinus.uas_13037_13038_13048_13065;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutDinita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dinita);
        TextView textView = (TextView) findViewById(R.id.dinita);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}