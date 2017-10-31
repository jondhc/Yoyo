package com.example.jondhc.yoyo;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
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
        setContentView(R.layout.activity_level_selection);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        double temp = width * 4.5312;
        int height = (int) temp;
        View decorView = getWindow().getDecorView();

        ImageView iview = (ImageView) findViewById(R.id.lvbackgroundimg);
        GlideApp.with(this).load(R.drawable.lselection_background).override(width,height).into(iview);

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        //ActionBar actionBar = getActionBar();
        //actionBar.hide();

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
}
