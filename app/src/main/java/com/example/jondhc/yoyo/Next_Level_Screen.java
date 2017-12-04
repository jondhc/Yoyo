package com.example.jondhc.yoyo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Next_Level_Screen extends AppCompatActivity {

    private GlobalApplication mApp;
    private Characters selectedC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_next__level__screen);
        mApp = ((GlobalApplication) getApplicationContext());
        selectedC = mApp.getGlobalVarValue();
        //Hiding the status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //end of Hiding the status bar

        //Hiding action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        //End of hiding action bar

        Button next_button = (Button) findViewById(R.id.next);
        mApp.getStatutLevels().saveData(this, selectedC, mApp.getUser());
        next_button.setOnClickListener(new View.OnClickListener() { //Setting action when next is touched
            @Override
            public void onClick(View v) {
                Intent returntoselection = new Intent(Next_Level_Screen.this, LevelSelectionActivity.class); //Start next activity, change with correct level
                startActivity(returntoselection);
            }
        });//end setOnClickListener
    }
}
