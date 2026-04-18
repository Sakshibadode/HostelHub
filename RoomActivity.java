package com.example.hostelhub1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoomActivity extends AppCompatActivity {

    private TextView tvFormLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        tvFormLink = findViewById(R.id.tvFormLink);

        // Your Google Form link
        String googleFormUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfMP6KSg7tS4CO_-tdyZUKMP8UIC5hKRO0O-W5GjYGmMqxLvw/viewform?usp=header";
        tvFormLink.setText(googleFormUrl);

        // When user clicks the link, open it in a browser
        tvFormLink.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleFormUrl));
            startActivity(intent);
        });
    }
}
