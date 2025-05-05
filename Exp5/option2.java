package com.example.ex5;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    Button popupButton,contextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       popupButton=findViewById(R.id.popupButton);
       contextButton=findViewById(R.id.contextButton);
       popupButton.setOnClickListener(view -> {
           new AlertDialog.Builder(this)
           .setTitle("Popup dialog")
           .setMessage("This is a popup message")
           .setPositiveButton("OK",null)
           .show();


        });
       registerForContextMenu(contextButton);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Option 1");
        menu.add("Option 2");
    }

    // Show a message when an option is selected from the context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
        return true;
    }
}
