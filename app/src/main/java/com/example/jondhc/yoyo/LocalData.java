package com.example.jondhc.yoyo;

import android.app.Activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by clem on 14/11/17.
 */

public class LocalData implements Serializable {
    private static File mFolder;
    public Map<Levels, Integer> statut_levels = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));
    public Map<Levels, Integer> statut_levels_cat = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));
    public Map<Levels, Integer> statut_levels_dog = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));


    public LocalData(){
        for (Levels p : Levels.values()) {
            if(p != Levels.VEGETABLES) {
                statut_levels.put(p, 0);
                statut_levels_cat.put(p, 0);
                statut_levels_dog.put(p, 0);
            }
            else{
                statut_levels.put(p, -1);
                statut_levels_cat.put(p, -1);
                statut_levels_dog.put(p, -1);
            }
        }
    }

    public void saveData(Activity pContext, Characters selectedC){

        if(selectedC == Characters.CAT)
        if(mFolder == null){
            mFolder = pContext.getExternalFilesDir(null);
        }
        ObjectOutput out;
        try {
            File outFile = new File(mFolder, "yoyoSavedData.data");
            out = new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(this);
            out.close();
        } catch (Exception e) {e.printStackTrace();}
    }

    public void loadData(Activity pContext, Characters selectedC){

        if(mFolder == null){
            mFolder = pContext.getExternalFilesDir(null);
        }
        ObjectInput in;
        LocalData ss=null;
        try {
            File inFile = new File(mFolder, "yoyoSavedData.data");
            in = new ObjectInputStream(new FileInputStream(inFile));
            ss=(LocalData) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace();}
        if(ss != null) {
            this.statut_levels_cat = ss.statut_levels_cat;
            this.statut_levels_dog = ss.statut_levels_dog;
            if(selectedC == Characters.CAT)
                this.statut_levels = this.statut_levels_cat;
            else if(selectedC == Characters.DOG)
                this.statut_levels = this.statut_levels_dog;
        }
    }
}