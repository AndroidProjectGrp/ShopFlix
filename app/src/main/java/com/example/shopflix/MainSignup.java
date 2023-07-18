package com.example.shopflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainSignup extends AppCompatActivity {
    TextView email1, pass;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);

        email1 = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email1.getText().toString();
                String password = pass.getText().toString();

                SharedPreferences sp = getSharedPreferences("userdata1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", Email);
                editor.putString("password", password);

                editor.apply();
                if (password.isEmpty() || Email.isEmpty()) {
                    Toast.makeText(MainSignup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainSignup.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                navigateToLoginScreen();
            }
        });

}

        private void navigateToLoginScreen () {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

