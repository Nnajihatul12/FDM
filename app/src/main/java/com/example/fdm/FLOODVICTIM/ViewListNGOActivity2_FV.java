package com.example.fdm.FLOODVICTIM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fdm.R;

public class ViewListNGOActivity2_FV extends AppCompatActivity {

    ImageView vd9, vd10, vd11, vd12, vd13, vd14, vd15, vd16;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistngo2_fv);

        vd9 = findViewById(R.id.vd9);
        vd10 = findViewById(R.id.vd10);
        vd11 = findViewById(R.id.vd11);
        vd12 = findViewById(R.id.vd12);
        vd13 = findViewById(R.id.vd13);
        vd14 = findViewById(R.id.vd14);
        vd15 = findViewById(R.id.vd15);
        vd16 = findViewById(R.id.vd16);
        back = findViewById(R.id.back);

        //view detail 9
        vd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                onClickedVD9();
            }

        });

        //view detail 10
        vd10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD10();}

        });

        //view detail 11
        vd11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD11();}

        });

        //view detail 12
        vd12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD12();}

        });

        //view detail 13
        vd13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD13();}

        });

        //view detail 14
        vd14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD14();}

        });

        //view detail 15
        vd15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD15();}

        });

        //view detail 16
        vd16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedVD16();}

        });

        //back
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vv){onClickedBack();}

        });

    }



    //view detail 9
    private void onClickedVD9(){
        Intent i = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO9.class);
        startActivity(i);
    }
    //view detail 10
    private void onClickedVD10(){
        Intent ii = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO10.class);
        startActivity(ii);
    }
    //view detail 11
    private void onClickedVD11(){
        Intent iii = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO11.class);
        startActivity(iii);
    }
    //view detail 12
    private void onClickedVD12(){
        Intent iv = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO12.class);
        startActivity(iv);
    }
    //view detail 13
    private void onClickedVD13(){
        Intent v = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO13.class);
        startActivity(v);
    }
    //view detail 14
    private void onClickedVD14(){
        Intent vi = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO14.class);
        startActivity(vi);
    }
    //view detail 15
    private void onClickedVD15(){
        Intent vii = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO15.class);
        startActivity(vii);
    }
    //view detail 16
    private void onClickedVD16(){
        Intent viii = new Intent(ViewListNGOActivity2_FV.this, ViewDetailNGO16.class);
        startActivity(viii);
    }

    //back
    private void onClickedBack(){
        Intent vv = new Intent(ViewListNGOActivity2_FV.this, ViewListNGOActivity1_FV.class);
        startActivity(vv);
    }

}