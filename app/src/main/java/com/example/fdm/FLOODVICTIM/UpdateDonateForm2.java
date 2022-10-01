package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class UpdateDonateForm2 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button signout;
    TextView mhouseCleaningChkbx, mpowerbankChkbx, mfoodWaterChkbx, minfrastructureChkbx, mcashChkbx, melectricalChkbx;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedonateform2);

        mhouseCleaningChkbx = findViewById(R.id.houseCleaningChkbx);
        mpowerbankChkbx = findViewById(R.id.powerbankChkbx);
        mfoodWaterChkbx = findViewById(R.id.foodWaterChkbx);
        minfrastructureChkbx = findViewById(R.id.infrastructureChkbx);
        mcashChkbx = findViewById(R.id.cashChkbx);
        melectricalChkbx = findViewById(R.id.electricalChkbx);


        update = findViewById(R.id.updatevdrb);
        signout = findViewById(R.id.signoutvdrb);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        //callBackFromDatabase();
        //   update.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //   public void onClickUpdate(View vv) { onClickUpdate(); }
        //});

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickUpdate();
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSignOut();
            }

        });
    }

    private void onClickSignOut() {
        Intent next = new Intent(UpdateDonateForm2.this, SignInActivity_FV.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateDonateForm2.this, UpdateDonateForm2.class); // ni untuk pi activity
        startActivity(update);
    }
}
