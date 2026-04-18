package com.example.hostelhub1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StaffLoginActivity extends AppCompatActivity {

    Spinner spUserType;
    EditText etUserName, etPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        spUserType = findViewById(R.id.spUserType);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        // Dropdown options
        String[] userTypes = {"Admin/HOD", "Warden", "Faculty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userTypes);
        spUserType.setAdapter(adapter);

        btnSignIn.setOnClickListener(v -> {
            String userType = spUserType.getSelectedItem().toString();
            String username = etUserName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            // Directly sign in regardless of credentials
            Toast.makeText(this, userType + " Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StaffLoginActivity.this, AdminActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
