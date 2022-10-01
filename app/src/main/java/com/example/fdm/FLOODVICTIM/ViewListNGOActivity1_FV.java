package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.FLOODVICTIM.ViewDetailNGO1;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO2;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO3;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO4;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO5;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO6;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO7;
import com.example.fdm.FLOODVICTIM.ViewDetailNGO8;
import com.example.fdm.FLOODVICTIM.ViewListNGOActivity2_FV;
import com.example.fdm.R;

public class ViewListNGOActivity1_FV extends AppCompatActivity {

    ImageView vd1;
    ImageView vd2;
    ImageView vd3;
    ImageView vd4;
    ImageView vd5;
    ImageView vd6;
    ImageView vd7;
    ImageView vd8;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistngo1_fv);

        vd1 = findViewById(R.id.vd1);
        vd2 = findViewById(R.id.vd2);
        vd3 = findViewById(R.id.vd3);
        vd4 = findViewById(R.id.vd4);
        vd5 = findViewById(R.id.vd5);
        vd6 = findViewById(R.id.vd6);
        vd7 = findViewById(R.id.vd7);
        vd8 = findViewById(R.id.vd8);
        next = findViewById(R.id.next);

        //view detail 1
        vd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                onClickedVD1();
            }

        });

        //view detail 2
        vd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                onClickedVD2();
            }

        });

        //view detail 3
        vd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                onClickedVD3();
            }

        });

        //view detail 4
        vd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View d) {
                onClickedVD4();
            }

        });

        //view detail 5
        vd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View e) {
                onClickedVD5();
            }

        });

        //view detail 6
        vd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View f) {
                onClickedVD6();
            }

        });

        //view detail 7
        vd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View g) {
                onClickedVD7();
            }

        });

        //view detail 8
        vd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View h) {
                onClickedVD8();
            }

        });

        //next
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View i) {
                onClickedNext();
            }

        });
    }


    //next
    private void onClickedNext() {
        Intent vv = new Intent(ViewListNGOActivity1_FV.this, ViewListNGOActivity2_FV.class);
        startActivity(vv);
    }
    //view detail 1
    private void onClickedVD1() {
        Intent i = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO1.class);
        startActivity(i);
    }

    //view detail 2
    private void onClickedVD2() {
        Intent ii = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO2.class);
        startActivity(ii);
    }

    //view detail 3
    private void onClickedVD3() {
        Intent iii = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO3.class);
        startActivity(iii);
    }

    //view detail 4
    private void onClickedVD4() {
        Intent iv = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO4.class);
        startActivity(iv);
    }

    //view detail 5
    private void onClickedVD5() {
        Intent v = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO5.class);
        startActivity(v);
    }

    //view detail 6
    private void onClickedVD6() {
        Intent vi = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO6.class);
        startActivity(vi);
    }

    //view detail 7
    private void onClickedVD7() {
        Intent vii = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO7.class);
        startActivity(vii);
    }

    //view detail 8
    private void onClickedVD8() {
        Intent viii = new Intent(ViewListNGOActivity1_FV.this, ViewDetailNGO8.class);
        startActivity(viii);
    }



}