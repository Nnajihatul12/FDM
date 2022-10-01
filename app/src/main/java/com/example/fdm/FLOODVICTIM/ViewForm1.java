package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class ViewForm1 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button nextview;
    TextView mFullname, mPhone, mAge, mOccupation, mIncome, mAddress1, mAddress2, mPostcode;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewform1);

        mFullname = findViewById(R.id.fullnameViewForm1);
        mPhone = findViewById(R.id.edituphone1ViewForm1);
        mAge = findViewById(R.id.edituage1ViewForm1);
        mOccupation = findViewById(R.id.edituoccupation1ViewForm1);
        mIncome = findViewById(R.id.edituincome1ViewForm1);
        mAddress1 = findViewById(R.id.edituadressa1ViewForm1);
        mAddress2 = findViewById(R.id.edituadressb1ViewForm1);
        mPostcode = findViewById(R.id.postcode1ViewForm1);

        update = findViewById(R.id.update1);
        nextview = findViewById(R.id.next1);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        callBackFromDatabase();

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
        Intent next = new Intent(ViewForm1.this, ViewHousehold1.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewForm1.this, UpdateUserForm1.class); // ni untuk pi activity
        startActivity(update);

    }
        private void callBackFromDatabase () {


            userID = auth.getCurrentUser().getUid();
            DocumentReference documentReferenceFV = fstore.collection("FV").document(userID);
            documentReferenceFV.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    mFullname.setText(documentSnapshot.getString("Fullname"));
                }
            });


            DocumentReference documentReferenceFVDetail = fstore.collection("floodVictimDetail(HealthAids)").document(userID);
            documentReferenceFVDetail.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    mPhone.setText(documentSnapshot.getString("Phone"));
                    mAge.setText(documentSnapshot.getString("Age"));
                    mOccupation.setText(documentSnapshot.getString("Occupation"));
                    mIncome.setText(documentSnapshot.getString("Income"));
                    mAddress1.setText(documentSnapshot.getString("Address1"));
                    mAddress2.setText(documentSnapshot.getString("Address2"));
                    mPostcode.setText(documentSnapshot.getString("Postcode"));
                }
            });
        }
    }











