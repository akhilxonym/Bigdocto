package com.example.akhilnigam.bigdocto;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText usern;
    EditText pass;
    EditText enail;
     Spinner spinner1;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Text to display response result
       text = (TextView) findViewById(R.id.textView);

        usern = (EditText) findViewById(R.id.usern);
        pass = (EditText) findViewById(R.id.pass);
        enail = (EditText) findViewById(R.id.enail);
        Button btnRegister = (Button) findViewById(R.id.reg);

        spinner1 = (Spinner) findViewById(R.id.spinner1);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //  final String username = inputFullName.getText().toString().trim();
                String email = enail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String userna = usern.getText().toString().trim();
                String city  =String.valueOf(spinner1.getSelectedItem());



                Toast.makeText(MainActivity.this, city, Toast.LENGTH_SHORT).show();


                if (!email.isEmpty() && !password.isEmpty()) {

                    final String Username, Email, Password;
                    //     Username=username;
                    Email = email;
                    Password = password;

                    SharedPreferences shared=getSharedPreferences("data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=shared.edit();
                    editor.putString("name",userna);
                    editor.putString("enail",email);
                    editor.putString("city",city);
                    editor.commit();

                    //Executing AsyncTask, passing api as parameter
                    new CheckConnectionStatus().execute("http://helpemglocalplatform.000webhostapp.com/page1.php", email, password,userna,city);
                }
            }

        });


    }
    //AsyncTask to process network request
    class  CheckConnectionStatus extends AsyncTask<String, Void, String> {

        //This method will run on UIThread and it will execute before doInBackground
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Making text field blank
            text.setText("");
        }

        //This method will run on background thread and after completion it will return result to onPostExecute
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try {
                //As we are passing just one parameter to AsyncTask, so used param[0] to get value at 0th position that is URL
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);

                //Building URI
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("Email", params[1])
                        .appendQueryParameter("Password", params[2])
                        .appendQueryParameter("Username", params[3])
                        .appendQueryParameter("City", params[4]);

                //Getting object of OutputStream from urlConnection to write some data to stream
                OutputStream outputStream = urlConnection.getOutputStream();

                //Writer to write data to OutputStream
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write(builder.build().getEncodedQuery());
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                urlConnection.connect();

                //Getting inputstream from connection, that is response which we got from server
                InputStream inputStream = urlConnection.getInputStream();

                //Reading the response
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                bufferedReader.close();

                //Returning the response message to onPostExecute method
                return s;
            } catch (IOException e) {
                Log.e("Error: ", e.getMessage(), e);
            }
            return null;
        }

        //This method runs on UIThread and it will execute when doInBackground is completed
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //Setting the response message to textview
            if (s.equals("Success")) {
                text.setText(s);
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

            } else

            {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, userprofile.class);
                startActivity(intent);
            }
        }
    }}