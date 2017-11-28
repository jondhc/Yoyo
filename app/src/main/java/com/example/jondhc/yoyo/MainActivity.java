package com.example.jondhc.yoyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.jondhc.yoyo.Characters.CAT;

public class MainActivity extends AppCompatActivity {

    Button playBtnCat; //Initializing Cat Play Button
    Button playBtnDog; //Initializing Dog Play Button
    GlobalApplication mApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = ((GlobalApplication)getApplicationContext());
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        playBtnCat = (Button) findViewById(R.id.playButtonCat);   //Detect the play button
        playBtnCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
        playBtnDog = (Button) findViewById(R.id.playButtonDog);   //Detect the play button
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
