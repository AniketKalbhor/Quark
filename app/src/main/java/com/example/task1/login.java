package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity {
//alert fields, no back from login, login register login
    EditText password,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login = (Button)findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
//        Bundle extras = getIntent().getExtras();
        String mailId = null;
        String pass = null;
//        if (extras != null) {
//            mailId = extras.getString("userMail");
//            pass = extras.getString("userPassword");
//        }
        MyDBHelper dbHelper = new MyDBHelper(login.this);
        ArrayList<LoginModel> arrCred = dbHelper.fetchCred();
        for(int i = 0; i<arrCred.size(); i++){
            Log.d("USER INFO","Name: "+arrCred.get(i).name+", Email: "+arrCred.get(i).email+"' Password: "+arrCred.get(i).password+", Phone: "+arrCred.get(i).phone);
            mailId = arrCred.get(i).email;
            pass = arrCred.get(i).password;
        }
        String finalPass = pass;
        String finalMailId = mailId;
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uEmail = email.getText().toString().trim(); //use here
                String uPassword = password.getText().toString().trim() ;
                Toast.makeText(getApplicationContext(), ""+uEmail+uPassword, Toast.LENGTH_SHORT).show();
                if (uEmail.equals(finalMailId) && uPassword.equals(finalPass)) {
                    Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                    Intent next;
                    next = new Intent(login.this, home.class);
                    startActivity(next);
                } else if (uEmail.isEmpty() || uPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Login failed, enter all credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

    }
}
