package com.example.fdm.FLOODVICTIM;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.HOMEPAGE.HomeActivity;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity_FV extends AppCompatActivity {
    EditText txtfullname, txtemail, txtpassword;
    Button btnsignup;
    FirebaseFirestore fstore;
    String userID;

    private String fullname;
    private String email;
    private String password;

    private FirebaseAuth auth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_fv);

        txtfullname = findViewById(R.id.txt_fullname);
        txtemail = findViewById(R.id.txt_email);
        txtpassword = findViewById(R.id.txt_password);
        btnsignup = findViewById(R.id.btn_signup);


        auth = FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();

        //if(auth.getCurrentUser() !=null){
                //startActivity(new Intent(getApplicationContext(), HomeActivity.class));}

        //button signup function
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignUp();
            }
        });
    }

    private void onClickedSignUp() {
        fullname = txtfullname.getText().toString();
        email = txtemail.getText().toString();
        password = txtpassword.getText().toString();

        if (TextUtils.isEmpty(fullname)) {
            Toast.makeText(SignUpActivity_FV.this, "Please enter the username", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(SignUpActivity_FV.this, "Please enter the email", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtemail.setError("Please provide valid email!");
            txtemail.requestFocus();
        } else if (TextUtils.isEmpty(password)){
            Toast.makeText(SignUpActivity_FV.this, "Please enter the password", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6 || password.length() >= 30) {
            Toast.makeText(SignUpActivity_FV.this, "Password must contain 6 character at least", Toast.LENGTH_SHORT).show();
        } else {
            FV(email, password);
        }

    }


private void FV(String email, String password){

    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity_FV.this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {

            if (task.isSuccessful()) {
                //Toast.makeText(SignUpActivity_FV.this, "Registering user successful", Toast.LENGTH_SHORT).show();
                userID = auth.getCurrentUser().getUid();
                DocumentReference documentReference = fstore.collection("FV").document(userID);
                Map<String,Object> FV = new HashMap<>();
                FV.put("Fullname",fullname);
                FV.put("Email",email);
                FV.put("Password",password);
                documentReference.set(FV).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "User profile is created for "+ userID );
                        Toast.makeText(SignUpActivity_FV.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Log.w(TAG,"Error adding user", e);
                                Toast.makeText(SignUpActivity_FV.this, "Registering user failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                startActivity(new Intent(SignUpActivity_FV.this,ViewListNGOActivity1_FV.class));
                finish();
            } else {
                Toast.makeText(SignUpActivity_FV.this,"Registration failed", Toast.LENGTH_SHORT).show();
            }
        }
    })
;}

}
