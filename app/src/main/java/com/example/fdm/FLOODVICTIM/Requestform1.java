package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.Model.FloodVictimEntity;
import com.example.fdm.Model.FormHealthAidsEntity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Requestform1 extends AppCompatActivity {
    CheckBox mDryFoodChkbx, mHygieneKitsChkbx, mPortableWaterChkbx, mMedicinesChkbx, mAmbulanChkbx, mBlanketChkbx;
    String mDryFoodString, mHygieneKitsString, mPortableWaterString, mMedicinesString, mAmbulanString, mBlanketString;
    Button bnext;
    String userID;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString, mBabyString, mChildrenString, mTeenagerString, mAdultString, mElderlyString, mDisableString;
    FloodVictimEntity fvEntity;
    FormHealthAidsEntity formHealthAidsEntity;

    FirebaseFirestore fstore;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestform1);

//        Intent intent = getIntent();

        //Bundle bundle = getIntent().getExtras();

//        Log.i("NoOfBaby",intent.getStringExtra("NoOfBaby"));
//        Log.i("NoOfChildren",intent.getStringExtra("NoOfChildren"));
//        Log.i("NoOfTeenager",intent.getStringExtra("NoOfTeenager"));
//        Log.i("NoOfAdult",intent.getStringExtra("NoOfAdult"));
//        Log.i("NoOfElderly",intent.getStringExtra("NoOfElderly"));
//        Log.i("NoOfDisable",intent.getStringExtra("NoOfDisable"));

        fstore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        mDryFoodChkbx = findViewById(R.id.dryFoodChkbx);
        mHygieneKitsChkbx = findViewById(R.id.hygienceKitChkbx);
        mPortableWaterChkbx = findViewById(R.id.portableWaterChkbx);
        mMedicinesChkbx = findViewById(R.id.medicineChkbx);
        mAmbulanChkbx = findViewById(R.id.ambulanChkbx);
        mBlanketChkbx = findViewById(R.id.blanketChkbx);
        bnext = findViewById(R.id.submitdra);

        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToFirestore();
            }
        });

        getDataFromHouseHoldForm();


    }

    private void getDataFromHouseHoldForm(){
        Intent intent = this.getIntent();
        fvEntity =  (FloodVictimEntity) intent.getSerializableExtra(getString(R.string.key_flood_victim_form1));
        mPhoneString = fvEntity.phoneNo;
        mGenderString = fvEntity.gender;
        mAgeString = fvEntity.age;
        mOccupationString = fvEntity.occupation;
        mIncomeString = fvEntity.income;
        mAddress1String = fvEntity.address1;
        mAddress2String = fvEntity.address2;
        mPostcodeString = fvEntity.postcode;
        mBabyString = fvEntity.noOfbaby;
        mChildrenString = fvEntity.noOfchildren;
        mTeenagerString = fvEntity.noOfteenager;
        mAdultString = fvEntity.noOfadult;
        mElderlyString = fvEntity.noOfelderly;
        mDisableString = fvEntity.noOfdisable;
    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.dryFoodChkbx:
                if (checked) {
                    mDryFoodString = "Dry Food";
                }

                break;
            case R.id.hygienceKitChkbx:
                if (checked) {
                    mHygieneKitsString = "Hygiene Kits";
                }
                break;
            case R.id.portableWaterChkbx:
                if (checked) {
                    mPortableWaterString = "Portable Water";
                }
                break;
            case R.id.medicineChkbx:
                if (checked) {
                    mMedicinesString = "Medicines and First Aid Kit";

                }
                break;
            case R.id.ambulanChkbx:
                if (checked) {
                    mAmbulanString = "Ambulan Services";

                }
                break;
            case R.id.blanketChkbx:
                if (checked) {
                    mBlanketString = "Blankets";
                }
                break;

            default:
                break;
        }
    }

    //Store userdetail in firebase.
    private void addDataToFirestore() {

        formHealthAidsEntity = new FormHealthAidsEntity();



//        String mDryFoodString = mDryFoodChkbx.getText().toString();
//        String mHygieneKitsString = mHygieneKitsChkbx.getText().toString();
//        String mPortableWaterString = mPortableWaterChkbx.getText().toString();
//        String mMedicinesString = mMedicinesChkbx.getText().toString();
//        String mAmbulanString = mAmbulanChkbx.getText().toString();
//        String mBlanketString = mBlanketChkbx.getText().toString();

        formHealthAidsEntity.setDryfood(mDryFoodString);
        formHealthAidsEntity.setHygienekits(mHygieneKitsString);
        formHealthAidsEntity.setPortablewater(mPortableWaterString);
        formHealthAidsEntity.setMedicines(mMedicinesString);
        formHealthAidsEntity.setAmbulances(mAmbulanString);
        formHealthAidsEntity.setBlankets(mBlanketString);

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



//        Intent intent1 = getIntent();
//        String mPhoneString = intent1.getStringExtra("Phone");
//        String mAgeString = intent1.getStringExtra("Age");
//        String mOccupationString = intent1.getStringExtra("Occupation");
//        String mIncomeString = intent1.getStringExtra("Income");
//        String mAddress1String = intent1.getStringExtra("Address1");
//        String mAddress2String = intent1.getStringExtra("Address2");
//        String mGenderString = intent1.getStringExtra("Gender");
//        String mPostcodeString = intent1.getStringExtra("Postcode");
//
//        String mBabyString = intent1.getStringExtra("NoOfBaby");
//        String mChildrenString = intent1.getStringExtra("NoOfChildren");
//        String mTeenagerString = intent1.getStringExtra("NoOfTeenager");
//        String mAdultString = intent1.getStringExtra("NoOfAdult");
//        String mElderlyString = intent1.getStringExtra("NoOfElderly");
//        String mDisableString = intent1.getStringExtra("NoOfDisable");

        Intent intent = new Intent(Requestform1.this, ViewForm1.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form1),fvEntity);
        b.putSerializable(getString(R.string.key_flood_victim_form1_Healths_Aids),formHealthAidsEntity);

//        intent.putExtra("Phone", mPhoneString);
//        intent.putExtra("Age", mAgeString);
//        intent.putExtra("Occupation", mOccupationString);
//        intent.putExtra("Income", mIncomeString);
//        intent.putExtra("Address1", mAddress1String);
//        intent.putExtra("Address2", mAddress2String);
//        intent.putExtra("Gender", mGenderString);
//        intent.putExtra("Postcode", mPostcodeString);
//
//        intent.putExtra("NoOfBaby", mBabyString);
//        intent.putExtra("NoOfChildren", mChildrenString);
//        intent.putExtra("NoOfTeenager", mTeenagerString);
//        intent.putExtra("NoOfAdult", mAdultString);
//        intent.putExtra("NoOfElderly", mElderlyString);
//        intent.putExtra("NoOfDisable", mDisableString);
//
//        intent.putExtra("DryFood", mDryFoodString);
//        intent.putExtra("HygieneKits", mHygieneKitsString);
//        intent.putExtra("PortableWater", mPortableWaterString);
//        intent.putExtra("Medicines", mMedicinesString);
//        intent.putExtra("AmbulanceServices", mAmbulanString);
//        intent.putExtra("Blankets", mBlanketString);
        intent.putExtras(b);
        startActivity(intent);


//        Log.i("DryFood", intent.getStringExtra("DryFood"));
//        Log.i("HygieneKits", intent.getStringExtra("HygieneKits"));
//        Log.i("PortableWater", intent.getStringExtra("PortableWater"));
//        Log.i("Medicines", intent.getStringExtra("Medicines"));
//        Log.i("AmbulanceServices", intent.getStringExtra("AmbulanceServices"));
//        Log.i("Blankets", intent.getStringExtra("Blankets"));


        userID = auth.getCurrentUser().getUid();
        DocumentReference documentReference = fstore.collection("floodVictimDetail(HealthAids)").document(userID);
        Map<String,Object> FV = new HashMap<>();
        FV.put("Phone",mPhoneString);
        FV.put("Age",mAgeString);
        FV.put("Occupation",mOccupationString);
        FV.put("Income",mIncomeString);
        FV.put("Address1",mAddress1String);
        FV.put("Address2",mAddress2String);
        FV.put("Gender",mGenderString);
        FV.put("Postcode",mPostcodeString);

        FV.put("NoOfBaby",mBabyString);
        FV.put("NoOfChildren",mChildrenString);
        FV.put("NoOfTeenager",mTeenagerString);
        FV.put("NoOfAdult",mAdultString);
        FV.put("NoOfElderly",mElderlyString);
        FV.put("NoOfDisable",mDisableString);

        FV.put("DryFood",mDryFoodString);
        FV.put("HygieneKits",mHygieneKitsString);
        FV.put("PortableWater",mPortableWaterString);
        FV.put("Medicines",mMedicinesString);
        FV.put("AmbulanceServices",mAmbulanString);
        FV.put("Blankets",mBlanketString);

        documentReference.set(FV).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "User profile is created for "+ userID );
                        Toast.makeText(Requestform1.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"Error adding user", e);
                        Toast.makeText(Requestform1.this, "Adding failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
//        fstore.collection("requestDonationDetail").add(userDetail1).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(Requestform1.this, "Successfully added", Toast.LENGTH_SHORT).show();
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Requestform1.this, "Failed", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }




//        fstore.collection("requestDonationDetail").add(userDetail1).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentReference> task) {
//                Intent i = new Intent(Requestform1.this, ViewForm1.class);
//                startActivity(i);
//            }
//        });
//    }









