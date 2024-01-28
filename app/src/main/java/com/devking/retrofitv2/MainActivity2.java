package com.devking.retrofitv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView email_tv = findViewById(R.id.email);
        TextView body_tv = findViewById(R.id.body);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String body = intent.getStringExtra("body");

        email_tv.append("Email: "+ email);
        body_tv.append("Body: "+body);
    }

    public void back(View v){
        Intent intent_back = new Intent(this,MainActivity.class);
        startActivity(intent_back);
    }
}