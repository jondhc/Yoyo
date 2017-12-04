package com.example.jondhc.yoyo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Level_phone extends AppCompatActivity {

    //private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_phone);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        View num0s = findViewById(R.id.num0_num);
        View num1s = findViewById(R.id.num1_num);
        View num2s = findViewById(R.id.num2_num);
        View num3s = findViewById(R.id.num3_num);
        View num4s = findViewById(R.id.num4_num);
        View num5s = findViewById(R.id.num5_num);
        View num6s = findViewById(R.id.num6_num);
        View num7s = findViewById(R.id.num7_num);
        View num8s = findViewById(R.id.num8_num);
        View num9s = findViewById(R.id.num9_num);

        num0s.setVisibility(View.VISIBLE);
        num0s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num1s.setVisibility(View.VISIBLE);
        num1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num2s.setVisibility(View.VISIBLE);
        num2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num3s.setVisibility(View.VISIBLE);
        num3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num4s.setVisibility(View.VISIBLE);
        num4s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num5s.setVisibility(View.VISIBLE);
        num5s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num6s.setVisibility(View.VISIBLE);
        num6s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num7s.setVisibility(View.VISIBLE);
        num7s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

        num8s.setVisibility(View.VISIBLE);
        num8s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });
        num9s.setVisibility(View.VISIBLE);
        num9s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

            }
        });

    }
}

