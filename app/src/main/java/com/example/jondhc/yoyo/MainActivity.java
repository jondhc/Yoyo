package com.example.jondhc.yoyo;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.jondhc.yoyo.Characters.CAT;

public class MainActivity extends AppCompatActivity {

    GlobalApplication mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = ((GlobalApplication)getApplicationContext());
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        int width, height, bck_width, bck_height;
        // Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        bck_height = size.y;
        bck_width = size.x;

        ImageView textYoyo = (ImageView) findViewById(R.id.main_screen_text);
        textYoyo.setX((float) (bck_width * 0));
        textYoyo.setY((float) (bck_height * 0.1));
        width = (int) (1 * bck_width);
        height = (int) (width / 1.777778);
        GlideApp.with(this).load(R.drawable.yoyo).override(width,height).into(textYoyo);

        ImageView iconCat = (ImageView) findViewById(R.id.iconCat);
        iconCat.setX((float) (bck_width * 0.16));
        iconCat.setY((float) (bck_height * 0.39));
        width = (int) (0.25 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.cat).override(width,height).into(iconCat);
        iconCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView iconDog = (ImageView) findViewById(R.id.iconDog);
        iconDog.setX((float) (bck_width * 0.605));
        iconDog.setY((float) (bck_height * 0.4));
        width = (int) (0.25 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.dog).override(width,height).into(iconDog);
        iconDog.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.DOG);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView playBtnCat = (ImageView) findViewById(R.id.playButtonCat);
        playBtnCat.setX((float) (bck_width * 0.0));
        playBtnCat.setY((float) (bck_height * 0.47));
        width = (int) (0.55 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.play).override(width,height).into(playBtnCat);
        playBtnCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView playBtnDog = (ImageView) findViewById(R.id.playButtonDog);
        playBtnDog.setX((float) (bck_width * 0.43));
        playBtnDog.setY((float) (bck_height * 0.47));
        width = (int) (0.55 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.play).override(width,height).into(playBtnDog);
        playBtnDog.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.DOG);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
    }
}
