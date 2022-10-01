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

public class ViewHousehold2 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button nextview;
    TextView mEditubaby1, mEdituchildren1, mEdituteenager1, mEdituadult1, mEdituelderly1, mEditudisable1;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhousehold2);

        mEditubaby1 = findViewById(R.id.editubaby2);
        mEdituchildren1 = findViewById(R.id.edituchildren2);
        mEdituteenager1 = findViewById(R.id.edituteenager2);
        mEdituadult1 = findViewById(R.id.edituadult2);
        mEdituelderly1 = findViewById(R.id.edituelderly2);
        mEditudisable1 = findViewById(R.id.editudisable2);


        update = findViewById(R.id.vhupdate2);
        nextview = findViewById(R.id.vhnext2);

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
        nextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }

        });
    }

    private void onClickNext() {
        Intent next = new Intent(ViewHousehold2.this, ViewDonate2.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewHousehold2.this, UpdateHouseholdForm2.class); // ni untuk pi activity
        startActivity(update);
    }
}
