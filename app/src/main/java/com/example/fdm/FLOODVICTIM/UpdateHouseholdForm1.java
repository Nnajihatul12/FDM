package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.Map;

public class UpdateHouseholdForm1 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    EditText mBaby1, mChildren1, mTeenager1, mAdult1, mElderly1, mDisable1;


    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatehouseholdform1);

        mBaby1 = findViewById(R.id.editubaby1);
        mChildren1 = findViewById(R.id.edituchildren1);
        mTeenager1 = findViewById(R.id.edituteenager1);
        mAdult1 = findViewById(R.id.edituadult1);
        mElderly1 = findViewById(R.id.edituelderly1);
        mDisable1 = findViewById(R.id.editudisable1);

        update = findViewById(R.id.updatehousehold1);
        next = findViewById(R.id.nexthousehold1);

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
        Intent next = new Intent(UpdateHouseholdForm1.this, ViewDonate1.class);
        startActivity(next);
    }

    private void onClickUpdate() {

        String mBaby1String = mBaby1.getText().toString();
        String mChildren1String = mChildren1.getText().toString();
        String mTeenager1String = mTeenager1.getText().toString();
        String mAdult1String = mAdult1.getText().toString();
        String mElderly1String = mElderly1.getText().toString();
        String mDisable1String = mDisable1.getText().toString();

        if (TextUtils.isEmpty(mBaby1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Baby", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mChildren1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Children", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mTeenager1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Teenager", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAdult1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Adult", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mElderly1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Elderly", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mDisable1String)) {
            Toast.makeText(UpdateHouseholdForm1.this, "Please input No. Of Disable", Toast.LENGTH_SHORT).show();
        } else {

            addDataToFirestore();
            Intent update = new Intent(UpdateHouseholdForm1.this, UpdateHouseholdForm1.class); // ni untuk pi activity
            startActivity(update);
        }
    }

    private void addDataToFirestore(){
        Map<String, String> userDetail1 = new HashMap<>();

        String mBaby1String = mBaby1.getText().toString();
        String mChildren1String = mChildren1.getText().toString();
        String mTeenager1String = mTeenager1.getText().toString();
        String mAdult1String = mAdult1.getText().toString();
        String mElderly1String = mElderly1.getText().toString();
        String mDisable1String = mDisable1.getText().toString();


        userDetail1.put("NoOfBaby", mBaby1String);
        userDetail1.put("NoOfChildren", mChildren1String);
        userDetail1.put("NoOfTeenager", mTeenager1String);
        userDetail1.put("NoOfAdult", mAdult1String);
        userDetail1.put("NoOfElderly", mElderly1String);
        userDetail1.put("NoOfDisable", mDisable1String);


        userID = auth.getCurrentUser().getUid();
        fstore.collection("householdDetail").document(userID).set(userDetail1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(UpdateHouseholdForm1.this, "Successfully updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
