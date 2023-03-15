package com.example.grafik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TimetableActivity extends AppCompatActivity implements View.OnClickListener, CalendarView.OnDateChangeListener {
    ListView days = null;
    HashMap<String, String> events = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        ((FloatingActionButton) findViewById(R.id.menuButton)).setOnClickListener(this);
        ((CalendarView) findViewById(R.id.calendarView)).setOnDateChangeListener(this);
        days = findViewById(R.id.list_view);

        CustomAdapter adapter = new CustomAdapter(events);
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

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        alert.setMessage("Wpisz opis dnia");
        alert.setTitle("Wydarzenie");
        edittext.setHint("Opisz...");
        edittext.setText(events.get(date));

        alert.setView(edittext);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String event_info = edittext.getText().toString();
                events.put(date, event_info);

                CustomAdapter adapter = new CustomAdapter(events);
                days.setAdapter(adapter);
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                return;
            }
        });


        alert.show();
    }
}




