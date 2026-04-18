package com.example.hostelhub1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStudentLogin, btnStaffLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStudentLogin = findViewById(R.id.btnStudentLogin);
        btnStaffLogin = findViewById(R.id.btnStaffLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // Open Student Login
        btnStudentLogin.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, StudentLoginActivity.class))
        );

        // Open Staff Login
        btnStaffLogin.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, StaffLoginActivity.class))
        );

        // Open Student Registration
        btnRegister.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, StudentRegistrationActivity.class))
        );
    }
}
