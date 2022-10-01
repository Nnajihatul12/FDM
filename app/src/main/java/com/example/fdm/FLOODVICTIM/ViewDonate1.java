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

public class ViewDonate1 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button signout;
    TextView mDryFood1, mHygieneKit1, mPortableWater1, mMedicines1, mAmbulance1, mBlanket1;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdonate1);

        mDryFood1 = findViewById(R.id.vdra1);
        mHygieneKit1 = findViewById(R.id.vdra2);
        mPortableWater1 = findViewById(R.id.vdra3);
        mMedicines1 = findViewById(R.id.vdra4);
        mAmbulance1 = findViewById(R.id.vdra5);
        mBlanket1 = findViewById(R.id.vdra6);


        update = findViewById(R.id.updatevdra);
        signout = findViewById(R.id.signoutvdra);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        callBackFromDatabase();
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
        Intent next = new Intent(ViewDonate1.this, SignInActivity_FV.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewDonate1.this, UpdateDonateForm1.class); // ni untuk pi activity
        startActivity(update);
    }

    private void callBackFromDatabase () {


        userID = auth.getCurrentUser().getUid();
        DocumentReference documentReferenceFV = fstore.collection("requestDonationDetail").document(userID);
        documentReferenceFV.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                mDryFood1.setText(documentSnapshot.getString("DryFood"));
                mHygieneKit1.setText(documentSnapshot.getString("HygieneKits"));
                mPortableWater1.setText(documentSnapshot.getString("PortableWater"));
                mMedicines1.setText(documentSnapshot.getString("Medicines"));
                mAmbulance1.setText(documentSnapshot.getString("AmbulanceServices"));
                mBlanket1.setText(documentSnapshot.getString("Blankets"));
            }
        });
    }
}


