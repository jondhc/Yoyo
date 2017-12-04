package com.example.jondhc.yoyo;


import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LevelJulio extends AppCompatActivity {
    public int numero1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar
//setContentView(R.layout.activity);

        setContentView(R.layout.activity_level_julio);
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
                                                        ImageButton6.setVisibility(View.INVISIBLE);

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


