package com.example.hostelhub1;

import android.content.Intent; // 🔹 Add this import
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDashboardActivity extends AppCompatActivity {

    private Button btnOutpass, btnRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        // Initialize buttons
        btnOutpass = findViewById(R.id.btnOutpass);
        btnRoom = findViewById(R.id.btnRoom);

        // Outpass button click
        btnOutpass.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Outpass Section...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StudentDashboardActivity.this, OutpassActivity.class); // ✅ Navigate to RoomActivity
            startActivity(intent);
            // You can later navigate to OutpassActivity
            // startActivity(new Intent(this, OutpassActivity.class));
        });

        // Room button click → open RoomActivity
        btnRoom.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Room Details...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(StudentDashboardActivity.this, RoomActivity.class); // ✅ Navigate to RoomActivity
            startActivity(intent);
        });
    }
}
