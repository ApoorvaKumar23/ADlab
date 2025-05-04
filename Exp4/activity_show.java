package com.example.e4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_show extends AppCompatActivity {

    TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        showData = findViewById(R.id.showData);

        String subject = getIntent().getStringExtra("subject");
        String gender = getIntent().getStringExtra("gender");
        String qualification = getIntent().getStringExtra("qualification");

        String result = "Subject: " + subject + "\nGender: " + gender + "\nQualification: " + qualification;
        showData.setText(result);
    }
}
