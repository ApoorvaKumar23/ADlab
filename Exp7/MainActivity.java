package com.example.experiment7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array of image resources (replace with your own images)
        int[] images = {
                R.drawable.image1, // Add image resources in the drawable folder
                R.drawable.image2,

        };

        // Initialize ViewPager2
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);

        // Create and set the adapter
        ImageSliderAdapter adapter = new ImageSliderAdapter(images);
        viewPager2.setAdapter(adapter);
    }
}
