package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

import java.util.HashMap;
import java.util.Map;

public class UpdateUserForm1 extends AppCompatActivity {

    RadioGroup radiogroup;
    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button next;
    RadioButton mMale, mFemale;
    EditText mName, mPhone, mAge, mOccupation, mIncome, mAddress1, mAddress2;
    Spinner spinnerPostCode;

    private String gender;
    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuserform1);

        mName = findViewById(R.id.name1);
        mPhone = findViewById(R.id.phone1);
        mMale = findViewById(R.id.gendermale1);
        mFemale = findViewById(R.id.genderfemale1);
        mAge = findViewById(R.id.age1);
        mOccupation = findViewById(R.id.occupation1);
        mIncome = findViewById(R.id.income1);
        mAddress1 = findViewById(R.id.addressa1);
        mAddress2 = findViewById(R.id.addressb1);
        spinnerPostCode = (Spinner) findViewById(R.id.postcode1);


        update = findViewById(R.id.updateuser1);
        next = findViewById(R.id.nextuser1);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.postcode1, android.R.layout.simple_spinner_dropdown_item);
        spinnerPostCode.setAdapter(adapter);


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
        Intent next = new Intent(UpdateUserForm1.this, ViewHousehold1.class);
        startActivity(next);
    }

    private void onClickUpdate() {

        String mNameString = mName.getText().toString();
        String mPhoneString = mPhone.getText().toString();
        String mAgeString = mAge.getText().toString();
        String mOccupationString = mOccupation.getText().toString();
        String mIncomeString = mIncome.getText().toString();
        String mAddress1String = mAddress1.getText().toString();
        String mAddress2String = mAddress2.getText().toString();

        if (TextUtils.isEmpty(mNameString)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the full name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mPhoneString)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAgeString)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the age", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mOccupationString)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the occupation", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mIncomeString)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the income", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAddress1String)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAddress2String)) {
            Toast.makeText(UpdateUserForm1.this, "Enter the address", Toast.LENGTH_SHORT).show();
        } else {
//        FV(email, fullname);
//        getListItems();
            addDataToFirestore1();
            addDataToFirestore2();
            Intent update = new Intent(UpdateUserForm1.this, UpdateUserForm1.class); // ni untuk pi activity
            startActivity(update);
        }

    }

    //Store userdetail in firebase.

    private void addDataToFirestore1() {

        Map<String, String> userDetail1 = new HashMap<>();

        //NAK MASUKKAN FULLNAME DALAM FV DATABASE
        String mNameString = mName.getText().toString();
        userDetail1.put("Fullname", mNameString);
        userDetail1.put("Email", ""); //nak kekalkan email dan password
        userDetail1.put("Password", "");

        userID = auth.getCurrentUser().getUid();
        fstore.collection("FV").document(userID).set(userDetail1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                // Toast.makeText(UpdateUserForm1.this, "Successfully updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

        private void addDataToFirestore2() {

            Map<String, String> userDetail1 = new HashMap<>();
        //NAK MASUKKAN DATA - DATA LAIN DALAM FLOOD VICTIM DETAIL (successful)
        String mPhoneString = mPhone.getText().toString();
        String mAgeString = mAge.getText().toString();
        String mOccupationString = mOccupation.getText().toString();
        String mIncomeString = mIncome.getText().toString();
        String mAddress1String = mAddress1.getText().toString();
        String mAddress2String = mAddress2.getText().toString();
        String spinnerPostCodeString = spinnerPostCode.getSelectedItem().toString();


        userDetail1.put("Phone", mPhoneString);
        userDetail1.put("Age", mAgeString);
        userDetail1.put("Occupation", mOccupationString);
        userDetail1.put("Income", mIncomeString);
        userDetail1.put("Address1", mAddress1String);
        userDetail1.put("Address2", mAddress2String);
        userDetail1.put("Gender", gender);
        userDetail1.put("Postcode", spinnerPostCodeString);

        userID = auth.getCurrentUser().getUid();
        fstore.collection("floodVictimDetail").document(userID).set(userDetail1).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(UpdateUserForm1.this, "Successfully updated", Toast.LENGTH_SHORT).show();
            }
        });


    }
    //radiobutton gender
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.gendermale1:
                if (checked)
                    gender = mMale.getText().toString();
                break;
            case R.id.genderfemale1:
                if (checked)
                    gender = mFemale.getText().toString();
                break;
        }
    }

    public void onClick(View v){
        int radioId = radiogroup.getCheckedRadioButtonId();
        radiogroup = findViewById(radioId);

    }
}


