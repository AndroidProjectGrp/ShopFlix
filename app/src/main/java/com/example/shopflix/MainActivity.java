package com.example.shopflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
 Button login;
 TextView pass1,email1,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     signup = findViewById(R.id.signup);
     pass1  = findViewById(R.id.pass1);
     email1 = findViewById(R.id.email1);
     login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email1.getText().toString();
                String password = pass1.getText().toString();

                SharedPreferences sp = getSharedPreferences("userdata1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                String savedEmail = sp.getString("email", "");
                String savedPassword = sp.getString("password", "");

                if (Email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();

                }else if (Email.equals(savedEmail) && password.equals(savedPassword)) {

                    Toast.makeText(MainActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob = new Intent(MainActivity.this,MainSignup.class);
                startActivity(ob);
            }
        });
    }
    }
