package community.erninet.ch.testintentservice.service;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.application.Globals;
import community.erninet.ch.testintentservice.model.Moods;


public class MyIntentService extends IntentService {

    private Globals globals;

    public static final String TAG = "TestIntentService";

    // Keys for intent extras
    private static final String ARRAY_KEY = "ArrayListOfMoods";
    public static final String MESSAGE_KEY = "MESSAGE";

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        // will handle the result message success or error
        String result = "Success";

        // access our custom application class
        globals = (Globals)getApplication();

        // get the moods from the backend and set the global moods array list
        globals.setMoods(getMoodsFromBackend());

        // broadcast it to listeners
        doBroadcast(result);

    }

    private ArrayList<Moods> getMoodsFromBackend() {

        ArrayList<Moods> moods = null;

        //TODO this should get the moods from the backend

        return moods;
    }

    private void doBroadcast(final String result) {
        Intent intent = new Intent();
        intent.setAction("service");
        intent.putExtra(MESSAGE_KEY, result);
        sendBroadcast(intent);
    }


}
