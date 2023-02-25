package com.example.authenticationmodule.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.authenticationmodule.Checking;
import com.example.authenticationmodule.R;
import com.example.authenticationmodule.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        binding.prograssBar.setVisibility(View.INVISIBLE);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener((View v) -> {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            /* Go to Checking if signUp is successful*/
            if (!email.isEmpty() && !password.isEmpty()) {
                binding.prograssBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, Checking.class));
                    }
                    else { Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show(); }
                    binding.prograssBar.setVisibility(View.INVISIBLE);
                });
            }
            else Toast.makeText(getApplicationContext(), "Empty boxes isn't allowed", Toast.LENGTH_SHORT).show();


        });


    }
}








