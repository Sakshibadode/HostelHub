package com.example.hostelhub1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin); // New simplified layout

        // Example buttons or actions
        Button btnStudent = findViewById(R.id.btnStudent);
        Button btnRooms = findViewById(R.id.btnRooms);
        Button btnOutpass = findViewById(R.id.btnOutpass);

        btnStudent.setOnClickListener(v ->
                Toast.makeText(this, "Student Selected", Toast.LENGTH_SHORT).show());

        btnRooms.setOnClickListener(v ->
                Toast.makeText(this, "Rooms Selected", Toast.LENGTH_SHORT).show());

        btnOutpass.setOnClickListener(v ->
                Toast.makeText(this, "OutPass Approve Selected", Toast.LENGTH_SHORT).show());
    }
}
