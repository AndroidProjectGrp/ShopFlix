package com.example.shopflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainSignup extends AppCompatActivity {
    TextView email1, pass,cpass,signin;
    Button save;
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);

        arrow = findViewById(R.id.arrow);
        email1 = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        save = findViewById(R.id.save);
        cpass = findViewById(R.id.cpass);
        signin = findViewById(R.id.signin);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob = new Intent(MainSignup.this,MainActivity.class);
                startActivity(ob);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email1.getText().toString();
                String password = pass.getText().toString();
                String Com_pass = cpass.getText().toString();

                SharedPreferences sp = getSharedPreferences("userdata1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", Email);
                editor.putString("password", password);
                editor.putString("Comfirm",Com_pass);

                editor.apply();
                if (password.isEmpty() || Email.isEmpty() || Com_pass.isEmpty()) {
                    Toast.makeText(MainSignup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else if (Com_pass.equals(password)) {
                    Toast.makeText(MainSignup.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainSignup.this,"Enter correct password",Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob = new Intent(MainSignup.this,MainActivity.class);
                startActivity(ob);
            }
        });

}

    }

