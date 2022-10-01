package com.example.fdm.NGO;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.FLOODVICTIM.SignInActivity_FV;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity_NGO extends AppCompatActivity {

    EditText textemail3;
    EditText textpassword3;
    Button btnsigninngo;

    private String email;
    private String password;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_ngo);

        textemail3 = findViewById(R.id.txtemail3);
        textpassword3 = findViewById(R.id.txtpassword3);
        btnsigninngo = findViewById(R.id.btnsigninngo);

        auth = FirebaseAuth.getInstance();

        btnsigninngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignIn();
            }
        });
    }

    private void onClickedSignIn(){
        email = textemail3.getText().toString();
        password = textpassword3.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(SignInActivity_NGO.this,"Enter the email",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(SignInActivity_NGO.this, "Enter the password", Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textemail3.setError("Please provide valid email!");
            textemail3.requestFocus();
        }
        else if(textpassword3.length() < 6 || textpassword3.length() >=30){
            Toast.makeText(SignInActivity_NGO.this,"Password must contain 6 character at least", Toast.LENGTH_SHORT).show();
        }
        else
        {
            NGO(email, password);
        }
    }
    private void NGO(String email, String password) {

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(SignInActivity_NGO.this, "Login successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignInActivity_NGO.this, HomeActivity_NGO.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"Error adding user", e);
                        Toast.makeText(SignInActivity_NGO.this, "Login failed, Try again!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    }


