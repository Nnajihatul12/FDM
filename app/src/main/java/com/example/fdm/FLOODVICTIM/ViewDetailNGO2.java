package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO2 extends AppCompatActivity {
    Button form2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo2);

        form2 = findViewById(R.id.form2);

        form2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm2();
            }
        });

    }

    private void onClickedForm2() {
        Intent i = new Intent(ViewDetailNGO2.this, UserForm2.class);
        startActivity(i);
    }
}
