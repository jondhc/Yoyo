package com.example.jondhc.yoyo;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class LevelSelectionActivity extends AppCompatActivity {
    Button backBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int width,height,bck_width,bck_height;
        setContentView(R.layout.activity_level_selection);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        // Hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        // Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Background
        ImageView view_bck = (ImageView) findViewById(R.id.lvbackgroundimg);
        bck_width = size.x;
        double temp = bck_width * 4.5312;
        bck_height = (int) temp;
        GlideApp.with(this).load(R.drawable.lselection_background).override(bck_width,bck_height).into(view_bck);

        // Bridge
        ImageView view_lvbridge = (ImageView) findViewById(R.id.lvbridge);
        view_lvbridge.setX((float) (bck_width*0.26));
        view_lvbridge.setY((float) (bck_height*0.69));
        width = (int) (0.5*bck_width);
        height = (int) (width*0.52461);
        GlideApp.with(this).load(R.drawable.lvs_bridge).override(width,height).into(view_lvbridge);
        view_lvbridge.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity
                startActivity(playI);
            }
        });


        /*backBtn = (Button) findViewById(R.id.backButton);
        exitBtn = (Button) findViewById(R.id.exitButton);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backI = new Intent(LevelSelectionActivity.this, MainActivity.class);
                startActivity(backI);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
