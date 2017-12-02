package com.example.jondhc.yoyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static com.example.jondhc.yoyo.Characters.CAT;

public class MainActivity extends AppCompatActivity {

    Button playBtnCat; //Initializing Cat Play Button
    Button playBtnDog; //Initializing Dog Play Button
    GlobalApplication mApp;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = ((GlobalApplication)getApplicationContext());
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);



        playBtnCat = (Button) findViewById(R.id.playButtonCat);   //Detect the play button
        playBtnCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
        playBtnDog = (Button) findViewById(R.id.playButtonDog);   //Detect the play button
        playBtnDog.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.DOG);
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
    }
}
