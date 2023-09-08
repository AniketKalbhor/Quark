package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    Button logout;
    TextView Email, Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Email = findViewById(R.id.email);
        logout = (Button) findViewById(R.id.logout);
        Name = findViewById(R.id.name);
//        SharedPreferences getData = getSharedPreferences("login", MODE_PRIVATE);
//        String name = getData.getString("name","NULL");
//        String email = getData.getString("email","NULL");
        String name = null;
        String email = null;
        MyDBHelper dbHelper = new MyDBHelper(profile.this);
        ArrayList<LoginModel> arrCred = dbHelper.fetchCred();
        for(int i = 0; i<arrCred.size(); i++){
            name = arrCred.get(i).name;
            email = arrCred.get(i).email;
        }
        Name.setText(name);
        Email.setText(email);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                Intent next;
                next = new Intent(profile.this, welcome.class);
                startActivity(next);
            }
        });
    }
}