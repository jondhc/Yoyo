package com.example.jondhc.yoyo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelectionActivity extends AppCompatActivity {
    Button btnVolver, btnSalir;
    //Se puede, vaya que si
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        btnVolver = (Button)findViewById(R.id.btnVolver);
        btnSalir = (Button)findViewById(R.id.btnSalir);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver1 = new Intent(LevelSelectionActivity.this, MainActivity.class);
                startActivity(volver1);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
