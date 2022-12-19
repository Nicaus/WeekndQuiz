package com.example.tpquiz;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.toolbox.NetworkImageView;

public class Method {
    Intent intent;
    int count = 0;

    public Method(){}

    public void isPressed(Chronometer chronometer, Context ctx) {
        if (ctx instanceof Q1) {
            intent = new Intent(ctx, Q2.class);
        } else if (ctx instanceof Q2) {
            intent = new Intent(ctx, Q3.class);
        } else if (ctx instanceof Q3) {
            intent = new Intent(ctx, Score.class);
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

    public void animation(NetworkImageView niw){
        AnimatorSet as = new AnimatorSet();
        ObjectAnimator ao = ObjectAnimator.ofFloat(niw, View.ROTATION, 360);
        ObjectAnimator a2 = ObjectAnimator.ofFloat(niw, View.SCALE_X, 1);
        ObjectAnimator a3 = ObjectAnimator.ofFloat(niw, View.SCALE_Y, 1);
        as.playTogether(a2, a3);
        as.setDuration(500);
        ao.setDuration(500);
        a2.reverse();
        a3.reverse();
        as.start();
        ao.start();
    }

    public void wrong(Context ctx, Button b1, Button b2, Button b3){

        b1.setOnClickListener(e->{
            Toast.makeText(ctx, "Faux", Toast.LENGTH_SHORT).show();

        });
        b2.setOnClickListener(e->{
            Toast.makeText(ctx, "Faux", Toast.LENGTH_SHORT).show();

        });
        b3.setOnClickListener(e->{
            Toast.makeText(ctx, "Faux", Toast.LENGTH_SHORT).show();

        });
    }

    public void wrong(Context ctx, Button b){
        b.setOnClickListener(e->{
            Toast.makeText(ctx, "Faux", Toast.LENGTH_SHORT).show();

        });
    }

}