package com.example.grafik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ((FloatingActionButton) findViewById(R.id.menuButton)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menuButton:
                Intent myIntent = new Intent(this, MenuActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
                break;
        }
    }
}