package com.example.fb_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton, createAccount;
    EditText password, userName;
    String pWord, uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.Log_in);
        password = findViewById(R.id.password);
        userName = findViewById(R.id.phone_email);
        pWord = password.getText().toString();
        uName = userName.getText().toString();


        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equalsIgnoreCase("Roshan")) {
                    Intent new_activity = new Intent(getApplicationContext(), MainActivity2.class);
                    Bundle newBundle = new Bundle();
                    newBundle.putString("phNum", uName);
                    new_activity.putExtras(newBundle);
                    startActivity(new_activity);
                    password.setText("");

                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter a valid user name and password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
