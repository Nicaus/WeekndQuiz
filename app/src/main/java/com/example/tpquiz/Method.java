package com.example.tpquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Method {
    Intent intent;
    int count = 0;
    TextView reponse;
    JSON json;
    Chronometer chronometer;
    Context ctx;

    public Method(){}

    public Method(TextView reponse, JSON json, Chronometer chronometer, Context ctx){
        this.reponse = reponse;
        this.json = json;
        this.chronometer = chronometer;
        this.ctx = ctx;
    }

    public void isPressed(Chronometer chronometer, Context ctx) {
        if (ctx instanceof Q1) {
            intent = new Intent(ctx, Q2.class);
        } else if (ctx instanceof Q2) {
            intent = new Intent(ctx, Q3.class);
        } else if (ctx instanceof Q3) {
            intent = new Intent(ctx, Score.class);
        } else if (ctx instanceof Score){
            intent = new Intent(ctx, MainActivity.class);
        }
        chronometer.setOnChronometerTickListener(f -> {
            count++;
            if (count == 2) {
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                ctx.startActivity(intent);
                count = 0;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void onClick(Button b, TextView reponse, Chronometer chronometer, Context ctx, JSON json) {
        b.setOnClickListener(e -> {
            reponse.setText("c'est effectivement " + json.getTemp() + " !");
            chronometer.start();
            isPressed(chronometer, ctx);
        });
    }
}