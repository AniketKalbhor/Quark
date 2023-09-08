package com.example.task1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class register extends AppCompatActivity {

    EditText Email, Password, Phone, Name;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Email = findViewById(R.id.email);
        Name = findViewById(R.id.name);
        Phone = findViewById(R.id.phone);
        register = (Button) findViewById(R.id.register);
        Password = findViewById(R.id.password);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uEmail = Email.getText().toString().trim();
                    String uPhone = Phone.getText().toString().trim();
                    String uName = Name.getText().toString().trim();
                    String uPassword = Password.getText().toString();
                    if(uEmail.isEmpty() || uPassword.isEmpty() || uPhone.isEmpty() || uName.isEmpty()){
                        Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        MyDBHelper dbHelper = new MyDBHelper(register.this);
                        dbHelper.addCreds(uName,uEmail,uPassword,uPhone);
//                        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = pref.edit();
//                        editor.putString("name", uName);
//                        editor.putString("email", uEmail);
//                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Sending" + uEmail + uPassword, Toast.LENGTH_SHORT).show();
                        Intent next;
                        next = new Intent(register.this, login.class); //can be declared outside, defines from where to where
//                        next.putExtra("userMail", uEmail);
//                        next.putExtra("userPassword", uPassword);
                        startActivity(next); //actual shift
                    }
                }
            });
    }
    @Override
    public void onBackPressed() {

    }
}