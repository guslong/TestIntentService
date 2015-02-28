package community.erninet.ch.testintentservice.application;

import android.app.Application;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.model.Moods;

/**
 * Created by gus on 28/02/15.
 */
public class Globals extends Application {

    // this array list will store all the objects retrieved from backend in the application memory
    ArrayList<Moods> moods;

    @Override
    public void onCreate() {

        // this could even be made to initialise already with the stuff from the database, by calling the service.... ???
        // for now just initialise it to null.
        moods = null;
    }


    public void setMoods(ArrayList<Moods> moods) {
        this.moods = moods;
    }

    public ArrayList<Moods> getMoods() {
        return moods;
    }
}
