package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    Button profile;
    TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profile = (Button) findViewById(R.id.profile);
        hello = findViewById(R.id.hello);
        String name = null ;
        MyDBHelper dbHelper = new MyDBHelper(home.this);
        ArrayList<LoginModel> arrCred = dbHelper.fetchCred();
        for(int i = 0; i<arrCred.size(); i++){
            name = "Welcome, "+arrCred.get(i).name;
        }
        hello.setText(name);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goProfile= new Intent(home.this, profile.class);
                startActivity(goProfile);
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}