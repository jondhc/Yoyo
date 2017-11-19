package com.example.jondhc.yoyo;

import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Level1Activity extends AppCompatActivity {

    int basket_counter = 0; //Counter for the fruits
    public int quantity;
    public View char_cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random randomGenerator = new Random();
        int maxFruits = 9;
        int minFruits = 1;
        int range = maxFruits - minFruits + 1;
        quantity = randomGenerator.nextInt(range) + minFruits;
        System.out.println("Cantidad de frutas: " + quantity);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();   // Hide ActionBar

        setContentView(R.layout.activity_level1);

        TextView counter = (TextView) findViewById(R.id.count_of_fruits);
        counter.setText(String.valueOf(basket_counter));

        //Adding drag and drop functionality
        View berry1 = findViewById(R.id.berry1);
        berry1.setOnTouchListener(new DragTouchListener());
        View berry2 = findViewById(R.id.berry2);
        berry2.setOnTouchListener(new DragTouchListener());
        View berry3 = findViewById(R.id.berry3);
        berry3.setOnTouchListener(new DragTouchListener());
        View berry4 = findViewById(R.id.berry4);
        berry4.setOnTouchListener(new DragTouchListener());
        View berry5 = findViewById(R.id.berry5);
        berry5.setOnTouchListener(new DragTouchListener());
        View berry6 = findViewById(R.id.berry6);
        berry6.setOnTouchListener(new DragTouchListener());
        View berry7 = findViewById(R.id.berry7);
        berry7.setOnTouchListener(new DragTouchListener());
        View berry8 = findViewById(R.id.berry8);
        berry8.setOnTouchListener(new DragTouchListener());
        View berry9 = findViewById(R.id.berry9);
        berry9.setOnTouchListener(new DragTouchListener());

        switch (quantity) {
            case 1:
                berry4.setVisibility(View.VISIBLE);
                break;
            case 2:
                berry6.setVisibility(View.VISIBLE);
                berry2.setVisibility(View.VISIBLE);
                break;
            case 3:
                berry4.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                break;
            case 4:
                berry1.setVisibility(View.VISIBLE);
                berry4.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry9.setVisibility(View.VISIBLE);
                break;
            case 5:
                berry1.setVisibility(View.VISIBLE);
                berry3.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry9.setVisibility(View.VISIBLE);
                break;
            case 6:
                berry1.setVisibility(View.VISIBLE);
                berry2.setVisibility(View.VISIBLE);
                berry3.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry8.setVisibility(View.VISIBLE);
                break;
            case 7:
                berry1.setVisibility(View.VISIBLE);
                berry2.setVisibility(View.VISIBLE);
                berry4.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry7.setVisibility(View.VISIBLE);
                berry9.setVisibility(View.VISIBLE);
                break;
            case 8:
                berry1.setVisibility(View.VISIBLE);
                berry2.setVisibility(View.VISIBLE);
                berry4.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry7.setVisibility(View.VISIBLE);
                berry8.setVisibility(View.VISIBLE);
                berry9.setVisibility(View.VISIBLE);
                break;
            case 9:
                berry1.setVisibility(View.VISIBLE);
                berry2.setVisibility(View.VISIBLE);
                berry3.setVisibility(View.VISIBLE);
                berry4.setVisibility(View.VISIBLE);
                berry5.setVisibility(View.VISIBLE);
                berry6.setVisibility(View.VISIBLE);
                berry7.setVisibility(View.VISIBLE);
                berry8.setVisibility(View.VISIBLE);
                berry9.setVisibility(View.VISIBLE);
                break;
        }


        View cat = findViewById(R.id.cat_catch);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer initialInstructions = MediaPlayer.create(getApplicationContext(), R.raw.instructions_g);
                initialInstructions.start();
            }
        });//end setOnClickListener
    }//end onCreate

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }//end onSupportNavigateUp

    class userWon extends TimerTask {
        public void run() {
            MediaPlayer winning = MediaPlayer.create(getApplicationContext(), R.raw.won);
            winning.start();
        }
    }


    private final class DragTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowbuiler = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowbuiler, view, 0);
                view.setVisibility(View.INVISIBLE);
                basket_counter += 1;
                TextView counter = (TextView) findViewById(R.id.count_of_fruits);
                counter.setText(String.valueOf(basket_counter));

                //Media player
                int audio = R.raw.one;
                switch (basket_counter) {
                    case 1:
                        audio = R.raw.one;
                        break;
                    case 2:
                        audio = R.raw.two;
                        break;
                    case 3:
                        audio = R.raw.three;
                        break;
                    case 4:
                        audio = R.raw.four;
                        break;
                    case 5:
                        audio = R.raw.five;
                        break;
                    case 6:
                        audio = R.raw.six;
                        break;
                    case 7:
                        audio = R.raw.seven;
                        break;
                    case 8:
                        audio = R.raw.eight;
                        break;
                    case 9:
                        audio = R.raw.nine;
                        break;
                }
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), audio);
                mp.start();
                if (basket_counter == quantity) {
                    Timer timer = new Timer();
                    timer.schedule(new userWon(), 1000);
                    //System.out.println("User won!");
                    char_cat = findViewById(R.id.cat_catch);
                    RotateAnimation char_anim = new RotateAnimation(0f, 360f, char_cat.getWidth() / 2, char_cat.getHeight() / 2);
                    char_anim.setInterpolator(new LinearInterpolator());
                    char_anim.setRepeatCount(0);
                    char_anim.setDuration(700);
                    char_cat.startAnimation(char_anim);

                }
                return true;
            }//end if
            else {
                return false;
            }//end else
        }//end onTouch
    } //end DragTouchListener


}
