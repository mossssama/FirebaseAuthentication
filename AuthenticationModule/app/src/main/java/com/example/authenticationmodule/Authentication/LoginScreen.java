package com.example.authenticationmodule.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.authenticationmodule.MainApp;
import com.example.authenticationmodule.R;
import com.example.authenticationmodule.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreen extends AppCompatActivity {

    FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.btnLogin.setOnClickListener((View v)-> {
            String email = binding.etEmailLogin.getText().toString();
            String password = binding.etPasswordLogin.getText().toString();

            /* Go to MainApp if logIn is successful */
            if(!email.isEmpty() && !password.isEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                    if (task.isSuccessful()) verifyEmail();
                    else                     Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                });
            }
            else  { Toast.makeText(getApplicationContext(), "Empty boxes isn't allowed", Toast.LENGTH_SHORT).show(); }
        });

        binding.btnSignInFirst.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),SignUpScreen.class)));
        
    }

    private void verifyEmail(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user.isEmailVerified())  {
            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MainApp.class));
        }
        else                        Toast.makeText(getApplicationContext(), "Please Verify Email first", Toast.LENGTH_SHORT).show();
    }
}