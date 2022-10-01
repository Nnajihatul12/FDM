package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO13 extends AppCompatActivity {
    Button form13;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo13);

        form13 = findViewById(R.id.form13);

        form13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm13();
            }
        });

    }

    private void onClickedForm13() {
        Intent i = new Intent(ViewDetailNGO13.this, UserForm1.class);
        startActivity(i);
    }
}
