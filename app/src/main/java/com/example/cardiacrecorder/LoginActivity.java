package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.*;
import com.example.cardiacrecorder.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;
    private String email,password;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("Please wait");

        binding.signupid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                validdata();
            }
        });

    }

    private void validdata() {
        email = binding.emailid.getText().toString().trim();
        password = binding.passwordid.getText().toString().trim();

        if(TextUtils.isEmpty(password))
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

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,Home.class);
                    startActivity(intent);
                }
                else
                {
                    Exception e = task.getException();
                    if(e != null){
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
                        return;
                    }
//                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}