package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.Model.FloodVictimEntity;
import com.example.fdm.Model.FormHealthAidsEntity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class HouseholdForm1 extends AppCompatActivity {

    EditText mEditubaby1, mEdituchildren1, mEdituteenager1, mEdituadult1, mEdituelderly1, mEditudisable1;
    Button btnNext;
    String mPhoneString, mGenderString, mAgeString, mOccupationString, mIncomeString, mAddress1String, mAddress2String, mPostcodeString;
    //FirebaseFirestore fstore;
   // String userID;
    
    FloodVictimEntity fvEntity;


    //private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household1);


//        Intent intent2 = getIntent();
//
//        Log.i("Phone",intent2.getStringExtra("Phone"));
//        Log.i("Age",intent2.getStringExtra("Age"));
//        Log.i("Occupation",intent2.getStringExtra("Occupation"));
//        Log.i("Income",intent2.getStringExtra("Income"));
//        Log.i("Address1",intent2.getStringExtra("Address1"));
//        Log.i("Address2",intent2.getStringExtra("Address2"));
//        Log.i("Gender",intent2.getStringExtra("Gender"));
//        Log.i("Postcode",intent2.getStringExtra("Postcode"));
        //String mPhoneString = bundle.getString("Phone");
//
//        if(bundle != null){

//        }
//        String valuePhone = bundle.getString("Phone");
//        String valueAge = bundle.getString("Age");
//        String valueOccupation = bundle.getString("Occupation");
//        String valueIncome = bundle.getString("Income");
//        String valueAddress1 = bundle.getString("Address1");
//        String valueAddress2 = bundle.getString("Address2");
//        String valueGender = bundle.getString("Gender");
//        String valuePostcode = bundle.getString("Postcode");


        mEditubaby1 = findViewById(R.id.editubaby1);
        mEdituchildren1 = findViewById(R.id.edituchildren1);
        mEdituteenager1 = findViewById(R.id.edituteenager1);
        mEdituadult1 = findViewById(R.id.edituadult1);
        mEdituelderly1 = findViewById(R.id.edituelderly1);
        mEditudisable1 = findViewById(R.id.editudisable1);
        btnNext = findViewById(R.id.hnext1);

        //auth = FirebaseAuth.getInstance();
        //fstore = FirebaseFirestore.getInstance();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedNext();
            }
        });


        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        fvEntity =  (FloodVictimEntity) getIntent().getSerializableExtra(getString(R.string.key_flood_victim_form1));


        mPhoneString = fvEntity.phoneNo;
        mGenderString = fvEntity.gender;
        mAgeString = fvEntity.age;
        mOccupationString = fvEntity.occupation;
        mIncomeString = fvEntity.income;
        mAddress1String = fvEntity.address1;
        mAddress2String = fvEntity.address2;
        mPostcodeString = fvEntity.postcode;




    }

    private void onClickedNext() {

        Editable noOfBaby = mEditubaby1.getText();
        Editable noOfChildren = mEdituchildren1.getText();
        Editable noOfTeenager = mEdituteenager1.getText();
        Editable noOfAdult = mEdituadult1.getText();
        Editable noOfElderly = mEdituelderly1.getText();
        Editable noOfDisable = mEditudisable1.getText();

        if (TextUtils.isEmpty(noOfBaby)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Baby", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(noOfChildren)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Children", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(noOfTeenager)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Teenager", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(noOfAdult)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Adult", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(noOfElderly)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Elderly", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(noOfDisable)) {
            Toast.makeText(getApplicationContext(), "Please Input No of Disable", Toast.LENGTH_SHORT).show();
        } else
            addDataToFirestore();
        Intent i = new Intent(HouseholdForm1.this, Requestform1.class);
        startActivity(i);
    }


        //textView.setText(valuePhone);


        //Store userdetail in firebase.
        private void addDataToFirestore () {
        //Map<String, String> userDetail1 = new HashMap<>();
        String mBabyString = mEditubaby1.getText().toString();
        String mChildrenString = mEdituchildren1.getText().toString();
        String mTeenagerString = mEdituteenager1.getText().toString();
        String mAdultString = mEdituadult1.getText().toString();
        String mElderlyString = mEdituelderly1.getText().toString();
        String mDisableString = mEditudisable1.getText().toString();

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

//            Intent intent1 = getIntent();
//            String mPhoneString = intent1.getStringExtra("Phone");
//            String mAgeString = intent1.getStringExtra("Age");
//            String mOccupationString = intent1.getStringExtra("Occupation");
//            String mIncomeString = intent1.getStringExtra("Income");
//            String mAddress1String = intent1.getStringExtra("Address1");
//            String mAddress2String = intent1.getStringExtra("Address2");
//            String mGenderString = intent1.getStringExtra("Gender");
//            String mPostcodeString = intent1.getStringExtra("Postcode");


            Intent intent = new Intent(HouseholdForm1.this, Requestform1.class);
            Bundle b = new Bundle();
            b.putSerializable(getString(R.string.key_flood_victim_form1),fvEntity);
            intent.putExtras(b);
//            intent.putExtra("Phone",mPhoneString);
//            intent.putExtra("Age",mAgeString);
//            intent.putExtra("Occupation",mOccupationString);
//            intent.putExtra("Income",mIncomeString);
//            intent.putExtra("Address1",mAddress1String);
//            intent.putExtra("Address2",mAddress2String);
//            intent.putExtra("Gender",mGenderString);
//            intent.putExtra("Postcode",mPostcodeString);
//
//            intent.putExtra("NoOfBaby",mBabyString);
//            intent.putExtra("NoOfChildren",mChildrenString);
//            intent.putExtra("NoOfTeenager",mTeenagerString);
//            intent.putExtra("NoOfAdult",mAdultString);
//            intent.putExtra("NoOfElderly",mElderlyString);
//            intent.putExtra("NoOfDisable",mDisableString);
            //intent.putExtras(bundle);
            startActivity(intent);

//        Bundle bundle = new Bundle();
//        bundle.putString("Phone", valuePhone);
//        bundle.putString("Age", valueAge);
//        bundle.putString("Occupation", valueOccupation);
//        bundle.putString("Income", valueIncome);
//        bundle.putString("Address1", valueAddress1);
//        bundle.putString("Address2", valueAddress2);
//        bundle.putString("Gender", valueGender);
//        bundle.putString("Postcode", valuePostcode);
//       userDetail1.put("NoOfBaby", mBabyString);
//            userDetail1.put("NoOfChildren", mChildrenString);
//            userDetail1.put("NoOfTeenager", mTeenagerString);
//            userDetail1.put("NoOfAdult", mAdultString);
//            userDetail1.put("NoOfElderly", mElderlyString);
//        bundle.putString("NoOfDisable", mDisableString);


//        userID = auth.getCurrentUser().getUid();
//        fstore.collection("floodVictimDetail").document(userID).set(userDetail1).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(HouseholdForm1.this, "Successfully added", Toast.LENGTH_SHORT).show();
//            }
//        });


//        fstore.collection("householdDetail").add(userDetail1).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentReference> task) {
//                Intent i = new Intent(HouseholdForm1.this,Requestform1.class);
//                startActivity(i);
//            }
//        });

    }
    }

