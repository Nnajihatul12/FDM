package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO7 extends AppCompatActivity {
    Button form7;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo7);

        form7 = findViewById(R.id.form7);

        form7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm7();
            }
        });

    }

    private void onClickedForm7() {
        Intent i = new Intent(ViewDetailNGO7.this, UserForm3.class);
        startActivity(i);
    }
}
