package com.example.layoutdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Button changeLayoutButton;
    private int currentLayoutIndex = 0;
    private int[] layouts = {
            R.layout.layout_constraint,
            R.layout.layout_linear,
            R.layout.layout_relative,
            R.layout.layout_frame,
            R.layout.layout_table
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        frameLayout = findViewById(R.id.frameLayout);
        changeLayoutButton = findViewById(R.id.changeLayoutButton);

        // Set initial layout
        showLayout(layouts[currentLayoutIndex]);

        // Button click listener to cycle through layouts
        changeLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLayoutIndex = (currentLayoutIndex + 1) % layouts.length;
                showLayout(layouts[currentLayoutIndex]);
            }
        });
    }

    private void showLayout(int layoutResID) {
        frameLayout.removeAllViews();
        View view = LayoutInflater.from(this).inflate(layoutResID, frameLayout, false);
        frameLayout.addView(view);
    }
}
