package com.example.jondhc.yoyo;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class LevelSum extends AppCompatActivity {

    public int muestraglobos;



    private GlobalApplication mApp;
    private Characters selectedC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_sum);
        mApp = ((GlobalApplication)getApplicationContext());
        selectedC = mApp.getGlobalVarValue();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ImageView character;
        if(selectedC == Characters.CAT) {
            character = (ImageView) findViewById(R.id.cat_sky);    //Getting cat image
            GlideApp.with(this).load(R.drawable.cat).into(character);
        }
        else if(selectedC == Characters.DOG) {
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


        switch (muestraglobos) {
            case 1:
                globo2.setVisibility(View.VISIBLE);
                break;
            case 2:
                globo1.setVisibility(View.VISIBLE);
                globo3.setVisibility(View.VISIBLE);
                break;
            case 3:
                globo1.setVisibility(View.VISIBLE);
                globo2.setVisibility(View.VISIBLE);
                globo3.setVisibility(View.VISIBLE);
                break;
            case 4:
                globo1.setVisibility(View.VISIBLE);
                globo3.setVisibility(View.VISIBLE);
                globo4.setVisibility(View.VISIBLE);
                globo6.setVisibility(View.VISIBLE);
                break;
            case 5:
                globo1.setVisibility(View.VISIBLE);
                globo2.setVisibility(View.VISIBLE);
                globo3.setVisibility(View.VISIBLE);
                globo4.setVisibility(View.VISIBLE);
                globo5.setVisibility(View.VISIBLE);
                break;
            case 6:
                globo1.setVisibility(View.VISIBLE);
                globo2.setVisibility(View.VISIBLE);
                globo3.setVisibility(View.VISIBLE);
                globo4.setVisibility(View.VISIBLE);
                globo5.setVisibility(View.VISIBLE);
                globo6.setVisibility(View.VISIBLE);
                break;
        }




    }






}



