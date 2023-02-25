package com.example.authenticationmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.authenticationmodule.databinding.ActivityCheckingBinding;
import com.example.authenticationmodule.databinding.ActivityMainAppBinding;
import com.example.authenticationmodule.databinding.ActivityMainAppBindingImpl;
import com.google.firebase.auth.FirebaseAuth;

public class MainApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainAppBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main_app);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        binding.SignOut.setOnClickListener(v -> {
            auth.signOut();
            startActivity(new Intent(getApplicationContext(),Checking.class));
        });



    }
}