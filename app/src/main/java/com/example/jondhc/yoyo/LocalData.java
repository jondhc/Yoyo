package com.example.jondhc.yoyo;

import android.app.Activity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created by clem on 14/11/17.
 */

public class LocalData implements Serializable {
    private static File mFolder;
    // This Map would be use as main data
    public Map<Levels, Integer> statut_levels = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));

    // Secondary datas used to facilitate data management
    private Map<Levels, Integer> statut_levels_cat = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));
    private Map<Levels, Integer> statut_levels_dog = Collections.synchronizedMap(new EnumMap<Levels, Integer>(Levels.class));

    // Will be used to see which datas are most recent
    private Timestamp current_time = new Timestamp(0);

    // Basic constructor for LocalData, will build a blank game save
    public LocalData() {
        for (Levels p : Levels.values()) {
            if (p != Levels.VEGETABLES) {
                statut_levels.put(p, 0);
                statut_levels_cat.put(p, 0);
                statut_levels_dog.put(p, 0);
            } else {
                statut_levels.put(p, -1);
                statut_levels_cat.put(p, -1);
                statut_levels_dog.put(p, -1);
            }
        }
    }

    public LocalData(Map<Levels, Integer> statut_levels_cat, Map<Levels, Integer> statut_levels_dog, Timestamp current_time) {
        this.statut_levels_cat = statut_levels_cat;
        this.statut_levels_dog = statut_levels_dog;
        this.current_time = current_time;
    }

    public void saveData(Activity pContext, Characters selectedC, FirebaseUser user) {
        // To make it easier for further load we put main datas into specific maps
        if (selectedC == Characters.CAT)
            this.statut_levels_cat = this.statut_levels;
        else if (selectedC == Characters.DOG)
            this.statut_levels_dog = this.statut_levels;
        // Useful to compare local and remote datas
        current_time.getTime();
        // If it didn't have initialize already we ask the system for our given saving path
        if (mFolder == null) {
            mFolder = pContext.getExternalFilesDir(null);
        }
        ObjectOutput out;
        // Object is transform into bytes (Serializable characteristic)
        try {
            File outFile = new File(mFolder, "yoyoSavedData.data");
            out = new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(this);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference catL = database.getReference("statut_level_cat");
        DatabaseReference dogL = database.getReference("statut_level_dog");
        DatabaseReference currTime = database.getReference("current_time");
        catL.setValue(this.statut_levels_cat.toString());
        dogL.setValue(this.statut_levels_cat.toString());
        currTime.setValue(this.current_time.toString());
    }

    public void loadData(Activity pContext, Characters selectedC, FirebaseUser user) {
        // If it didn't have initialize already we ask the system for our given saving path
        if (mFolder == null) {
            mFolder = pContext.getExternalFilesDir(null);
        }
        ObjectInput in;
        LocalData local = null;
        LocalData remote = null;
        // Object is built from bytes (Serializable charasteristic)
        try {
            File inFile = new File(mFolder, "yoyoSavedData.data");
            in = new ObjectInputStream(new FileInputStream(inFile));
            local = (LocalData) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO Connection to database
        // remote = new LocalData(get(statut_levels_cat),get(statut_levels_dog),get(current_time));

        // Network is unreachable but local datas exists
        if (remote == null && local != null) {
            this.statut_levels_cat = local.statut_levels_cat;
            this.statut_levels_dog = local.statut_levels_dog;
        }
        // Network is reachable but local datas doen't exists
        else if (remote != null && local == null) {
            this.statut_levels_cat = remote.statut_levels_cat;
            this.statut_levels_dog = remote.statut_levels_dog;

        }
        // We managed to get both datas, we are using most recent ones
        else if (remote != null && local != null) {
            // Local datas are most recent ones or they're both as old
            if (local.current_time.compareTo(remote.current_time) >= 0) {
                this.statut_levels_cat = local.statut_levels_cat;
                this.statut_levels_dog = local.statut_levels_dog;
            } else {
                this.statut_levels_cat = remote.statut_levels_cat;
                this.statut_levels_dog = remote.statut_levels_dog;
            }
        }
        // We use selected character as ain datas
        if (selectedC == Characters.CAT)
            this.statut_levels = this.statut_levels_cat;
        else if (selectedC == Characters.DOG)
            this.statut_levels = this.statut_levels_dog;
    }
}
