package com.udinus.uas_13037_13038_13048_13065;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText editEmail, editName, editPassword, editConfirmPass, editNim, editJurusan, editSemester;
    private FirebaseAuth mAuth;
    private Button btnSignup, btnLogin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editEmail = (EditText) findViewById(R.id.email);
        editName = (EditText) findViewById(R.id.name);
        editNim = (EditText) findViewById(R.id.nim);
        editPassword = (EditText) findViewById(R.id.password);
        editJurusan = (EditText) findViewById(R.id.jurusan);
        editSemester = (EditText) findViewById(R.id.semester);
        editConfirmPass = (EditText) findViewById(R.id.confirm_password);
        btnSignup = (Button) findViewById(R.id.btn_register);
        btnLogin = (Button) findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan tunggu");
        progressDialog.setCancelable(false);
        btnLogin.setOnClickListener(v -> {
            finish();
        });

        btnSignup.setOnClickListener(v -> {
            if(editEmail.getText().length()>0 && editPassword.getText().length()>0 && editName.getText().length()>0 &&
                    editNim.getText().length()>0 && editJurusan.getText().length()>0 && editSemester.getText().length()>0){
                if (editPassword.getText().toString().equals(editConfirmPass.getText().toString())){
                    register(editEmail.getText().toString(), editName.getText().toString(),
                            editNim.getText().toString(), editPassword.getText().toString(),
                            editJurusan.getText().toString(), editSemester.getText().toString());
                }else{
                    Toast.makeText(getApplicationContext(), "Password dan konfirmasi password tidak sesuai", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan mengisi semua data", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void register(String email, String name, String nim, String password, String jurusan, String semester) {
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()&&task.getResult()!=null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            if (firebaseUser!=null) {
                                UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(name)
                                        .build();
                                firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        reload();
                                    }
                                });
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registrasi Gagal!", Toast.LENGTH_LONG).show();
                            }
                            User user = new User(name, nim, email, jurusan, semester);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "User berhasil terdaftar", Toast.LENGTH_LONG).show();
                                        reload();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Registrasi Gagal!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registrasi Gagal!", Toast.LENGTH_LONG).show();
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