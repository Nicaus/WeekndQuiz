package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static java.sql.Types.NULL;

public class Score extends AppCompatActivity {

    Button recommencer;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        recommencer = findViewById(R.id.recommencer);
        textView = findViewById(R.id.titrescore);

        recommencer.setOnClickListener(r->{
            Intent intent = new Intent(Score.this, MainActivity.class);
            startActivity(intent);
        });

        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, (275));
        ObjectAnimator ax = ObjectAnimator.ofFloat(recommencer, View.SCALE_X, 1);
        ObjectAnimator ay = ObjectAnimator.ofFloat(recommencer, View.SCALE_Y, 1);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ax, ay);
        set.setDuration(1000);
        set.start();
        animator.start();
    }
}