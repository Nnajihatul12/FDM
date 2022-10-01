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

public class ViewDonate2 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button signout;
    TextView mHouseCleaning, mPowerbank, mFoodWater, mInfrastructure, mCash, mElectrical;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdonate2);

        mHouseCleaning = findViewById(R.id.vdrb1);
        mPowerbank = findViewById(R.id.vdrb2);
        mFoodWater = findViewById(R.id.vdrb3);
        mInfrastructure = findViewById(R.id.vdrb4);
        mCash = findViewById(R.id.vdrb5);
        mElectrical = findViewById(R.id.vdrb6);


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
        Intent next = new Intent(ViewDonate2.this, SignInActivity_FV.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewDonate2.this, UpdateDonateForm2.class); // ni untuk pi activity
        startActivity(update);
    }
}
