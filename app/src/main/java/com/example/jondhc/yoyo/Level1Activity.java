package com.example.jondhc.yoyo;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class Level1Activity extends AppCompatActivity {

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

        //Adding drag and drop functionality
        View berry1 = findViewById(R.id.berry1);
        berry1.setOnTouchListener(new DragTouchListener());
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
                return true;
            }//end if
            else {
                return false;
            }
        }   //end onTouch
    } //end DragTouchListener



}
