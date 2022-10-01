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

public class UpdateHouseholdForm4 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    EditText mBaby4, mChildren4, mTeenager4, mAdult4, mElderly4, mDisable4;


    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehouseholdform4);

        mBaby4 = findViewById(R.id.editubaby4);
        mChildren4 = findViewById(R.id.edituchildren4);
        mTeenager4 = findViewById(R.id.edituteenager4);
        mAdult4 = findViewById(R.id.edituadult4);
        mElderly4 = findViewById(R.id.edituelderly4);
        mDisable4 = findViewById(R.id.editudisable4);

        update = findViewById(R.id.updatehousehold4);
        next = findViewById(R.id.nexthousehold4);

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
        Intent next = new Intent(UpdateHouseholdForm4.this, ViewDonate4.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateHouseholdForm4.this, UpdateHouseholdForm4.class); // ni untuk pi activity
        startActivity(update);
    }
}
