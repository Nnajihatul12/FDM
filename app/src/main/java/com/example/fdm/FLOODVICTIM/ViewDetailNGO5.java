package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.NGO.AddListDonationType_NGO;
import com.example.fdm.NGO.HomeActivity_NGO;
import com.example.fdm.R;

public class ViewDetailNGO5 extends AppCompatActivity {
    Button form5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetailngo5);

        form5 = findViewById(R.id.form5);

        form5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickedForm5();
            }
        });

    }

    private void onClickedForm5() {
        Intent i = new Intent(ViewDetailNGO5.this, UserForm1.class);
        startActivity(i);
    }
}
