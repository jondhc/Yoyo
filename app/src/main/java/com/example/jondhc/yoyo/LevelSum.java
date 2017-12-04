package com.example.jondhc.yoyo;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LevelSum extends AppCompatActivity {

    public int muestraglobos;


    private GlobalApplication mApp;
    private Characters selectedC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_level_sum);
        mApp = ((GlobalApplication) getApplicationContext());
        selectedC = mApp.getGlobalVarValue();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ImageView character;
        if (selectedC == Characters.CAT) {
            character = (ImageView) findViewById(R.id.cat_sky);    //Getting cat image
            GlideApp.with(this).load(R.drawable.cat).into(character);
        } else if (selectedC == Characters.DOG) {
            character = (ImageView) findViewById(R.id.dog_sky);    //Getting dog image
            GlideApp.with(this).load(R.drawable.dog).into(character);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        Random randomGenerator = new Random();  //Random generator for fruits number
        int maxGlobos = 6;  //Maximum Number of fruits to display
        int minGlobos = 1;  //Minimum number of fruits to display
        int range = maxGlobos - minGlobos + 1;  //Range of fruits to be generated randomly
        muestraglobos = randomGenerator.nextInt(range) + minGlobos;  //Setting number between the range
        System.out.println("Cantidad de Globos: " + muestraglobos);  //Printing to console the number of fruits to display

        View globo1 = findViewById(R.id.airballon_sky);
        View globo2 = findViewById(R.id.airballon2_sky);
        View globo3 = findViewById(R.id.airballon3_sky);
        View globo4 = findViewById(R.id.airballon4_sky);
        View globo5 = findViewById(R.id.airballon5_sky);
        View globo6 = findViewById(R.id.airballon6_sky);

        View num1c1 = findViewById(R.id.num1caso1_sky);
        View num2c1 = findViewById(R.id.num2caso1_sky);
        View num6c1 = findViewById(R.id.num6caso1_sky);
        View num4c2 = findViewById(R.id.num4caso2_sky);
        View num2c2 = findViewById(R.id.num2caso2_sky);
        View num3c2 = findViewById(R.id.num3caso2_sky);
        View num4c3 = findViewById(R.id.num4caso3_sky);
        View num2c3 = findViewById(R.id.num2caso3_sky);
        View num5c3 = findViewById(R.id.num5caso3_sky);
        View num1c4 = findViewById(R.id.num1caso4_sky);
        View num3c4 = findViewById(R.id.num3caso4_sky);
        View num4c4 = findViewById(R.id.num4caso4_sky);
        View num1c5 = findViewById(R.id.num1caso5_sky);
        View num2c5 = findViewById(R.id.num2caso5_sky);
        View num5c5 = findViewById(R.id.num5caso5_sky);
        View num6c6 = findViewById(R.id.num6caso6_sky);
        View num2c6 = findViewById(R.id.num2caso6_sky);
        View num1c6 = findViewById(R.id.num1caso6_sky);


        switch (muestraglobos) {
            case 1:
                globo2.setVisibility(View.VISIBLE);
                globo2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num1c1.setVisibility(View.VISIBLE);
                num1c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                num2c1.setVisibility(View.VISIBLE);
                num2c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num6c1.setVisibility(View.VISIBLE);
                num6c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });

                break;
            case 2:
                globo1.setVisibility(View.VISIBLE);
                globo1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo3.setVisibility(View.VISIBLE);
                globo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num4c2.setVisibility(View.VISIBLE);
                num4c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num2c2.setVisibility(View.VISIBLE);
                num2c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                num3c2.setVisibility(View.VISIBLE);
                num3c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                break;
            case 3:
                globo1.setVisibility(View.VISIBLE);
                globo1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo2.setVisibility(View.VISIBLE);
                globo2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo3.setVisibility(View.VISIBLE);
                globo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num1c4.setVisibility(View.VISIBLE);
                num1c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num3c4.setVisibility(View.VISIBLE);
                num3c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                num4c4.setVisibility(View.VISIBLE);
                num4c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                break;
            case 4:
                globo1.setVisibility(View.VISIBLE);
                globo1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo3.setVisibility(View.VISIBLE);
                globo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo4.setVisibility(View.VISIBLE);
                globo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo6.setVisibility(View.VISIBLE);
                globo6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num4c3.setVisibility(View.VISIBLE);
                num4c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                num2c3.setVisibility(View.VISIBLE);
                num2c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num5c3.setVisibility(View.VISIBLE);
                num5c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                break;
            case 5:
                globo1.setVisibility(View.VISIBLE);
                globo1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo2.setVisibility(View.VISIBLE);
                globo2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo3.setVisibility(View.VISIBLE);
                globo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo4.setVisibility(View.VISIBLE);
                globo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo5.setVisibility(View.VISIBLE);
                globo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num1c5.setVisibility(View.VISIBLE);
                num1c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num2c5.setVisibility(View.VISIBLE);
                num2c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num5c5.setVisibility(View.VISIBLE);
                num5c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                break;
            case 6:
                globo1.setVisibility(View.VISIBLE);
                globo1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo2.setVisibility(View.VISIBLE);
                globo2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo3.setVisibility(View.VISIBLE);
                globo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo4.setVisibility(View.VISIBLE);
                globo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo5.setVisibility(View.VISIBLE);
                globo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                globo6.setVisibility(View.VISIBLE);
                globo6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //v.setVisibility(View.INVISIBLE);

                    }
                });
                num6c6.setVisibility(View.VISIBLE);
                num6c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        System.out.println("se selecciono el correcto");
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);   //set audio to user-won audio
                        winning.start();
                        mApp.getStatutLevels().statut_levels.put(Levels.GLOBO,3);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        Intent nextLvScreen = new Intent(LevelSum.this, Next_Level_Screen.class); //Start next activity, change with correct level
                                        startActivity(nextLvScreen);
                                    }
                                }, 900);

                    }
                });
                num1c6.setVisibility(View.VISIBLE);
                num1c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                num2c6.setVisibility(View.VISIBLE);
                num2c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setVisibility(View.INVISIBLE);
                        MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.retry);   //set audio to user-won audio
                        winning.start();

                    }
                });
                break;
        }


    }


}



