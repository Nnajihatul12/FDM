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
import com.example.fdm.Model.FormFoodAidsEntity;
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

public class Requestform3 extends AppCompatActivity{
    CheckBox mRiceChkbx, mMilkChkbx, mBiscuitChkbx,mCandleChkbx,mDiaperChkbx;
    String mRiceString, mMilkString, mBiscuitString,mCandleString,mDiaperString;
    Button bnext;
    String userID;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString, mBabyString, mChildrenString, mTeenagerString, mAdultString, mElderlyString, mDisableString;
    FloodVictimEntity fvEntity;

    FormFoodAidsEntity formFoodAidsEntity;


    FirebaseFirestore fstore;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestform3);

        mRiceChkbx = findViewById(R.id.riceChkbx);
        mMilkChkbx = findViewById(R.id.milkChkbx);
        mBiscuitChkbx = findViewById(R.id.biscuitChkbx);
        mCandleChkbx = findViewById(R.id.candleChkbx);
        mDiaperChkbx = findViewById(R.id.diaperChkbx);
        bnext = findViewById(R.id.submitdrc);

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
        fvEntity =  (FloodVictimEntity) intent.getSerializableExtra(getString(R.string.key_flood_victim_form3));
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
            case R.id.riceChkbx:
                if (checked){
                    mRiceString = "Rice";
                }

                break;
            case R.id.milkChkbx:
                if (checked){
                    mMilkString = "Milk Powder";
                }
                break;
            case R.id.biscuitChkbx:
                if (checked){
                    mBiscuitString = "Biscuits";
                }
                break;
            case R.id.candleChkbx:
                if (checked){
                    mCandleString = "Candles and Matches";

                }
                break;
            case R.id.diaperChkbx:
                if (checked){
                    mDiaperString = "Diapers and Pads";

                }
                break;

            default:
                break;
            // TODO: Veggie sandwich
        }
    }
    //Store userdetail in firebase.
    private void addDataToFirestore() {

        formFoodAidsEntity = new FormFoodAidsEntity();

        formFoodAidsEntity.setrice(mRiceString);
        formFoodAidsEntity.setmilk(mMilkString);
        formFoodAidsEntity.setbiscuits(mBiscuitString);
        formFoodAidsEntity.setcandles(mCandleString);
        formFoodAidsEntity.setdiapers(mDiaperString);

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

        Intent intent = new Intent(Requestform3.this, ViewForm3.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form3),fvEntity);
        b.putSerializable(getString(R.string.key_flood_victim_form3_Food_Aids),formFoodAidsEntity);

        intent.putExtras(b);
        startActivity(intent);

        userID = auth.getCurrentUser().getUid();
        DocumentReference documentReference = fstore.collection("floodVictimDetail(FoodAids)").document(userID);
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

        FV.put("Rice",mRiceString);
        FV.put("Milk",mMilkString);
        FV.put("Biscuits",mBiscuitString);
        FV.put("Candles",mCandleString);
        FV.put("Diapers",mDiaperString);

        documentReference.set(FV).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Log.d(TAG, "User profile is created for "+ userID );
                        Toast.makeText(Requestform3.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG,"Error adding user", e);
                        Toast.makeText(Requestform3.this, "Adding failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

