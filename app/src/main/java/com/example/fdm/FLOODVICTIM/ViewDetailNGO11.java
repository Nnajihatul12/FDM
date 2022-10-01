package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO11 extends AppCompatActivity {
    Button form11;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo11);

        form11 = findViewById(R.id.form11);

        form11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm11();
            }
        });

    }

    private void onClickedForm11() {
        Intent i = new Intent(ViewDetailNGO11.this, UserForm3.class);
        startActivity(i);
    }
}
