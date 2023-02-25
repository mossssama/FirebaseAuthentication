package com.example.authenticationmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.authenticationmodule.Authentication.LoginScreen;
import com.example.authenticationmodule.databinding.ActivityCheckingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Checking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCheckingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_checking);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        /* Direct to app if loggedIn or Direct to LoginScreen if not loggedIn */
        new Handler().postDelayed(() -> {
            if (user != null){
                Toast.makeText(getApplicationContext(), "User is LoggedIn", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainApp.class));
            }
            else{
                Toast.makeText(getApplicationContext(), "User isn't LoggedIn", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LoginScreen.class));
            }
            finish();
        },3000);

//        binding.btnLoginIn.setOnClickListener((View v)-> startActivity(new Intent(getApplicationContext(), LoginScreen.class)));

    }



}

