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

public class UpdateDonateForm3 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button signout;
    TextView mRiceChkbx, mMilkChkbx, mBiscuitChkbx, mCandleChkbx, mDiaperChkbx;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedonateform3);

        mRiceChkbx = findViewById(R.id.vdrc1);
        mMilkChkbx = findViewById(R.id.vdrc2);
        mBiscuitChkbx = findViewById(R.id.vdrc3);
        mCandleChkbx = findViewById(R.id.vdrc4);
        mDiaperChkbx = findViewById(R.id.vdrc5);


        update = findViewById(R.id.updatevdrc);
        signout = findViewById(R.id.signoutvdrc);

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
        Intent next = new Intent(UpdateDonateForm3.this, SignInActivity_FV.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateDonateForm3.this, UpdateDonateForm3.class); // ni untuk pi activity
        startActivity(update);
    }
}
