package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

public class ViewHousehold4 extends AppCompatActivity {

    String userID;
    FirebaseFirestore fstore;
    Button update;
    Button nextview;
    TextView mEditubaby1, mEdituchildren1, mEdituteenager1, mEdituadult1, mEdituelderly1, mEditudisable1;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhousehold4);

        mEditubaby1 = findViewById(R.id.editubaby4);
        mEdituchildren1 = findViewById(R.id.edituchildren4);
        mEdituteenager1 = findViewById(R.id.edituteenager4);
        mEdituadult1 = findViewById(R.id.edituadult4);
        mEdituelderly1 = findViewById(R.id.edituelderly4);
        mEditudisable1 = findViewById(R.id.editudisable4);


        update = findViewById(R.id.vhupdate4);
        nextview = findViewById(R.id.vhnext4);

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
        nextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNext();
            }

        });
    }

    private void onClickNext() {
        Intent next = new Intent(ViewHousehold4.this, ViewDonate4.class);
        startActivity(next);
    }

    private void onClickUpdate() {
        Intent update = new Intent(ViewHousehold4.this, UpdateHouseholdForm4.class); // ni untuk pi activity
        startActivity(update);
    }
}
