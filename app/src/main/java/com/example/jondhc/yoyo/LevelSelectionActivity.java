package com.example.jondhc.yoyo;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LevelSelectionActivity extends AppCompatActivity {

    public static void  setLocked(ImageView v)
    {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);  //0 means grayscale
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        //v.setImageAlpha(128);   // 128 = 0.5
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Initializing hashmap for levels
        LocalData statut_levels = new LocalData();
        // Used to see which level is next
        Levels next = null;

        // Only for debugging, should be set up with data linkage
        next = Levels.LILY;
        statut_levels.statut_levels.put(Levels.BRIDGE, true);
        statut_levels.statut_levels.put(Levels.VEGETABLES, true);

        int width, height, bck_width, bck_height;
        setContentView(R.layout.activity_level_selection);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        // Hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
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
        GlideApp.with(this).load(R.drawable.lselection_background).override(bck_width, bck_height).into(view_bck);

        // Initializing character view
        ImageView view_character = (ImageView) findViewById(R.id.character);
        view_character.bringToFront();

        // Vegetables
        ImageView view_lvvegetables = (ImageView) findViewById(R.id.lvvegetables);
        view_lvvegetables.setX((float) (bck_width * 0.62));
        view_lvvegetables.setY((float) (bck_height * 0.58));
        // Vegetables is completed
        if (statut_levels.statut_levels.get(Levels.VEGETABLES) || next == Levels.VEGETABLES) {
            // We done vegetables or vegetables is next, we can do the level
            view_lvvegetables.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity, change with correct level
                    startActivity(playI);
                }
            });
            // Vegetables is next level, we draw fog of war
            if (next == Levels.VEGETABLES) {
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width * 0.47));
                view_character.setY((float) (bck_height * 0.548));
                width = (int) (0.2 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
            }
            // Vegetables is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.VEGETABLES)) {
                ImageView  view_lvvegetables_flag = (ImageView) findViewById(R.id.lvvegetables_flag);
                view_lvvegetables_flag.setX((float) (bck_width * 0.64));
                view_lvvegetables_flag.setY((float) (bck_height * 0.575));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvvegetables_flag);
            }
        } else {
            setLocked(view_lvvegetables);
        }

        // if we put other values, like 18, it doesn't work. Reason why is black magic
        width = (int) (0.25 * bck_width);
        height = width;
        if (next == Levels.VEGETABLES){
            // Glowing
            ImageView view_lvvegetables_glow = (ImageView) findViewById(R.id.lvvegetablesglow);
            view_lvvegetables_glow.setX((float) (bck_width * 0.62));
            view_lvvegetables_glow.setY((float) (bck_height * 0.58));
            GlideApp.with(this).load(R.drawable.lvl_vegetables_glow).override(width,height).into(view_lvvegetables_glow);
        }
            GlideApp.with(this).load(R.drawable.lvl_vegetables).override(width,height).into(view_lvvegetables);

        // Bridge
        ImageView view_lvbridge = (ImageView) findViewById(R.id.lvbridge);
        view_lvbridge.setX((float) (bck_width*0.27));
        view_lvbridge.setY((float) (bck_height*0.69));
        // Bridge is completed
        if(statut_levels.statut_levels.get(Levels.BRIDGE) || next == Levels.BRIDGE){
            // We done bridge or bridge is next, we can do the level
            view_lvbridge.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity
                startActivity(playI);
                }
            });
            // Bridge is next level, we draw fog of war
            if(next == Levels.BRIDGE){
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width*0.61));
                view_character.setY((float) (bck_height*0.65));
                width = (int) (0.2*bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.cat).override(width,height).into(view_character);
            }
            // Bridge is done, if for debug but could be an else
            if(statut_levels.statut_levels.get(Levels.BRIDGE)) {
                ImageView view_lvbridge_flag = (ImageView) findViewById(R.id.lvbridge_flag);
                view_lvbridge_flag.setX((float) (bck_width * 0.52));
                view_lvbridge_flag.setY((float) (bck_height * 0.676));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvbridge_flag);
            }
        }
        else{
            setLocked(view_lvbridge);
        }
        width = (int) (0.5*bck_width);
        height = (int) (width*0.52461);
        if(next == Levels.BRIDGE) {
            // Glowing
            ImageView view_lvbridge_glow = (ImageView) findViewById(R.id.lvbridgeglow);
            view_lvbridge_glow.setX((float) (bck_width*0.27));
            view_lvbridge_glow.setY((float) (bck_height*0.69));
            GlideApp.with(this).load(R.drawable.lvl_bridge_glow).override(width,height).into(view_lvbridge_glow);
        }

            GlideApp.with(this).load(R.drawable.lvl_bridge).override(width,height).into(view_lvbridge);


        // Lily
        ImageView view_lvlily = (ImageView) findViewById(R.id.lvlily);
        view_lvlily.setX((float) (bck_width*0.45));
        view_lvlily.setY((float) (bck_height*0.747));
        // Lily is completed
        if(statut_levels.statut_levels.get(Levels.LILY) || next == Levels.LILY){
            // We done lily or lily is next, we can do the level
            view_lvlily.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity
                    startActivity(playI);
                }
            });
            // Lily is next level, we draw character
            if(next == Levels.LILY){
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width*0.30));
                view_character.setY((float) (bck_height*0.715));
                width = (int) (0.2*bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.cat).override(width,height).into(view_character);
            }
            // Lily is done, if for debug but could be an else
            if(statut_levels.statut_levels.get(Levels.LILY)) {
                ImageView view_lvlily_flag = (ImageView) findViewById(R.id.lvlilyflag);
                view_lvlily_flag.setX((float) (bck_width * 0.55));
                view_lvlily_flag.setY((float) (bck_height * 0.731));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvlily_flag);
            }
        }
        else{
            setLocked(view_lvlily);
        }

        if(next == Levels.LILY) {
            // Glowing
            // Black Magic
            width = (int) (0.31*bck_width);
            height = width;
            ImageView view_lvlily_glow = (ImageView) findViewById(R.id.lvlilyglow);
            view_lvlily_glow.setX((float) (bck_width*0.395));
            view_lvlily_glow.setY((float) (bck_height*0.735));
            GlideApp.with(this).load(R.drawable.lvl_lily_glow).override(width,height).into(view_lvlily_glow);
        }

        width = (int) (0.2*bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.lvl_lily).override(width,height).into(view_lvlily);

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
