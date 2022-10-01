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

public class UpdateUserForm4 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    RadioButton mMale, mFemale;
    EditText mName, mPhone, mAge, mOccupation, mIncome, mAddress1, mAddress2;
    Spinner mPostcode;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuserform4);

        mName = findViewById(R.id.name4);
        mPhone = findViewById(R.id.phone4);
        mMale = findViewById(R.id.gendermale4);
        mFemale = findViewById(R.id.genderfemale4);
        mAge = findViewById(R.id.age4);
        mOccupation = findViewById(R.id.occupation4);
        mIncome = findViewById(R.id.income4);
        mAddress1 = findViewById(R.id.addressa4);
        mAddress2 = findViewById(R.id.addressb4);
        mPostcode = findViewById(R.id.postcode1);


        update = findViewById(R.id.updateuser4);
        next = findViewById(R.id.nextuser4);

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
        Intent next = new Intent(UpdateUserForm4.this, ViewHousehold4.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(UpdateUserForm4.this, UpdateUserForm4.class); // ni untuk pi activity
        startActivity(update);
    }
}

