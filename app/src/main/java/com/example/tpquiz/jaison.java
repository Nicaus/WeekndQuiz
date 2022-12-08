package com.example.tpquiz;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSON {

    public void jsoning() {
        jsonq2 = new JsonObjectRequest(Request.Method.GET, q2, null, response -> {
            try {
                temp = response.getString("release_date");
//                temp = array.getString("name");
                JSONArray image = response.getJSONArray("images");
                JSONObject imageo = image.getJSONObject(0);
                String imageurl = imageo.getString("url");
                niw.setImageUrl(imageurl, Singleton.getInstance(this.getApplicationContext()).getImageLoader());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, null) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                String token = sharedPreferences.getString("token", "");
                String auth = "Bearer " + token;
                headers.put("Authorization", auth);
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
    }
}
