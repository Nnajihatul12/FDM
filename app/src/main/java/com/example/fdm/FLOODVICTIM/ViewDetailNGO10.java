package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO10 extends AppCompatActivity {
    Button form10;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo10);

        form10 = findViewById(R.id.form10);

        form10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm10();
            }
        });

    }

    private void onClickedForm10() {
        Intent i = new Intent(ViewDetailNGO10.this, UserForm2.class);
        startActivity(i);
    }
}
