package com.example.tpquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class Q3 extends AppCompatActivity {

    Singleton queue;
    String qt = "https://api.spotify.com/v1/albums/5EbpxRwbbpCJUepbqVTZ1U"; // Trilogy
    String qk = "https://api.spotify.com/v1/albums/3hhDpPtCFuQbppwYgsVhMO"; // Kissland
    String qb = "https://api.spotify.com/v1/albums/0P3oVJBFOv3TDXlYRhGL7s"; // Beauty Behind the Madness
    String qs = "https://api.spotify.com/v1/albums/2ODvWsOgouMbaA5xf0RkJe"; // STARBOY
    String qm = "https://api.spotify.com/v1/albums/4qZBW3f2Q8y0k1A84d4iAO"; // My Dear Melancholy,
    String qa = "https://api.spotify.com/v1/albums/4yP0hdKOZPNshxUOjY0cZj"; // After Hours
    String qd = "https://api.spotify.com/v1/albums/2nLOHgzXzwFEpl62zAgCEC"; // Dawn FM
    JsonObjectRequest jq3, jsonr1, jsonr2;
    JsonObjectRequest j11, j12, j21, j22, j31, j32, j41, j42, j51, j52;
    JSON json = new JSON();
    NetworkImageView niw1, niw2;
    Chronometer chronometer;
    Method method = new Method();

    TextView reponse, question;
    Button b1, b2;

    String tempa, tempb;
    boolean r = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);
        reponse = findViewById(R.id.q3reponse);
        niw1 = findViewById(R.id.image1);
        niw2 = findViewById(R.id.image2);
        question = findViewById(R.id.q3question);
        chronometer = findViewById(R.id.chrono3);
        b1 = findViewById(R.id.r1);
        b2 = findViewById(R.id.r2);

        String[] q3s = {"Kissland ou Trilogy", "Beauty Behind the Madness ou Starboy", "Starboy ou dawn fm", "My Dear Melancholy, ou Beauty Behind the Madness", "After Hours ou dawn fm"};
        String qstruct = "Quel album est plus populaire\n";
        int rand = new Random().nextInt(q3s.length);

        question.setText(qstruct + q3s[rand]);
        queue = Singleton.getInstance(this);

        if (rand == 0) {
            b1.setText("Kissland");
            b2.setText("Trilogy");
            j11 = json.jsoning(jq3, qk, niw1, this);
            j12 = json.jsoning(jq3, qt, niw2, this);
            queue.addToRequestQueue(j11);
            queue.addToRequestQueue(j12);
            method.onClick(b2, reponse, chronometer, this, json);
        } else if (rand == 1) {
            b1.setText("Beauty Behind the Madness");
            b2.setText("Starboy");
            j21 = json.jsoning(jq3, qb, niw1, this);
            j22 = json.jsoning(jq3, qs, niw2, this);
            queue.addToRequestQueue(j21);
            queue.addToRequestQueue(j22);
            method.onClick(b2, reponse, chronometer, this, json);
        } else if (rand == 2) {
            b1.setText("Starboy");
            b2.setText("dawn fm");
            j31 = json.jsoning(jq3, qs, niw1, this);
            j32 = json.jsoning(jq3, qd, niw2, this);
            queue.addToRequestQueue(j31);
            queue.addToRequestQueue(j32);
            method.onClick(b1, reponse, chronometer, this, json);
        } else if (rand == 3) {
            b1.setText("My Dear Melancholy,");
            b2.setText("Beauty Behind the Madness");
            j41 = json.jsoning(jq3, qm, niw1, this);
            j42 = json.jsoning(jq3, qb, niw2, this);
            queue.addToRequestQueue(j41);
            queue.addToRequestQueue(j42);
            method.onClick(b1, reponse, chronometer, this, json);
        } else if (rand == 4) {
            b1.setText("After Hours");
            b2.setText("dawn fm");
            j51 = json.jsoning(jq3, qa, niw1, this);
            j52 = json.jsoning(jq3, qd, niw2, this);
            queue.addToRequestQueue(j51);
            queue.addToRequestQueue(j52);
            method.onClick(b1, reponse, chronometer, this, json);
        }

    }
}