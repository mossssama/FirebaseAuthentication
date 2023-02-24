package com.example.authenticationmodule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.authenticationmodule.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_register);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        binding.btnRegister.setOnClickListener((View v) ->{
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((@NonNull Task<AuthResult> task) -> {
                            if (task.isSuccessful())  Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                            else                      Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                });
            }
            else  { Toast.makeText(getApplicationContext(), "Empty boxes isn't allowed", Toast.LENGTH_SHORT).show(); }


        });

    }
}