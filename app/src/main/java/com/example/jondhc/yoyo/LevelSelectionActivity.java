package com.example.jondhc.yoyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LevelSelectionActivity extends AppCompatActivity {
    Button backBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        backBtn = (Button) findViewById(R.id.backButton);
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
        });
    }
}
