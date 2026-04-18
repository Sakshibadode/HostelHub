package com.example.hostelhub1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OutpassActivity extends AppCompatActivity {

    EditText etReason, etDetail, etFromDate, etToDate;
    Button btnSubmit;
    TableLayout tableLayout;
    int idCounter = 1;
    String studentEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpass);

        // Receive student email from intent
        studentEmail = getIntent().getStringExtra("studentEmail");

        etReason = findViewById(R.id.etReason);
        etDetail = findViewById(R.id.etDetail);
        etFromDate = findViewById(R.id.etFromDate);
        etToDate = findViewById(R.id.etToDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        tableLayout = findViewById(R.id.tableLayout);

        addTableHeader();

        btnSubmit.setOnClickListener(v -> addOutpassRow());
    }

    private void addTableHeader() {
        TableRow header = new TableRow(this);
        String[] headers = {"ID", "Email", "Reason", "From", "To", "Date", "Status"};
        for (String h : headers) {
            TextView tv = new TextView(this);
            tv.setText(h);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(8, 8, 8, 8);
            tv.setTextAppearance(android.R.style.TextAppearance_Medium);
            tv.setBackgroundColor(0xFFD6D6D6); // light gray header
            header.addView(tv);
        }
        tableLayout.addView(header);
    }

    private void addOutpassRow() {
        String reason = etReason.getText().toString().trim();
        String detail = etDetail.getText().toString().trim();
        String from = etFromDate.getText().toString().trim();
        String to = etToDate.getText().toString().trim();
        String requestDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        if (reason.isEmpty() || detail.isEmpty() || from.isEmpty() || to.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        TableRow row = new TableRow(this);
        row.setPadding(6, 6, 6, 6);

        String[] data = {String.valueOf(idCounter++), studentEmail, reason, from, to, requestDate, "Pending"};
        for (String item : data) {
            TextView tv = new TextView(this);
            tv.setText(item);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(6, 6, 6, 6);
            tv.setTextSize(13);
            tv.setBackgroundResource(android.R.drawable.editbox_background);
            tv.setPadding(10,10,10,10);
            row.addView(tv);
        }

        tableLayout.addView(row);
        clearFields();
    }

    private void clearFields() {
        etReason.setText("");
        etDetail.setText("");
        etFromDate.setText("");
        etToDate.setText("");
    }
}
