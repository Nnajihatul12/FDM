package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO9 extends AppCompatActivity {
    Button form9;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo9);

        form9 = findViewById(R.id.form9);

        form9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm9();
            }
        });

    }

    private void onClickedForm9() {
        Intent i = new Intent(ViewDetailNGO9.this, UserForm1.class);
        startActivity(i);
    }
}
