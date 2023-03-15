package com.example.grafik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StatsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText amount = null;
    EditText time = null;
    TextView result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ((FloatingActionButton) findViewById(R.id.menuButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.button)).setOnClickListener(this);

        amount = findViewById(R.id.amount);
        time = findViewById(R.id.time);
        result = findViewById(R.id.result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menuButton:
                Intent myIntent = new Intent(this, MenuActivity.class);
                startActivity(myIntent);
                break;
            case R.id.button:
                int a = Integer.parseInt(amount.getEditableText().toString());
                int b = Integer.parseInt(time.getEditableText().toString());

                if (b == 0) {
                    result.setText("0 rekinów na minutę");
                    break;
                }

                int vel = a / b;
                result.setText(String.format("%d rekinów na minutę", vel));

                break;
        }
    }
}