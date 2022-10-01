package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.Model.FloodVictimEntity;
import com.example.fdm.Model.FormGroceryAidsEntity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Requestform4 extends AppCompatActivity{
    CheckBox mHygieneChkbx, mCleaningChkbx, mFoodChkbx,mMedicChkbx,mClothesChkbx;
    String mHygieneString, mCleaningString, mFoodString,mMedicString,mClothesString;
    Button bnext;
    String userID;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString, mBabyString, mChildrenString, mTeenagerString, mAdultString, mElderlyString, mDisableString;
    FloodVictimEntity fvEntity;

    FormGroceryAidsEntity formGroceryAidsEntity;


    FirebaseFirestore fstore;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestform4);

        mHygieneChkbx = findViewById(R.id.hygieneChkbx);
        mCleaningChkbx = findViewById(R.id.cleaningChkbx);
        mFoodChkbx = findViewById(R.id.foodChkbx);
        mMedicChkbx = findViewById(R.id.medicChkbx);
        mClothesChkbx = findViewById(R.id.clothesChkbx);
        bnext = findViewById(R.id.submitdrd);

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
        fvEntity =  (FloodVictimEntity) intent.getSerializableExtra(getString(R.string.key_flood_victim_form4));
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
        switch(view.getId()) {
            case R.id.hygieneChkbx:
                if (checked){
                    mHygieneString = "Hygiene Kits";
                }

                break;
            case R.id.cleaningChkbx:
                if (checked){
                    mCleaningString = "Cleaning Appliances";
                }
                break;
            case R.id.foodChkbx:
                if (checked){
                    mFoodString = "Food";
                }
                break;
            case R.id.medicChkbx:
                if (checked){
                    mMedicString = "Medicine";

                }
                break;
            case R.id.clothesChkbx:
                if (checked){
                    mClothesString = "Clothes and Blankets";

                }
                break;

            default:
                break;
            // TODO: Veggie sandwich
        }
    }
    //Store userdetail in firebase.
    private void addDataToFirestore() {

        formGroceryAidsEntity = new FormGroceryAidsEntity();

        formGroceryAidsEntity.sethygienes(mHygieneString);
        formGroceryAidsEntity.setcleaningAppliances(mCleaningString);
        formGroceryAidsEntity.setfood(mFoodString);
        formGroceryAidsEntity.setmedic(mMedicString);
        formGroceryAidsEntity.setclothes(mClothesString);

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

        Intent intent = new Intent(Requestform4.this, ViewForm4.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form4),fvEntity);
        b.putSerializable(getString(R.string.key_flood_victim_form4_Grocery_Aids),formGroceryAidsEntity);

        intent.putExtras(b);
        startActivity(intent);

        userID = auth.getCurrentUser().getUid();
        DocumentReference documentReference = fstore.collection("floodVictimDetail(GroceryAids)").document(userID);
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

        FV.put("HygieneKits",mHygieneString);
        FV.put("CleaningAppliances",mCleaningString);
        FV.put("Food",mFoodString);
        FV.put("Medicine",mMedicString);
        FV.put("Clothes",mClothesString);

        documentReference.set(FV).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "User profile is created for "+ userID );
                        Toast.makeText(Requestform4.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"Error adding user", e);
                        Toast.makeText(Requestform4.this, "Adding failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

