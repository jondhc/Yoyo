package com.example.jondhc.yoyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button playBtn; //Initializing Play Button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View decorView = getWindow().getDecorView();
        //int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        //decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.playButton);   //Detect the play button
        playBtn.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
    }
}
