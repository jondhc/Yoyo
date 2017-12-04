package com.example.jondhc.yoyo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class LevelSelectionActivity extends AppCompatActivity {

    //  Initializing hashmap for levels
    private LocalData statut_levels = new LocalData();
    private GlobalApplication mApp;
    private Characters selectedC;
    private NestedScrollView scrollView;
    private ImageView view_character;

    private static void setLocked(ImageView v) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);  //0 means grayscale
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        //v.setImageAlpha(128);   // 128 = 0.5
    }

    private void scrollToCharDelay() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        scrollView.scrollTo((int) view_character.getX(), (int) view_character.getY());
                    }
                }, 450);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mApp = ((GlobalApplication) getApplicationContext());
        selectedC = mApp.getGlobalVarValue();
        statut_levels.loadData(this, selectedC, mApp.getUser());

        // Only for debugging, should be set up with data linkage
        statut_levels.statut_levels.put(Levels.VEGETABLES, 3);
        statut_levels.statut_levels.put(Levels.TREE, 3);
        statut_levels.statut_levels.put(Levels.BRIDGE, 0);
        statut_levels.statut_levels.put(Levels.LILY, 3);
        statut_levels.statut_levels.put(Levels.GLOBO, -1);


        int width, height, bck_width, bck_height;
        setContentView(R.layout.activity_level_selection);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        // Hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        scrollView = (NestedScrollView) findViewById(R.id.lvselectionscroll);

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
        view_character = (ImageView) findViewById(R.id.character);
        view_character.bringToFront();

        // Vegetables
        ImageView view_lvvegetables = (ImageView) findViewById(R.id.lvvegetables);
        view_lvvegetables.setX((float) (bck_width * 0.17));
        view_lvvegetables.setY((float) (bck_height * 0.49));
        // Vegetables is completed
        if (statut_levels.statut_levels.get(Levels.VEGETABLES) > 0 || statut_levels.statut_levels.get(Levels.VEGETABLES) == -1) {
            // We done vegetables or vegetables is next, we can do the level
            view_lvvegetables.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, LevelVegetables.class); //Start next activity, change with correct level
                    startActivity(playI);
                }
            });
            // Vegetables is next level, we draw fog of war
            if (statut_levels.statut_levels.get(Levels.VEGETABLES) == -1) {
                // We will have to make another if to setup the glowing
                // Draw character
                view_character.setX((float) (bck_width * 0.31));
                view_character.setY((float) (bck_height * 0.455));
                width = (int) (0.2 * bck_width);
                height = width;
                if (selectedC == Characters.CAT)
                    GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
                else if (selectedC == Characters.DOG)
                    GlideApp.with(this).load(R.drawable.dog).override(width, height).into(view_character);
            }
            // Vegetables is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.VEGETABLES) > 0) {
                ImageView view_lvvegetables_flag = (ImageView) findViewById(R.id.lvvegetables_flag);
                view_lvvegetables_flag.setX((float) (bck_width * 0.2));
                view_lvvegetables_flag.setY((float) (bck_height * 0.4835));
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
        if (statut_levels.statut_levels.get(Levels.VEGETABLES) == -1) {
            // Glowing
            ImageView view_lvvegetables_glow = (ImageView) findViewById(R.id.lvvegetablesglow);
            view_lvvegetables_glow.setX((float) (bck_width * 0.17));
            view_lvvegetables_glow.setY((float) (bck_height * 0.49));
            GlideApp.with(this).load(R.drawable.lvl_vegetables_glow).override(width, height).into(view_lvvegetables_glow);
        }
        GlideApp.with(this).load(R.drawable.lvl_vegetables).override(width, height).into(view_lvvegetables);


        // Tree
        ImageView view_lvtree = (ImageView) findViewById(R.id.lvtree);
        view_lvtree.setX((float) (bck_width * 0.57));
        view_lvtree.setY((float) (bck_height * 0.56));
        // Tree is completed
        if (statut_levels.statut_levels.get(Levels.TREE) > 0 || statut_levels.statut_levels.get(Levels.TREE) == -1) {
            // We done tree or tree is next, we can do the level
            view_lvtree.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity, change with correct level
                    startActivity(playI);
                }
            });
            // Tree is next level, we draw fog of war
            if (statut_levels.statut_levels.get(Levels.TREE) == -1) {
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width * 0.47));
                view_character.setY((float) (bck_height * 0.548));
                width = (int) (0.2 * bck_width);
                height = width;
                if (selectedC == Characters.CAT)
                    GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
                else if (selectedC == Characters.DOG)
                    GlideApp.with(this).load(R.drawable.dog).override(width, height).into(view_character);
            }
            // Tree is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.TREE) > 0) {
                ImageView view_lvtree_flag = (ImageView) findViewById(R.id.lvtreeflag);
                view_lvtree_flag.setX((float) (bck_width * 0.645));
                view_lvtree_flag.setY((float) (bck_height * 0.565));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvtree_flag);
            }
        } else {
            setLocked(view_lvtree);
        }

        width = (int) (0.37 * bck_width);
        height = width;
        if (statut_levels.statut_levels.get(Levels.TREE) == -1) {
            // Glowing
            ImageView view_lvtree_glow = (ImageView) findViewById(R.id.lvtreeglow);
            view_lvtree_glow.setX((float) (bck_width * 0.62));
            view_lvtree_glow.setY((float) (bck_height * 0.58));
            GlideApp.with(this).load(R.drawable.lvl_tree_glow).override(width, height).into(view_lvtree_glow);
        }
        GlideApp.with(this).load(R.drawable.lvl_tree).override(width, height).into(view_lvtree);


        // Bridge
        ImageView view_lvbridge = (ImageView) findViewById(R.id.lvbridge);
        view_lvbridge.setX((float) (bck_width * 0.27));
        view_lvbridge.setY((float) (bck_height * 0.69));
        // Bridge is completed
        if (statut_levels.statut_levels.get(Levels.BRIDGE) > 0 || statut_levels.statut_levels.get(Levels.BRIDGE) == -1) {
            // We done bridge or bridge is next, we can do the level
            view_lvbridge.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, LevelVegetables.class); //Start next activity
                    startActivity(playI);
                }
            });
            // Bridge is next level, we draw fog of war
            if (statut_levels.statut_levels.get(Levels.BRIDGE) == -1) {
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width * 0.61));
                view_character.setY((float) (bck_height * 0.65));
                width = (int) (0.2 * bck_width);
                height = width;
                if (selectedC == Characters.CAT)
                    GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
                else if (selectedC == Characters.DOG)
                    GlideApp.with(this).load(R.drawable.dog).override(width, height).into(view_character);
            }
            // Bridge is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.BRIDGE) > 0) {
                ImageView view_lvbridge_flag = (ImageView) findViewById(R.id.lvbridgeflag);
                view_lvbridge_flag.setX((float) (bck_width * 0.52));
                view_lvbridge_flag.setY((float) (bck_height * 0.676));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvbridge_flag);
            }
        } else {
            setLocked(view_lvbridge);
        }
        width = (int) (0.5 * bck_width);
        height = (int) (width * 0.52461);
        if (statut_levels.statut_levels.get(Levels.BRIDGE) == -1) {
            // Glowing
            ImageView view_lvbridge_glow = (ImageView) findViewById(R.id.lvbridgeglow);
            view_lvbridge_glow.setX((float) (bck_width * 0.27));
            view_lvbridge_glow.setY((float) (bck_height * 0.69));
            GlideApp.with(this).load(R.drawable.lvl_bridge_glow).override(width, height).into(view_lvbridge_glow);
        }

        GlideApp.with(this).load(R.drawable.lvl_bridge).override(width, height).into(view_lvbridge);


        // Lily
        ImageView view_lvlily = (ImageView) findViewById(R.id.lvlily);
        view_lvlily.setX((float) (bck_width * 0.395));
        view_lvlily.setY((float) (bck_height * 0.735));
        // Lily is completed
        if (statut_levels.statut_levels.get(Levels.LILY) > 0 || statut_levels.statut_levels.get(Levels.LILY) == -1) {
            // We done lily or lily is next, we can do the level
            view_lvlily.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, Level1Activity.class); //Start next activity
                    startActivity(playI);
                }
            });
            // Lily is next level, we draw character
            if (statut_levels.statut_levels.get(Levels.LILY) == -1) {
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width * 0.30));
                view_character.setY((float) (bck_height * 0.715));
                width = (int) (0.2 * bck_width);
                height = width;
                if (selectedC == Characters.CAT)
                    GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
                else if (selectedC == Characters.DOG)
                    GlideApp.with(this).load(R.drawable.dog).override(width, height).into(view_character);
            }
            // Lily is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.LILY) > 0) {
                ImageView view_lvlily_flag = (ImageView) findViewById(R.id.lvlilyflag);
                view_lvlily_flag.setX((float) (bck_width * 0.55));
                view_lvlily_flag.setY((float) (bck_height * 0.731));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvlily_flag);
            }
        } else {
            setLocked(view_lvlily);
        }

        width = (int) (0.31 * bck_width);
        height = width;

        if (statut_levels.statut_levels.get(Levels.LILY) == -1) {
            // Glowing

            ImageView view_lvlily_glow = (ImageView) findViewById(R.id.lvlilyglow);
            view_lvlily_glow.setX((float) (bck_width * 0.395));
            view_lvlily_glow.setY((float) (bck_height * 0.735));
            GlideApp.with(this).load(R.drawable.lvl_lily_glow).override(width, height).into(view_lvlily_glow);
        }
        GlideApp.with(this).load(R.drawable.lvl_lily).override(width, height).into(view_lvlily);

        // Globo
        ImageView view_lvglobo = (ImageView) findViewById(R.id.lvglobo);
        view_lvglobo.setX((float) (bck_width * 0.335));
        view_lvglobo.setY((float) (bck_height * 0.778));
        // Globo is completed
        if (statut_levels.statut_levels.get(Levels.GLOBO) > 0 || statut_levels.statut_levels.get(Levels.GLOBO) == -1) {
            // We done globo or globo is next, we can do the level
            view_lvglobo.setOnClickListener(new View.OnClickListener() { //Detect touch on button
                @Override
                public void onClick(View v) {
                    Intent playI = new Intent(LevelSelectionActivity.this, LevelSum.class); //Start next activity
                    startActivity(playI);
                }
            });
            // Globo is next level, we draw character
            if (statut_levels.statut_levels.get(Levels.GLOBO) == -1) {
                // We will have to make another if to setup the glowing

                // Draw character
                view_character.setX((float) (bck_width * 0.215));
                view_character.setY((float) (bck_height * 0.782));
                width = (int) (0.2 * bck_width);
                height = width;
                if (selectedC == Characters.CAT)
                    GlideApp.with(this).load(R.drawable.cat).override(width, height).into(view_character);
                else if (selectedC == Characters.DOG)
                    GlideApp.with(this).load(R.drawable.dog).override(width, height).into(view_character);
            }
            // Globo is done, if for debug but could be an else
            if (statut_levels.statut_levels.get(Levels.GLOBO) > 0) {
                ImageView view_lvglobo_flag = (ImageView) findViewById(R.id.lvgloboflag);
                view_lvglobo_flag.setX((float) (bck_width * 0.415));
                view_lvglobo_flag.setY((float) (bck_height * 0.775));
                width = (int) (0.1 * bck_width);
                height = width;
                GlideApp.with(this).load(R.drawable.flag).override(width, height).into(view_lvglobo_flag);
            }
        } else {
            setLocked(view_lvglobo);
        }

        width = (int) (0.33 * bck_width);
        height = width;

        if (statut_levels.statut_levels.get(Levels.GLOBO) == -1) {
            // Glowing

            ImageView view_lvglobo_glow = (ImageView) findViewById(R.id.lvgloboglow);
            view_lvglobo_glow.setX((float) (bck_width * 0.335));
            view_lvglobo_glow.setY((float) (bck_height * 0.778));
            GlideApp.with(this).load(R.drawable.lvl_globo_glow).override(width, height).into(view_lvglobo_glow);
        }
        GlideApp.with(this).load(R.drawable.lvl_globo).override(width, height).into(view_lvglobo);

        // scrollView.requestChildFocus(view_character,view_character);

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
        statut_levels.saveData(this, selectedC, mApp.getUser());
        scrollToCharDelay();
    }

    @Override
    protected void onResume() {
        super.onResume();
        statut_levels.saveData(this, selectedC, mApp.getUser());
        scrollView.scrollTo((int) view_character.getX(), (int) view_character.getY());
    }

    @Override
    protected void onStop() {
        super.onStop();
        statut_levels.saveData(this, selectedC, mApp.getUser());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public LocalData getStatut_levels() {
        return this.statut_levels;
    }
}
