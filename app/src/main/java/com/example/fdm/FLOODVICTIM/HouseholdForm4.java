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

public class HouseholdForm4 extends AppCompatActivity {

    EditText mEditubaby4,mEdituchildren4,mEdituteenager4,mEdituadult4,mEdituelderly4,mEditudisable4;
    Button btnNext;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString;


    FloodVictimEntity fvEntity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household4);

        mEditubaby4 = findViewById(R.id.editubaby4);
        mEdituchildren4 = findViewById(R.id.edituchildren4);
        mEdituteenager4 = findViewById(R.id.edituteenager4);
        mEdituadult4 = findViewById(R.id.edituadult4);
        mEdituelderly4 = findViewById(R.id.edituelderly4);
        mEditudisable4 = findViewById(R.id.editudisable4);
        btnNext = findViewById(R.id.hnext4);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isValidate();
                addDataToFirestore();
            }
        });

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        fvEntity =  (FloodVictimEntity) getIntent().getSerializableExtra(getString(R.string.key_flood_victim_form4));


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
        Editable noOfBaby = mEditubaby4.getText();
        Editable noOfChildren = mEdituchildren4.getText();
        Editable noOfTeenager = mEdituteenager4.getText();
        Editable noOfAdult = mEdituadult4.getText();
        Editable noOfElderly = mEdituelderly4.getText();
        Editable noOfDisable = mEditudisable4.getText();

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
        }else if (TextUtils.isEmpty(noOfDisable) || noOfDisable.equals(0)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Disable", Toast.LENGTH_SHORT).show();
            return true;
        }



        return false;
    }
    //Store userdetail in firebase.
    private void addDataToFirestore() {
       // Map<String,String> userDetail1 = new HashMap<>();

        String mBabyString = mEditubaby4.getText().toString();
        String mChildrenString = mEdituchildren4.getText().toString();
        String mTeenagerString = mEdituteenager4.getText().toString();
        String mAdultString= mEdituadult4.getText().toString();
        String mElderlyString = mEdituelderly4.getText().toString();
        String mDisableString = mEditudisable4.getText().toString();

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

        Intent intent = new Intent(HouseholdForm4.this, Requestform4.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form4),fvEntity);
        intent.putExtras(b);

        startActivity(intent);


    }
}