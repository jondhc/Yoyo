package com.example.jondhc.yoyo;

import android.app.Application;

/**
 * Created by clem on 27/11/17.
 */

public class GlobalApplication extends Application {

    private Characters selectedC;

    public Characters getGlobalVarValue() {
        return selectedC;
    }

    public void setGlobalVarValue(Characters toSet) {
        selectedC = toSet;
    }
}
