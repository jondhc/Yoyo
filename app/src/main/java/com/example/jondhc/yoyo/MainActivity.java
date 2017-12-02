package com.example.jondhc.yoyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.google.android.gms.auth.api.Auth;


import static com.example.jondhc.yoyo.Characters.CAT;

public class MainActivity extends AppCompatActivity {

    Button playBtnCat; //Initializing Cat Play Button
    Button playBtnDog; //Initializing Dog Play Button
    GlobalApplication mApp;
    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;


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

        View yoyoSignIn = findViewById(R.id.main_screen_text);
        yoyoSignIn.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

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

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //updateUI(account);

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }
}
