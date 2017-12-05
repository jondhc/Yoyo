package com.example.jondhc.yoyo;


import android.content.Intent;
import android.media.MediaPlayer;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;


public class LevelJulio extends AppCompatActivity {
    public int numero1;

    private GlobalApplication mApp;
    private Characters selectedC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mApp = ((GlobalApplication) getApplicationContext());
        selectedC = mApp.getGlobalVarValue();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar
//setContentView(R.layout.activity);

        setContentView(R.layout.activity_level_julio);

        ImageView character;
        if (selectedC == Characters.CAT) {
            character = (ImageView) findViewById(R.id.imageViewg1);    //Getting cat image
            GlideApp.with(this).load(R.drawable.buzogato).into(character);
        } else if (selectedC == Characters.DOG) {
            character = (ImageView) findViewById(R.id.imageViewg2);    //Getting dog image
            GlideApp.with(this).load(R.drawable.dog).into(character);
        }

        View button2 = (View) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
            }
        });
        View button3 = (View) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
            }
        });
        View button1 = (View) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.uno);    //set the audio to selected audio
                mpName.start();
                View ImageButton1 = (View) findViewById(R.id.imageButton1);
                ImageButton1.setVisibility(View.INVISIBLE);
                View button2 = (View) findViewById(R.id.button2);
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.dos);    //set the audio to selected audio
                        mpName.start();
                        View ImageButton2 = (View) findViewById(R.id.imageButton2);
                        ImageButton2.setVisibility(View.INVISIBLE);
                        View button3 = (View) findViewById(R.id.button3);
                        button3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                v.setVisibility(View.INVISIBLE);
                                MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.tres);    //set the audio to selected audio
                                mpName.start();
                                View ImageButton3 = (View) findViewById(R.id.imageButton3);
                                ImageButton3.setVisibility(View.INVISIBLE);
                                View button4 = (View) findViewById(R.id.button4);
                                button4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        v.setVisibility(View.INVISIBLE);
                                        MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.cuatro);    //set the audio to selected audio
                                        mpName.start();
                                        View ImageButton4 = (View) findViewById(R.id.imageButton4);
                                        ImageButton4.setVisibility(View.INVISIBLE);
                                        View button5 = (View) findViewById(R.id.button5);
                                        button5.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                v.setVisibility(View.INVISIBLE);
                                                MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.cinco);    //set the audio to selected audio
                                                mpName.start();
                                                View ImageButton5 = (View) findViewById(R.id.imageButton5);
                                                ImageButton5.setVisibility(View.INVISIBLE);
                                                View button6 = (View) findViewById(R.id.button6);
                                                button6.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        v.setVisibility(View.INVISIBLE);
                                                        MediaPlayer mpName = MediaPlayer.create(getApplicationContext(), R.raw.seis);    //set the audio to selected audio
                                                        mpName.start();
                                                        View ImageButton6 = (View) findViewById(R.id.imageButton6);
                                                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.hooray);   //set audio to user-won audio
                                                        winning.start();
                                                        ImageButton6.setVisibility(View.INVISIBLE);
                                                        mApp.getStatutLevels().statut_levels.put(Levels.LILY,3);
                                                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,-1);
                                                        new java.util.Timer().schedule(
                                                                new java.util.TimerTask() {
                                                                    @Override
                                                                    public void run() {
                                                                        Intent nextLvScreen = new Intent(LevelJulio.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                                                        startActivity(nextLvScreen);
                                                                    }
                                                                }, 900);
                                                    }
                                                });
                                            }
                                        });

                                    }
                                });


                            }
                        });

                    }
                });

            }
        });


    }
}


