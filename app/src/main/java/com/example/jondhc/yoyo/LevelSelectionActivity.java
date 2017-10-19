package com.example.jondhc.yoyo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LevelSelectionActivity extends AppCompatActivity {
    Button backBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



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

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
