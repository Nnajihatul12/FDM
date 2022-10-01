package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO1 extends AppCompatActivity {
    Button form1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo1);

        form1 = findViewById(R.id.form1);

        form1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm1();
            }
        });

    }

    private void onClickedForm1() {
        Intent i = new Intent(ViewDetailNGO1.this, UserForm1.class);
        startActivity(i);
    }
}
