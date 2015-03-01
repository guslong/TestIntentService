package community.erninet.ch.testintentservice.application;

import android.app.Application;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.model.Mood;

/**
 * Created by gus on 28/02/15.
 */
public class Globals extends Application {

    // this array list will store all the moods objects retrieved from backend in the application memory
    private ArrayList<Mood> moodsStorage;

    @Override
    public void onCreate() {

    }

    public void setMoodsStorage(ArrayList<Mood> moodsStorage) {
        this.moodsStorage = moodsStorage;
    }

    public ArrayList<Mood> getMoodsStorage() {
        return moodsStorage;
    }
}
