package com.example.grafik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView phoneStatsView = findViewById(R.id.phoneStats);
        phoneStatsView.setText(String.format("%s %s, SDK: %s(%s)", Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT, Build.VERSION.RELEASE));

        FloatingActionButton menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(myIntent);
            }
        });
    }
}