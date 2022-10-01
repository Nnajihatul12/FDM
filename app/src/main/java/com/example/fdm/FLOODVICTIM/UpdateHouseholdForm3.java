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

public class UpdateHouseholdForm3 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    EditText mBaby3, mChildren3, mTeenager3, mAdult3, mElderly3, mDisable3;


    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehouseholdform3);

        mBaby3 = findViewById(R.id.editubaby3);
        mChildren3 = findViewById(R.id.edituchildren3);
        mTeenager3 = findViewById(R.id.edituteenager3);
        mAdult3 = findViewById(R.id.edituadult3);
        mElderly3 = findViewById(R.id.edituelderly3);
        mDisable3 = findViewById(R.id.editudisable3);

        update = findViewById(R.id.updatehousehold3);
        next = findViewById(R.id.nexthousehold3);

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
        Intent next = new Intent(UpdateHouseholdForm3.this, ViewDonate3.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateHouseholdForm3.this, UpdateHouseholdForm3.class); // ni untuk pi activity
        startActivity(update);
    }
}
