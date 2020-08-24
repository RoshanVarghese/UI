package com.example.fb_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btnSms, btnDial, btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnSms = findViewById(R.id.SMS_button);
        btnDial = findViewById(R.id.dial_button);
        btnBrowser = findViewById(R.id.open_browser);
        Bundle newBundle = getIntent().getExtras();
        final String phNumber = newBundle.getString("phNum");

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(" send sms", "");
                Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("smsto: "));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", new String("9632244517;9448704186"));
                smsIntent.putExtra("sms_body", "Hello. How are you??");
                try {
                    startActivity(smsIntent);
                    finish();
                    Log.i("done sending sms", "");
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(), "sending sms failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openBrowser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/reference/android/net/Uri"));
                startActivity(openBrowser);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + new String("7259731494")));
                startActivity(dialNumber);
            }
        });
    }
}