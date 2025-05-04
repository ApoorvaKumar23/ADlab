package com.example.e4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    RadioGroup genderGroup;
    CheckBox grad, postgrad;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        genderGroup = findViewById(R.id.genderGroup);
        grad = findViewById(R.id.grad);
        postgrad = findViewById(R.id.postgrad);
        submitBtn = findViewById(R.id.submitBtn);

        String[] subjects = {"Math", "Physics", "Chemistry"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, subjects);
        spinner.setAdapter(adapter);

        submitBtn.setOnClickListener(v -> {
            String subject = spinner.getSelectedItem().toString();
            String gender = ((RadioButton) findViewById(genderGroup.getCheckedRadioButtonId())).getText().toString();

            String qualification = "";
            if (grad.isChecked()) qualification += "Graduate ";
            if (postgrad.isChecked()) qualification += "Post Graduate";

            Intent intent = new Intent(MainActivity.this, activity_show.class);
            intent.putExtra("subject", subject);
            intent.putExtra("gender", gender);
            intent.putExtra("qualification", qualification);
            startActivity(intent);
        });
    }
}
