package com.example.jondhc.yoyo;

import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LevelSum extends AppCompatActivity {



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


    }






}



