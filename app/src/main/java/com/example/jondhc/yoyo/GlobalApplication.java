package com.example.jondhc.yoyo;

import android.app.Application;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by clem on 27/11/17.
 */

public class GlobalApplication extends Application {

    private Characters selectedC;
    private FirebaseUser user;
    private LocalData statut_levels;

    public Characters getGlobalVarValue() {
        return selectedC;
    }

    public void setGlobalVarValue(Characters toSet) {
        selectedC = toSet;
    }

    public void setStatutLevels(LocalData statut_levels){
        this.statut_levels = statut_levels;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser toSet) {
        user = toSet;
    }

    public LocalData getStatutLevels(){
        return this.statut_levels;
    }


}
