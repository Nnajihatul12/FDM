package com.example.fdm.NGO;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fdm.R;

public class HomeActivity_NGO extends AppCompatActivity{

    Button adddonation;
    Button viewfv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ngo);

        adddonation = findViewById(R.id.btnadd);
         viewfv = findViewById(R.id.btnview);

        adddonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedAdd();
            }
        });

        viewfv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {

                onClickedView();
            }
        });

    }

    private void onClickedAdd(){
        Intent i = new Intent(HomeActivity_NGO.this, AddListDonationType_NGO.class);
        startActivity(i);
    }

    private void onClickedView(){
        Intent ii = new Intent(HomeActivity_NGO.this, ViewFloodVictim_NGO.class);
        startActivity(ii);
    }
}