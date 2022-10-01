package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO12 extends AppCompatActivity {
    Button form12;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo12);

        form12 = findViewById(R.id.form12);

        form12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm12();
            }
        });

    }

    private void onClickedForm12() {
        Intent i = new Intent(ViewDetailNGO12.this, UserForm4.class);
        startActivity(i);
    }
}
