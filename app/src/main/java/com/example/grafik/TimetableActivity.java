package com.example.grafik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TimetableActivity extends AppCompatActivity implements View.OnClickListener, CalendarView.OnDateChangeListener {
    ListView days = null;
    Set<String> dates = new HashSet<String>();
    ArrayList<String> dates2 = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        ((FloatingActionButton) findViewById(R.id.menuButton)).setOnClickListener(this);
        ((CalendarView) findViewById(R.id.calendarView)).setOnDateChangeListener(this);

        days = findViewById(R.id.workoutDaysList);
        adapter = new ArrayAdapter<String>(this, R.layout.list_custom_text, dates2);
        days.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuButton:
                Intent myIntent = new Intent(this, MenuActivity.class);
                startActivity(myIntent);
                break;
        }
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date = sdf.format(LocalDate.of(year, month + 1, dayOfMonth));
        if (dates.contains(date)) {
            dates.remove(date);
        } else {
            dates.add(date);
        }

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.list_custom_text, R.id.list_content, Arrays.asList(dates.toArray(new String[dates.size()])));
        days.setAdapter(a);
    }
}




