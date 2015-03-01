package community.erninet.ch.testintentservice.application;

import android.app.Application;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.model.Mood;

/**
 * Created by gus on 28/02/15.
 */
public class Globals extends Application {

    // this array list will store all the objects retrieved from backend in the application memory
    ArrayList<Mood> moods;

    @Override
    public void onCreate() {

    }

    public void setMoods(ArrayList<Mood> moods) {
        this.moods = moods;
    }

    public ArrayList<Mood> getMoods() {
        return moods;
    }
}
