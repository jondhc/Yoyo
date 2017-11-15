package com.example.jondhc.yoyo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class LevelVegetables extends Activity {
    int cuenta_frutas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random randomGenerator = new Random();
        int maxFrutas = 3;
        int minFrutas = 1;
        int range = maxFrutas - minFrutas + 1;
        int escoge_frutas = randomGenerator.nextInt(range)+1;
        System.out.println("Frutas para escoger="+escoge_frutas);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar
        setContentView(R.layout.activity_level_vegetables);

        TextView count = findViewById(R.id.tecst);
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
        View lechuga4 = findViewById(R.id.lechuga4);
        View potato4 = findViewById(R.id.potato4);
        View tomato4 = findViewById(R.id.tomato4);



        switch (escoge_frutas){
            case 1:
                lechuga4.setVisibility(View.VISIBLE);
                break;
            case 2:
                potato4.setVisibility(View.VISIBLE);
                break;
            case 3:
                tomato4.setVisibility(View.VISIBLE);
                break;
        }


        lechuga1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));

            }
        });
        lechuga2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        lechuga3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        potato1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        potato2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        potato3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        tomato1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        tomato2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
        tomato3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.setVisibility(View.INVISIBLE);
                cuenta_frutas++;
                TextView count = (TextView) findViewById(R.id.tecst);
                count.setText(String.valueOf(cuenta_frutas));
            }
        });
    }
}
