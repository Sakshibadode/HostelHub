package com.example.hostelhub1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentLoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String emailInput = etEmail.getText().toString().trim();
            String passwordInput = etPassword.getText().toString().trim();

            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Get saved credentials from SharedPreferences
            SharedPreferences prefs = getSharedPreferences("StudentData", MODE_PRIVATE);
            String savedEmail = prefs.getString("email", "");
            String savedPassword = prefs.getString("password", "");

            if (emailInput.equals(savedEmail) && passwordInput.equals(savedPassword)) {
                Toast.makeText(this, "Login Successful 🎉", Toast.LENGTH_SHORT).show();

                // Navigate to StudentDashboardActivity
                Intent intent = new Intent(StudentLoginActivity.this, StudentDashboardActivity.class);
                startActivity(intent);
                finish(); // close login activity
            } else {
                Toast.makeText(this, "Invalid Credentials ❌", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
