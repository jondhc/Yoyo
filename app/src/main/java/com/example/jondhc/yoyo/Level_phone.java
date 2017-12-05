package com.example.jondhc.yoyo;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Level_phone extends AppCompatActivity {

    private int contador = 0;

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
                MediaPlayer mp0 = MediaPlayer.create(getApplicationContext(), R.raw.cero);   //set audio to user-won audio
                mp0.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num1s.setVisibility(View.VISIBLE);
        num1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.uno);   //set audio to user-won audio
                mp1.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num2s.setVisibility(View.VISIBLE);
        num2s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.dos);   //set audio to user-won audio
                mp2.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num3s.setVisibility(View.VISIBLE);
        num3s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.tres);   //set audio to user-won audio
                mp3.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num4s.setVisibility(View.VISIBLE);
        num4s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.cuatro);   //set audio to user-won audio
                mp4.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num5s.setVisibility(View.VISIBLE);
        num5s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.cinco);   //set audio to user-won audio
                mp5.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num6s.setVisibility(View.VISIBLE);
        num6s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.seis);   //set audio to user-won audio
                mp6.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num7s.setVisibility(View.VISIBLE);
        num7s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.siete);   //set audio to user-won audio
                mp7.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

        num8s.setVisibility(View.VISIBLE);
        num8s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.ocho);   //set audio to user-won audio
                mp8.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });
        num9s.setVisibility(View.VISIBLE);
        num9s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.nueve);   //set audio to user-won audio
                mp9.start();
                contador ++;
                if (contador == 10){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste2(), 1000);    //Setting delay for audio
                }

            }
        });

    }

    class ganaste2 extends TimerTask {   //Runnable for congratulations action to be delayed
        public void run() {
            MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.hooray);   //set audio to user-won audio
            winning.start();    //Play audio
        }
    }
}

