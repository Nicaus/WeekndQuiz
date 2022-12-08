package com.example.tpquiz;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.widget.Chronometer;

public class Method {
    Intent intent;
    int count = 0;

    public void isPressed(Chronometer chronometer, Context ctx) {
        if (ctx instanceof Q1) {
            intent = new Intent(ctx, Q2.class);
        } else if (ctx instanceof Q2) {
            intent = new Intent(ctx, Q3.class);
        } else if (ctx instanceof Q3) {
            intent = new Intent(ctx, Q1.class);
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
}