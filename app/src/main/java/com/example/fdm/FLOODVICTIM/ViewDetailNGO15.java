package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO15 extends AppCompatActivity {
    Button form15;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo15);

        form15 = findViewById(R.id.form15);

        form15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm15();
            }
        });

    }

    private void onClickedForm15() {
        Intent i = new Intent(ViewDetailNGO15.this, UserForm3.class);
        startActivity(i);
    }
}
