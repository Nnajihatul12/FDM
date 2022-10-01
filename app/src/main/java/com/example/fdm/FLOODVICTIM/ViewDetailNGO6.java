package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO6 extends AppCompatActivity {
    Button form6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo6);

        form6 = findViewById(R.id.form6);

        form6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm6();
            }
        });

    }

    private void onClickedForm6() {
        Intent i = new Intent(ViewDetailNGO6.this, UserForm2.class);
        startActivity(i);
    }
}
