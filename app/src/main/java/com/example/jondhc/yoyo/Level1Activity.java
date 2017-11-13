package com.example.jondhc.yoyo;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Level1Activity extends AppCompatActivity {

    int basket_counter = 0; //Counter for the fruits



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



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
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }



    private final class DragTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent){
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowbuiler = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowbuiler, view, 0);
                view.setVisibility(View.INVISIBLE);
                basket_counter += 1;
                TextView counter = (TextView) findViewById(R.id.count_of_fruits);
                counter.setText(String.valueOf(basket_counter));
                return true;
            }//end if
            else {
                return false;
            }//end else
        }   //end onTouch
    } //end DragTouchListener



}
