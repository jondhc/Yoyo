package com.example.jondhc.yoyo;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Level_geometry extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_geometry);



        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        View circulo1 = findViewById(R.id.circulo_geo);
        View cuadrado1 = findViewById(R.id.cuadrado_geo);
        View rectangulo1 = findViewById(R.id.rectangulo_geo);
        View triangulo1 = findViewById(R.id.triangulo_geo);

        circulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mpcirculo = MediaPlayer.create(getApplicationContext(), R.raw.circulo);   //set audio to user-won audio
                mpcirculo.start();
                contador ++;
                if (contador == 4){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste(), 1000);    //Setting delay for audio
                }


                //v.setVisibility(View.INVISIBLE);

            }
        });

        cuadrado1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mpcuadrado = MediaPlayer.create(getApplicationContext(), R.raw.cuadrado);   //set audio to user-won audio
                mpcuadrado.start();
                contador ++;
                if (contador == 4){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste(), 1000);    //Setting delay for audio
                }
                //v.setVisibility(View.INVISIBLE);

            }
        });

        triangulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mptriangulo = MediaPlayer.create(getApplicationContext(), R.raw.triangulo);   //set audio to user-won audio
                mptriangulo.start();
                contador ++;
                if (contador == 4){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste(), 1000);    //Setting delay for audio
                }
                //v.setVisibility(View.INVISIBLE);

            }
        });

        rectangulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mprectangulo = MediaPlayer.create(getApplicationContext(), R.raw.rectangulo);   //set audio to user-won audio
                mprectangulo.start();
                contador ++;
                if (contador == 4){
                    Timer timer = new Timer();  //Timer for Winning audio to run
                    timer.schedule(new ganaste(), 1000);    //Setting delay for audio
                }
                //v.setVisibility(View.INVISIBLE);

            }
        });




    }

    class ganaste extends TimerTask {   //Runnable for congratulations action to be delayed
        public void run() {
            MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
            winning.start();    //Play audio
        }
    }
}
