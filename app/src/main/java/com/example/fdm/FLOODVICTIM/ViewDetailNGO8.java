package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO8 extends AppCompatActivity {
    Button form8;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo8);

        form8 = findViewById(R.id.form8);

        form8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm8();
            }
        });

    }

    private void onClickedForm8() {
        Intent i = new Intent(ViewDetailNGO8.this, UserForm4.class);
        startActivity(i);
    }
}
