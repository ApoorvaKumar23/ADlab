package com.example.experiment9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editTextData;
    Button buttonSave, buttonLoad;
    TextView textViewResult;

    private static final String FILE_NAME = "mydata.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextData = findViewById(R.id.editTextData);
        buttonSave = findViewById(R.id.buttonSave);
        buttonLoad = findViewById(R.id.buttonLoad);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editTextData.getText().toString();
                saveToFile(data);
            }
        });

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFromFile();
            }
        });
    }

    private void saveToFile(String data) {
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
            editTextData.setText("");
            textViewResult.setText("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();

            String data = new String(buffer);
            textViewResult.setText(data);
        } catch (IOException e) {
            e.printStackTrace();
            textViewResult.setText("Failed to load data.");
        }
    }
}
