package com.example.akhilnigam.bigdocto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class bookapp extends AppCompatActivity {

    Spinner spinner2;
    String dotyp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookapp);


        SharedPreferences shared=getSharedPreferences("data", Context.MODE_PRIVATE);
        String na=shared.getString("name","");
        EditText pnaa=(EditText) findViewById(R.id.pna);
        EditText paa=(EditText) findViewById(R.id.pa);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        TextView persna=(TextView) findViewById(R.id.user_profile_name);
        pnaa.setText(na);
      persna.setText(na);
        Button searh_do=(Button) findViewById(R.id.sdo);



        searh_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dotyp  =String.valueOf(spinner2.getSelectedItem());




                Toast.makeText(bookapp.this,dotyp,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(bookapp.this,Searchdo.class);
                intent.putExtra("type", dotyp);
                startActivity(intent);
            }
        });
    }



}
