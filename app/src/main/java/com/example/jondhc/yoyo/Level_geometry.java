package com.example.jondhc.yoyo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Level_geometry extends AppCompatActivity {

    private int contador = 0;

    private GlobalApplication mApp;
    private Characters selectedC;
    private ImageView character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_geometry);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        mApp = ((GlobalApplication) getApplicationContext());
        selectedC = mApp.getGlobalVarValue();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        View circulo1 = findViewById(R.id.circulo_geo);
        View cuadrado1 = findViewById(R.id.cuadrado_geo);
        View rectangulo1 = findViewById(R.id.rectangulo_geo);
        View triangulo1 = findViewById(R.id.triangulo_geo);

        if (selectedC == Characters.CAT) {
            character = (ImageView) findViewById(R.id.cat_num);    //Getting cat image
            GlideApp.with(this).load(R.drawable.cat).into(character);
        } else if (selectedC == Characters.DOG) {
            character = (ImageView) findViewById(R.id.dog_num);    //Getting dog image
            GlideApp.with(this).load(R.drawable.dog).into(character);
        }

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
            //Animation of character
            RotateAnimation char_anim = new RotateAnimation(0f, 360f, character.getWidth() / 2, character.getHeight() / 2);
            char_anim.setInterpolator(new LinearInterpolator());
            char_anim.setRepeatCount(0);
            char_anim.setDuration(700);
            character.startAnimation(char_anim);
            mApp.getStatutLevels().statut_levels.put(Levels.BRIDGE,3);
            mApp.getStatutLevels().statut_levels.put(Levels.LILY,-1);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Intent nextLvScreen = new Intent(Level_geometry.this, Next_Level_Screen.class); //Start next activity, change with correct level
                            startActivity(nextLvScreen);
                        }
                    }, 900);
        }
    }
}
