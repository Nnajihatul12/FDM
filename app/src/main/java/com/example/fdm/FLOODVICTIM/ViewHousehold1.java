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

public class ViewHousehold1 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button nextview;
    TextView mEdituBaby1ViewH, mEdituChildren1ViewH, mEdituTeenager1ViewH, mEdituAdult1ViewH, mEdituElderly1ViewH, mEdituDisable1ViewH;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhousehold1);

        mEdituBaby1ViewH = findViewById(R.id.editubaby1ViewHousehold1);
        mEdituChildren1ViewH = findViewById(R.id.edituchildren1ViewHousehold1);
        mEdituTeenager1ViewH = findViewById(R.id.edituteenager1ViewHousehold1);
        mEdituAdult1ViewH = findViewById(R.id.edituadult1ViewHousehold1);
        mEdituElderly1ViewH = findViewById(R.id.edituelderly1ViewHousehold1);
        mEdituDisable1ViewH = findViewById(R.id.editudisable1ViewHousehold1);


        update = findViewById(R.id.vhupdate1);
        nextview = findViewById(R.id.vhnext1);

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
        Intent next = new Intent(ViewHousehold1.this, ViewDonate1.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewHousehold1.this, UpdateHouseholdForm1.class); // ni untuk pi activity
        startActivity(update);
    }

        private void callBackFromDatabase () {


            userID = auth.getCurrentUser().getUid();

            DocumentReference documentReference = fstore.collection("householdDetail").document(userID);
            documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    mEdituBaby1ViewH.setText(documentSnapshot.getString("NoOfBaby"));
                    mEdituChildren1ViewH.setText(documentSnapshot.getString("NoOfChildren"));
                    mEdituTeenager1ViewH.setText(documentSnapshot.getString("NoOfTeenager"));
                    mEdituAdult1ViewH.setText(documentSnapshot.getString("NoOfAdult"));
                    mEdituElderly1ViewH.setText(documentSnapshot.getString("NoOfElderly"));
                    mEdituDisable1ViewH.setText(documentSnapshot.getString("NoOfDisable"));
                }
            });
        }
    }

