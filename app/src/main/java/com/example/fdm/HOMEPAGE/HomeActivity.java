package com.example.fdm.HOMEPAGE;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fdm.FLOODVICTIM.SignInActivity_FV;
import com.example.fdm.FLOODVICTIM.SignUpActivity_FV;
import com.example.fdm.NGO.SignInActivity_NGO;
import com.example.fdm.R;

public class HomeActivity extends AppCompatActivity{

    Button btnuser;
    Button btnngo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnuser = findViewById(R.id.btnuser);
        btnngo = findViewById(R.id.btnngo);

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedUser();
            }
        });

        btnngo.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View vv) {

                onClickedNgo();
            }
        });

    }

    private void onClickedUser(){
        Intent i = new Intent(HomeActivity.this, SignInActivity_FV.class);
        startActivity(i);
    }

    private void onClickedNgo(){
        Intent ii = new Intent(HomeActivity.this, SignInActivity_NGO.class);
        startActivity(ii);
    }
}