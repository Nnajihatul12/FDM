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

public class ViewForm4 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button nextview;
    TextView mFullname, mPhone, mAge, mOccupation, mIncome, mAddress1, mAddress2, mPostcode;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewform4);

        mFullname = findViewById(R.id.fullname);
        mPhone = findViewById(R.id.edituphone4);
        mAge = findViewById(R.id.edituage4);
        mOccupation = findViewById(R.id.edituoccupation4);
        mIncome = findViewById(R.id.edituincome4);
        mAddress1 = findViewById(R.id.edituadressa4);
        mAddress2 = findViewById(R.id.edituadressb4);
        mPostcode = findViewById(R.id.postcode1);

        update = findViewById(R.id.update4);
        nextview = findViewById(R.id.unext4);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();


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
        Intent next = new Intent(ViewForm4.this, ViewHousehold3.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewForm4.this, UpdateUserForm4.class); // ni untuk pi activity
        startActivity(update);
    }
}