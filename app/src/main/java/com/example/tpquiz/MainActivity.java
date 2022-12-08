package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.start);

        button.setOnClickListener(e ->{
            Intent intent = new Intent(MainActivity.this, Q1.class);
            startActivity(intent);
        });
    }
}