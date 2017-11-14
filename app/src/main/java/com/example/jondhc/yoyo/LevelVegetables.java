package com.example.jondhc.yoyo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelVegetables extends Activity {
    int cuenta_frutas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar
        setContentView(R.layout.activity_level_vegetables);

        TextView count = (TextView) findViewById(R.id.tecst);
        count.setText(String.valueOf(cuenta_frutas));

        View lechuga1 = findViewById(R.id.lechuga1);
        View lechuga2 = findViewById(R.id.lechuga2);
        View lechuga3 = findViewById(R.id.lechuga3);
        View potato1 = findViewById(R.id.potato1);
        View potato2 = findViewById(R.id.potato2);
        View potato3 = findViewById(R.id.potato3);
        View tomato1 = findViewById(R.id.tomato1);
        View tomato2 = findViewById(R.id.tomato2);
        View tomato3 = findViewById(R.id.tomato3);

        lechuga1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        lechuga2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        lechuga3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        potato1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        potato2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        potato3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        tomato1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        tomato2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
        tomato3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
            }
        });
    }
}
