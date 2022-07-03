package com.udinus.uas_13037_13038_13048_13065;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeBackActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private TextView forgotPassword;
    private Button btnLogin, btnRegister;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        forgotPassword = findViewById(R.id.forgot_pass);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        progressDialog = new ProgressDialog(WelcomeBackActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);

        mAuth = FirebaseAuth.getInstance();

        forgotPassword.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
        });

        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        });

        btnLogin.setOnClickListener(v -> {
            if(editEmail.getText().length()>0 && editPassword.getText().length()>0){
                login(editEmail.getText().toString(), editPassword.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan mengisi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void login(String email, String password) {
        progressDialog.show();
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if (task.isSuccessful() && task.getResult()!=null){
                                if (task.getResult().getUser()!=null){
                                    reload();
                                }else{
                                    Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Login gagal", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }
}