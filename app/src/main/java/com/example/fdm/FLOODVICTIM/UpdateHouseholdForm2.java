package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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

public class UpdateHouseholdForm2 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    EditText mBaby2, mChildren2, mTeenager2, mAdult2, mElderly2, mDisable2;


    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehouseholdform2);

        mBaby2 = findViewById(R.id.editubaby2);
        mChildren2 = findViewById(R.id.edituchildren2);
        mTeenager2 = findViewById(R.id.edituteenager2);
        mAdult2 = findViewById(R.id.edituadult2);
        mElderly2 = findViewById(R.id.edituelderly2);
        mDisable2 = findViewById(R.id.editudisable2);

        update = findViewById(R.id.updatehousehold2);
        next = findViewById(R.id.nexthousehold2);

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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }

        });
    }

    private void onClickNext() {
        Intent next = new Intent(UpdateHouseholdForm2.this, ViewDonate2.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateHouseholdForm2.this, UpdateHouseholdForm2.class); // ni untuk pi activity
        startActivity(update);
    }
}
