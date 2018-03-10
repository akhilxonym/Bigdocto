package com.example.akhilnigam.bigdocto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class userprofile extends AppCompatActivity {

    SharedPreferences sharedPref;
    private String Read;
    TextView userna;
    TextView rep;
    TextView bap;
    TextView pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

     SharedPreferences shared=getSharedPreferences("data", Context.MODE_PRIVATE);
        String na=shared.getString("name","");

      userna=(TextView) findViewById(R.id.user_profile_name);

        rep=(TextView) findViewById(R.id.report);
        bap=(TextView) findViewById(R.id.bapp);
        pr=(TextView) findViewById(R.id.pre);

        String enail=shared.getString("enail","");
        Toast.makeText(userprofile.this,na,Toast.LENGTH_SHORT).show();
        userna.setText("Hi! "+na);


        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        bap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userprofile.this,bookapp.class);
                startActivity(intent);

            }
        });


    }
}
