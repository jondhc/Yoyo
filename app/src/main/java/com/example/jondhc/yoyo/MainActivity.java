package com.example.jondhc.yoyo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static int RC_SIGN_IN = 100;
    Button playBtnCat; //Initializing Cat Play Button
    Button playBtnDog; //Initializing Dog Play Button
    GlobalApplication mApp;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    FirebaseUser user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mApp = ((GlobalApplication)getApplicationContext());
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signIn();
        database = FirebaseDatabase.getInstance();
        user = mAuth.getCurrentUser();
        mApp.setUser(user);

        /*View yoyoSignIn = findViewById(R.id.main_screen_text);
        yoyoSignIn.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                //signIn();
            }
        });*/

        int width, height, bck_width, bck_height;
        // Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        bck_height = size.y;
        bck_width = size.x;

        ImageView textYoyo = (ImageView) findViewById(R.id.main_screen_text);
        textYoyo.setX((float) (bck_width * 0));
        textYoyo.setY((float) (bck_height * 0.1));
        width = (int) (1 * bck_width);
        height = (int) (width / 1.777778);
        GlideApp.with(this).load(R.drawable.yoyo).override(width,height).into(textYoyo);

        ImageView iconCat = (ImageView) findViewById(R.id.iconCat);
        iconCat.setX((float) (bck_width * 0.16));
        iconCat.setY((float) (bck_height * 0.39));
        width = (int) (0.25 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.cat).override(width,height).into(iconCat);
        iconCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                myRef = database.getReference(user.getUid()+" Character ");
                myRef.setValue("Cat was selected");
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView iconDog = (ImageView) findViewById(R.id.iconDog);
        iconDog.setX((float) (bck_width * 0.605));
        iconDog.setY((float) (bck_height * 0.4));
        width = (int) (0.25 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.dog).override(width,height).into(iconDog);
        iconDog.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.DOG);
                myRef = database.getReference(user.getUid()+" Character ");
                myRef.setValue("Dog was selected");
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView playBtnCat = (ImageView) findViewById(R.id.playButtonCat);
        playBtnCat.setX((float) (bck_width * 0.0));
        playBtnCat.setY((float) (bck_height * 0.47));
        width = (int) (0.55 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.play).override(width,height).into(playBtnCat);
        playBtnCat.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.CAT);
                myRef = database.getReference(user.getUid()+" Character ");
                myRef.setValue("Cat was selected");
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });

        ImageView playBtnDog = (ImageView) findViewById(R.id.playButtonDog);
        playBtnDog.setX((float) (bck_width * 0.43));
        playBtnDog.setY((float) (bck_height * 0.47));
        width = (int) (0.55 * bck_width);
        height = width;
        GlideApp.with(this).load(R.drawable.play).override(width,height).into(playBtnDog);
        playBtnDog.setOnClickListener(new View.OnClickListener() { //Detect touch on button
            @Override
            public void onClick(View v) {
                mApp.setGlobalVarValue(Characters.DOG);
                myRef = database.getReference(user.getUid()+" Character ");
                myRef.setValue("Dog was selected");
                Intent playI = new Intent(MainActivity.this, LevelSelectionActivity.class); //Start next activity
                startActivity(playI);
            }
        });
    }//end onCreate

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        System.out.println(account);
        //updateUI(account);
    }//end onStart

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }//end signIn

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }//end if
    }//end onActivityResult

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            firebaseAuthWithGoogle(account);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);
            System.out.println(account);
        }//end try
        catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
            System.out.println("signInResult:failed code=" + e.getStatusCode());
        }//end catch
    }//end handleSignInResult

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }//end if
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }//end else

                        // ...
                    }//end onComplete
                });//end addOnCompleteListener
    }//end firebaseAuthWithGoogle

    private void updateUI(FirebaseUser user) {
        //hideProgressDialog();
        if (user != null) {
            System.out.println(user.getEmail());
            System.out.println(user.getUid());
            /*mStatusTextView.setText(getString(R.string.google_status_fmt, user.getEmail()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);*/
        } else {
            System.out.println("Signed out");
            /*mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);*/
        }//end if-else
    }//end updateUI

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN; //Hide the status bar
        decorView.setSystemUiVisibility(uiOptions);
    }//end onResume
}//end MainActivity
