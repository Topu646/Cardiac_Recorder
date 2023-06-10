package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.*;
import com.example.cardiacrecorder.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {


    private ActivityLoginBinding binding;
    private String email,password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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


        if(email.equals("a") && password.equals("b"))
        {
            Intent intent = new Intent(LoginActivity.this,Home.class);
            startActivity(intent);
        }
//
//        if((!Patterns.EMAIL_ADDRESS.matcher("a").matches()))
//        {
//            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
//        }
//        else if(TextUtils.isEmpty(password))
//        {
//            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
//        }

    }
}