package com.example.fdm.NGO;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fdm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddListDonationType_NGO extends AppCompatActivity {

    Button add;
    String ngoID;
    FirebaseFirestore fstore;

    private EditText ngoname;
    private EditText ngoemail;
    private EditText ngophone;
    private EditText ngoaddress;
    private EditText listdonate;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlistdonationtypengo);

        ngoname = findViewById(R.id.ngoeditname);
        ngoemail = findViewById(R.id.ngoeditemail);
        ngophone = findViewById(R.id.ngoeditphone);
        ngoaddress = findViewById(R.id.ngoeditaddress);
        listdonate = findViewById(R.id.listdonation);
        add = findViewById(R.id.buttonadd);


        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedAdd();
            }
        });

    }

    private void onClickedAdd() {
        String mNGONameString = ngoname.getText().toString();
        String mNGOEmailString = ngoemail.getText().toString();
        String mNGOPhoneString = ngophone.getText().toString();
        String mNGOAddressString = ngoaddress.getText().toString();
        String mNGOListString = listdonate.getText().toString();

        if (TextUtils.isEmpty(mNGONameString)) {
            Toast.makeText(AddListDonationType_NGO.this, "Enter the organisation name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOEmailString)) {
            Toast.makeText(AddListDonationType_NGO.this, "Enter the organisation email", Toast.LENGTH_SHORT).show();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(mNGOEmailString).matches()) {
            ngoemail.setError("Please provide valid email!");
            ngoemail.requestFocus();
        } else if (TextUtils.isEmpty(mNGOPhoneString)) {
            Toast.makeText(AddListDonationType_NGO.this, "Enter the organisation phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOAddressString)) {
            Toast.makeText(AddListDonationType_NGO.this, "Enter the organisation address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOListString)) {
            Toast.makeText(AddListDonationType_NGO.this, "Enter list donations provided by your organisations", Toast.LENGTH_SHORT).show();
        } else {
            addDataToFirestore();
            Toast.makeText(AddListDonationType_NGO.this, "Successfully added!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(AddListDonationType_NGO.this, HomeActivity_NGO.class);
            startActivity(i);
        }
    }

    private void addDataToFirestore() {

        Map<String, String> NGODetail1 = new HashMap<>();

        String mNGONameString = ngoname.getText().toString();
        String mNGOEmailString = ngoemail.getText().toString();
        String mNGOPhoneString = ngophone.getText().toString();
        String mNGOAddressString = ngoaddress.getText().toString();
        String mNGOListString = listdonate.getText().toString();

        NGODetail1.put("Name", mNGONameString);
        NGODetail1.put("Email", mNGOEmailString);
        NGODetail1.put("Phone", mNGOPhoneString);
        NGODetail1.put("Address", mNGOAddressString);
        NGODetail1.put("DonationType", mNGOListString);


        fstore.collection("NGOOrganisationDetail").add(NGODetail1).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {

            }
        });

    }
}