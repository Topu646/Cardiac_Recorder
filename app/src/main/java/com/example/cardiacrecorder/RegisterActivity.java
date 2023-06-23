package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cardiacrecorder.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    private ProgressDialog progressDialog;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();
//        String userid = FirebaseAuth.getInstance().getUid();

        progressBar = findViewById(R.id.progressid);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("Please wait");

        binding.backid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

            }
        });

        binding.registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                validdata();
            }
        });
    }

    String name, email, password;
    private void validdata() {
        name = binding.namneid.getText().toString().trim();
        email = binding.emailid.getText().toString().trim();
        password = binding.passwordid.getText().toString().trim();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Enter your Name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
        }
        else  if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
        }
        else if(password.length() < 6)
        {
            Toast.makeText(getApplicationContext(),"Password must be at least of 6 characters",Toast.LENGTH_SHORT).show();
        }
        String userid = FirebaseAuth.getInstance().getUid();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Register is successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,Home.class);
                        intent.putExtra("userId",userid);
                        startActivity(intent);
                    }
                    else
                    {
                        if(task.getException() instanceof FirebaseAuthUserCollisionException)
                        {
                            Toast.makeText(getApplicationContext(),"User already registered",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error: "+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }
