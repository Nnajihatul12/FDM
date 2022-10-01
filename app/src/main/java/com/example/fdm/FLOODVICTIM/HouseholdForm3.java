package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.Model.FloodVictimEntity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HouseholdForm3 extends AppCompatActivity {

    EditText mEditubaby3, mEdituchildren3, mEdituteenager3, mEdituadult3, mEdituelderly3, mEditudisable3;
    Button btnNext;
    String userID;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString;

//    FirebaseFirestore fstore;

    FloodVictimEntity fvEntity;

//    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household3);

        mEditubaby3 = findViewById(R.id.editubaby3);
        mEdituchildren3 = findViewById(R.id.edituchildren3);
        mEdituteenager3 = findViewById(R.id.edituteenager3);
        mEdituadult3 = findViewById(R.id.edituadult3);
        mEdituelderly3 = findViewById(R.id.edituelderly3);
        mEditudisable3 = findViewById(R.id.editudisable3);
        btnNext = findViewById(R.id.hnext3);

//        auth = FirebaseAuth.getInstance();
//        fstore = FirebaseFirestore.getInstance();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isValidate();
                addDataToFirestore();
            }
        });

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        fvEntity =  (FloodVictimEntity) getIntent().getSerializableExtra(getString(R.string.key_flood_victim_form3));


        mPhoneString = fvEntity.phoneNo;
        mGenderString = fvEntity.gender;
        mAgeString = fvEntity.age;
        mOccupationString = fvEntity.occupation;
        mIncomeString = fvEntity.income;
        mAddress1String = fvEntity.address1;
        mAddress2String = fvEntity.address2;
        mPostcodeString = fvEntity.postcode;


    }

    private boolean isValidate() {
        Editable noOfBaby = mEditubaby3.getText();
        Editable noOfChildren = mEdituchildren3.getText();
        Editable noOfTeenager = mEdituteenager3.getText();
        Editable noOfAdult = mEdituadult3.getText();
        Editable noOfElderly = mEdituelderly3.getText();
        Editable noOfDisable = mEditudisable3.getText();

        if (TextUtils.isEmpty(noOfBaby) || noOfBaby.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Baby", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(noOfChildren) || noOfChildren.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Children", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(noOfTeenager) || noOfTeenager.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Teenager", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(noOfAdult) || noOfAdult.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Adult", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(noOfElderly) || noOfElderly.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Elderly", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(noOfDisable) || noOfDisable.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Disable", Toast.LENGTH_SHORT).show();
            return true;
        }


        return false;
    }

    //Store userdetail in firebase.
    private void addDataToFirestore() {
        //Map<String, String> userDetail1 = new HashMap<>();

        String mBabyString = mEditubaby3.getText().toString();
        String mChildrenString = mEdituchildren3.getText().toString();
        String mTeenagerString = mEdituteenager3.getText().toString();
        String mAdultString = mEdituadult3.getText().toString();
        String mElderlyString = mEdituelderly3.getText().toString();
        String mDisableString = mEditudisable3.getText().toString();

        fvEntity.setNoOfbaby(mBabyString);
        fvEntity.setNoOfchildren(mChildrenString);
        fvEntity.setNoOfteenager(mTeenagerString);
        fvEntity.setNoOfadult(mAdultString);
        fvEntity.setNoOfelderly(mElderlyString);
        fvEntity.setNoOfdisable(mDisableString);
        fvEntity.setPhoneNo(mPhoneString);
        fvEntity.setGender(mGenderString);
        fvEntity.setAge(mAgeString);
        fvEntity.setOccupation(mOccupationString);
        fvEntity.setIncome(mIncomeString);
        fvEntity.setAddress1(mAddress1String);
        fvEntity.setAddress2(mAddress2String);
        fvEntity.setPostcode(mPostcodeString);

        Intent intent = new Intent(HouseholdForm3.this, Requestform3.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form3),fvEntity);
        intent.putExtras(b);

        startActivity(intent);
    }

}