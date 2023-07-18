package com.example.shopflix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainSignin extends AppCompatActivity {
 TextView pass1,email1;
 Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signin);

        pass1 = findViewById(R.id.pass1);
        email1 = findViewById(R.id.email1);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email1.getText().toString();
                String password = pass1.getText().toString();

                SharedPreferences sp = getSharedPreferences("userdata1", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                String savedEmail = sp.getString("email", "");
                String savedPassword = sp.getString("password", "");

                // Compare entered email and password with saved values
                if (Email.equals(savedEmail) && password.equals(savedPassword)) {
                    // Credentials are valid
                    Toast.makeText(MainSignin.this, "Signin successful", Toast.LENGTH_SHORT).show();
                    // Proceed to the main screen or perform desired action
                } else {
                    // Credentials are invalid
                    Toast.makeText(MainSignin.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
});
    }
}