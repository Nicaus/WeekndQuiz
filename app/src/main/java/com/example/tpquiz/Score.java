package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Score extends AppCompatActivity {

    Button quit, recommencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        quit = findViewById(R.id.quitter);
        recommencer = findViewById(R.id.recommencer);

        quit.setOnClickListener(q ->{
            finish();
        });

        recommencer.setOnClickListener(r->{
            Intent intent = new Intent(Score.this, MainActivity.class);
            startActivity(intent);
        });
    }
}