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


import com.example.fdm.Model.FloodVictimEntity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class UserForm3 extends AppCompatActivity {

    TextView fullname;
    RadioGroup radiogroup;
    Button unext3;
    String userID;
    FirebaseFirestore fstore;

    private EditText phone;
    private EditText age;
    private EditText occupation;
    private EditText income;
    private EditText address1;
    private EditText address2;
    private RadioButton male;
    private RadioButton female;
    private String gender;
    Spinner spinnerPostCode;


    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userform3);

        phone = findViewById(R.id.phone3);
        age = findViewById(R.id.age3);
        occupation = findViewById(R.id.occupation3);
        income = findViewById(R.id.income3);
        address1 = findViewById(R.id.addressa3);
        address2 = findViewById(R.id.addressb3);
        male = findViewById(R.id.gendermale3);
        female = findViewById(R.id.genderfemale3);
//        postcode = findViewById(R.id.postcode1);
        unext3 = findViewById(R.id.unext3);
        spinnerPostCode = (Spinner) findViewById(R.id.postcode1);
        fullname = findViewById(R.id.fullname);
        radiogroup = findViewById(R.id.radiogroup);


        auth = FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.postcode1, android.R.layout.simple_spinner_dropdown_item);
        spinnerPostCode.setAdapter(adapter);

        getListItems();

        unext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedNext();
            }
        });
    }

    //radiobutton gender
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.gendermale3:
                if (checked)
                    gender = male.getText().toString();
                break;
            case R.id.genderfemale3:
                if (checked)
                    gender = female.getText().toString();
                break;
        }
    }

    public void onClick(View v){
        int radioId = radiogroup.getCheckedRadioButtonId();
        radiogroup = findViewById(radioId);

    }




    private void onClickedNext() {

        String mPhoneString = phone.getText().toString();
        String mAgeString = age.getText().toString();
        String mOccupationString = occupation.getText().toString();
        String mIncomeString = income.getText().toString();
        String mAddress1String = address1.getText().toString();
        String mAddress2String = address2.getText().toString();

        //edittext function
        if (TextUtils.isEmpty(mPhoneString)) {
            Toast.makeText(UserForm3.this, "Enter the phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAgeString)) {
            Toast.makeText(UserForm3.this, "Enter the age", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mOccupationString)) {
            Toast.makeText(UserForm3.this, "Enter the occupation", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mIncomeString)) {
            Toast.makeText(UserForm3.this, "Enter the income", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAddress1String)) {
            Toast.makeText(UserForm3.this, "Enter the address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mAddress2String)) {
            Toast.makeText(UserForm3.this, "Enter the address", Toast.LENGTH_SHORT).show();
        } else {
            addDataToFirestore();
        }



    }

    //Store userdetail in firebase.

    private void addDataToFirestore() {

        Map<String, String> userDetail1 = new HashMap<>();
        FloodVictimEntity floodVictimEntity = new FloodVictimEntity();

        String mPhoneString = phone.getText().toString();
        String mAgeString = age.getText().toString();
        String mGenderString = gender;
        String mOccupationString = occupation.getText().toString();
        String mIncomeString = income.getText().toString();
        String mAddress1String = address1.getText().toString();
        String mAddress2String = address2.getText().toString();
        String spinnerPostCodeString = spinnerPostCode.getSelectedItem().toString();

        floodVictimEntity.setPhoneNo(mPhoneString);
        floodVictimEntity.setGender(mGenderString);
        floodVictimEntity.setAge(mAgeString);
        floodVictimEntity.setOccupation(mOccupationString);
        floodVictimEntity.setIncome(mIncomeString);
        floodVictimEntity.setAddress1(mAddress1String);
        floodVictimEntity.setAddress2(mAddress2String);
        floodVictimEntity.setPostcode(spinnerPostCodeString);


        Intent intent = new Intent(UserForm3.this, HouseholdForm3.class);
        Bundle b = new Bundle();
        b.putSerializable(getString(R.string.key_flood_victim_form3), floodVictimEntity);

        intent.putExtras(b);
        startActivity(intent);

    }


    private void getListItems() {

        userID = auth.getCurrentUser().getUid();
        DocumentReference documentReferenceFV = fstore.collection("floodVictimDetail(FoodAids)").document(userID);
        documentReferenceFV.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                fullname.setText(documentSnapshot.getString("Fullname"));
            }
        });
    }

}

