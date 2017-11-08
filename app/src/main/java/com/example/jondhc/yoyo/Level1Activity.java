package com.example.jondhc.yoyo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Level1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        // Hide ActionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
