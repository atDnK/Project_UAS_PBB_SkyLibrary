package com.udinus.uas_13037_13038_13048_13065;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MenuActivity extends AppCompatActivity {
    private TextView textName;
    private FirebaseUser firebaseUser;
    private Button btnLogout;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnLogout = findViewById(R.id.btn_logout);
        textName = findViewById(R.id.name);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!=null) {
            textName.setText(firebaseUser.getDisplayName());
        }else {
            textName.setText("Login gagal!");
        }

        btnLogout.setOnClickListener(v->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), WelcomeBackActivity.class));
            finish();
        });
    }

    public void clickList(View view) {
        Intent i = new Intent(MenuActivity.this, ListBookActivity.class);
        startActivity(i);
    }

    public void clickPinjam(View view) {
        Intent i = new Intent(MenuActivity.this, PinjamActivity.class);
        startActivity(i);
    }

    public void clickLocation(View view) {
        Intent i = new Intent(MenuActivity.this, MapsActivity.class);
        startActivity(i);
    }

    public void clickAbout(View view) {
        Intent i = new Intent(MenuActivity.this, AboutUs.class);
        startActivity(i);
    }

}