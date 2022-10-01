package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO14 extends AppCompatActivity {
    Button form14;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo14);

        form14 = findViewById(R.id.form14);

        form14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm14();
            }
        });

    }

    private void onClickedForm14() {
        Intent i = new Intent(ViewDetailNGO14.this, UserForm2.class);
        startActivity(i);
    }
}
