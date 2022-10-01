package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO3 extends AppCompatActivity {
    Button form3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo3);

        form3 = findViewById(R.id.form3);

        form3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm3();
            }
        });

    }

    private void onClickedForm3() {
        Intent i = new Intent(ViewDetailNGO3.this, UserForm3.class);
        startActivity(i);
    }
}
