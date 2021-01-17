package com.example.rmltest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rmltest.R;
import com.example.rmltest.databinding.ActivityLoginBinding;
import com.example.rmltest.shared_preference.AppPrefsManager;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    Context mContext;
    AppPrefsManager appPrefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mContext=this;
        appPrefsManager = new AppPrefsManager(mContext,"zunayed","123456");

        if (appPrefsManager.isLogin()){
            startActivity(new Intent(this, MainActivity.class));
        }

        binding.layoutSignUpOption.setOnClickListener(view -> {
            if (binding.editTextEmail.getText().toString().isEmpty()){
                Toast.makeText(mContext,"Please enter username",Toast.LENGTH_SHORT).show();
                return;
            }if (binding.editTextPassword.getText().toString().isEmpty()){
                Toast.makeText(mContext,"Please enter password",Toast.LENGTH_SHORT).show();
                return;
            }if (!binding.editTextPassword.getText().toString().equals(appPrefsManager.getPassword()) ||
                !binding.editTextEmail.getText().toString().equals(appPrefsManager.getUsername())){
                Toast.makeText(mContext,"Please check credentials",Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(this, MainActivity.class));
            appPrefsManager.setIsLogin(true);
            finish();
        });
    }
}