package com.example.fdm.FLOODVICTIM;


import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class SignInActivity_FV extends AppCompatActivity {

    EditText textemail1, textpassword1;
    Button btnsignin;
    TextView textlink;

    private String email;
    private String password;
    private CheckBox emailCheckBox, passwordCheckbox;


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_fv);

        textemail1 = findViewById(R.id.txt_email1);
        textpassword1 = findViewById(R.id.txt_password1);
        btnsignin = findViewById(R.id.btn_signin);
        textlink = findViewById(R.id.i_link);
        emailCheckBox = findViewById(R.id.saveEmailChkbx);
        passwordCheckbox = findViewById(R.id.savePasswordChkbx);

        auth = FirebaseAuth.getInstance();

        //link ke activity lain guna textview
        textlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                onClickedSignUp();

            }
        });

        //btn sign in function
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignIn();
            }
        });

        emailCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInActivity_FV.this);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString(getString(R.string.pref_email_key),textemail1.getText().toString());
                        editor.commit();


                } else {
                        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInActivity_FV.this);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString(getString(R.string.pref_email_key),"");
                        editor.putString(getString(R.string.pref_password_key),"");

                        editor.commit();
                }
            }
        });

        passwordCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInActivity_FV.this);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString(getString(R.string.pref_password_key),textpassword1.getText().toString());
                        editor.commit();

                } else {
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInActivity_FV.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString(getString(R.string.pref_email_key),"");
                    editor.putString(getString(R.string.pref_password_key),"");

                    editor.commit();
                }
            }
        });

        initParam();
    }

    public void initParam(){
        emailCheckBox.setOnCheckedChangeListener(null);
        passwordCheckbox.setOnCheckedChangeListener(null);



        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String loginId = pref.getString(getString(R.string.pref_email_key),"");
        String password = pref.getString(getString(R.string.pref_password_key),"");
        boolean emailchkbx = pref.getBoolean(getString(R.string.pref_email_checkbox_key),false);
        boolean passwordChkbx = pref.getBoolean(getString(R.string.pref_password_checkbox_key),false);
        if (emailchkbx == true && passwordChkbx == true) {
            textemail1.setText(loginId);
            textpassword1.setText(password);
            emailCheckBox.setChecked(true);
            passwordCheckbox.setChecked(true);
        } else {
            emailCheckBox.setChecked(false);
            passwordCheckbox.setChecked(false);
        }
//        if (emailchkbx == true && passwordChkbx == true){
//            emailCheckBox.setChecked(true);
//            passwordCheckbox.setChecked(true);
//        }
    }


    private void onClickedSignUp() {
        Intent i = new Intent(SignInActivity_FV.this, SignUpActivity_FV.class);
        startActivity(i);
    }

    private void onClickedSignIn() {
        email = textemail1.getText().toString();
        password = textpassword1.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(SignInActivity_FV.this, "Please enter the email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(SignInActivity_FV.this, "Please enter the password", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textemail1.setError("Please provide valid email!");
            textemail1.requestFocus();
        } else if (password.length() < 6 || password.length() >= 30) {
            Toast.makeText(SignInActivity_FV.this, "Password must contain 6 character at least", Toast.LENGTH_SHORT).show();
        }
        else{
            FV(email, password);
        }
    }
    private void FV(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SignInActivity_FV.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(getString(R.string.pref_email_key),textemail1.getText().toString());
                editor.putString(getString(R.string.pref_password_key),textpassword1.getText().toString());
                editor.putBoolean(getString(R.string.pref_email_checkbox_key),emailCheckBox.isChecked());
                editor.putBoolean(getString(R.string.pref_password_checkbox_key),passwordCheckbox.isChecked());
                editor.apply();

                Toast.makeText(SignInActivity_FV.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignInActivity_FV.this, ViewListNGOActivity1_FV.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"Error adding user", e);
                        Toast.makeText(SignInActivity_FV.this, "Login failed, Try again!", Toast.LENGTH_SHORT).show();
                    }
                });
    }





    //public void saveData(){
     //   SharedPreferences settings = getSharedPreferences("UserInfo",0);
       // SharedPreferences.Editor editor = settings.edit();
       // editor.putString("Email", textemail1.getText().toString());
       // editor.apply();
    //}
}
