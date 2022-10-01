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

public class UpdateDonateForm4  extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button signout;
    TextView mhygieneChkbx, mcleaningChkbx, mfoodChkbx, mmedicChkbx, mclothesChkbx;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedonateform4);

        mhygieneChkbx = findViewById(R.id.vdrd1);
        mcleaningChkbx = findViewById(R.id.vdrd2);
        mfoodChkbx = findViewById(R.id.vdrd3);
        mmedicChkbx = findViewById(R.id.vdrd4);
        mclothesChkbx = findViewById(R.id.vdrd5);


        update = findViewById(R.id.updatevdrd);
        signout = findViewById(R.id.signoutvdrd);

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
        Intent next = new Intent(UpdateDonateForm4.this, SignInActivity_FV.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateDonateForm4.this, UpdateDonateForm4.class); // ni untuk pi activity
        startActivity(update);
    }
}
