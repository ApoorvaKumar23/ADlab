package com.example.experiment5;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {

    Button popupButton, contextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupButton = findViewById(R.id.popupButton);
        contextButton = findViewById(R.id.contextButton);

        // Popup Dialog Button Click
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupDialog();
            }
        });

        // Register context menu to contextButton
        registerForContextMenu(contextButton);
    }

    // Step 5: Show Popup Dialog
    private void showPopupDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Popup Dialog");
        builder.setMessage("This is a popup message.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    // Step 6: Create Option Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Option 1");
        menu.add("Option 2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
        return true;
    }

    // Step 7: Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Context 1");
        menu.add(0, v.getId(), 0, "Context 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
        return true;
    }
}
