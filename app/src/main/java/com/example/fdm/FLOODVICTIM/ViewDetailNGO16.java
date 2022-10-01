package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO16 extends AppCompatActivity {
    Button form16;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo16);

        form16 = findViewById(R.id.form16);

        form16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm16();
            }
        });

    }

    private void onClickedForm16() {
        Intent i = new Intent(ViewDetailNGO16.this, UserForm4.class);
        startActivity(i);
    }
}
