package com.example.grafik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setListeners();
    }

    public void setListeners() {
        ((FloatingActionButton) findViewById(R.id.menuButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.homeViewButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.infoViewButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.timetableViewButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.statsViewButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.settingsViewButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.aboutViewButton)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println(v);
        switch (v.getId()) {
            case R.id.homeViewButton:
            case R.id.menuButton:
                redirectTo(MainActivity.class);
                break;
            case R.id.infoViewButton:
                redirectTo(InfoActivity.class);
                break;
            case R.id.timetableViewButton:
                redirectTo(TimetableActivity.class);
                break;
            case R.id.statsViewButton:
                redirectTo(StatsActivity.class);
                break;
            case R.id.settingsViewButton:
                redirectTo(SettingsActivity.class);
                break;
            case R.id.aboutViewButton:
                redirectTo(AboutActivity.class);
                break;
        }
    }

    public void redirectTo(Class cls) {
        Intent myIntent = new Intent(this, cls);
        startActivity(myIntent);
    }
}