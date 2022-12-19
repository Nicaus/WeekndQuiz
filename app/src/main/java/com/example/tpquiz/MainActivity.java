package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.start);
        textView = findViewById(R.id.textView4);

        button.setOnClickListener(e ->{
            Intent intent = new Intent(MainActivity.this, Q1.class);
            startActivity(intent);
        });

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator oa = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, 360);
        ObjectAnimator o1 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, -360);
        ObjectAnimator o2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_X, 0);
        set.playSequentially(oa, o1, o2);
        set.setDuration(500);

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                set.start();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });
        set.start();

    }
}