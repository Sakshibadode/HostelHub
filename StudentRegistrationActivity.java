package com.example.hostelhub1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StudentRegistrationActivity extends AppCompatActivity {

    EditText etName, etEmail, etPRN, etAddress, etPassword, etRePassword;
    Spinner spDepartment, spYear;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPRN = findViewById(R.id.etPRN);
        spDepartment = findViewById(R.id.spDepartment);
        spYear = findViewById(R.id.spYear);
        etAddress = findViewById(R.id.etAddress);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Department dropdown
        String[] departments = {"CSE", "IT", "ENTC", "CIVIL", "MECH"};
        ArrayAdapter<String> deptAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, departments);
        spDepartment.setAdapter(deptAdapter);

        // Year dropdown
        String[] years = {"FY", "SY", "TY", "BE"};
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years);
        spYear.setAdapter(yearAdapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String prn = etPRN.getText().toString().trim();
                String dept = spDepartment.getSelectedItem().toString();
                String year = spYear.getSelectedItem().toString();
                String address = etAddress.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();
                String repass = etRePassword.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || prn.isEmpty() || address.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                    Toast.makeText(StudentRegistrationActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(repass)) {
                    Toast.makeText(StudentRegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Save email and password using SharedPreferences
                    SharedPreferences prefs = getSharedPreferences("StudentData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("email", email);
                    editor.putString("password", pass);
                    editor.apply();

                    Toast.makeText(StudentRegistrationActivity.this,
                            "Registration Successful!\nYou can now log in.",
                            Toast.LENGTH_LONG).show();
                    finish(); // Go back to login page
                }
            }
        });
    }
}
