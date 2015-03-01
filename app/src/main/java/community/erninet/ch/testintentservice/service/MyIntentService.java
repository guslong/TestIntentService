package community.erninet.ch.testintentservice.service;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.application.Globals;
import community.erninet.ch.testintentservice.model.Mood;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


public class MyIntentService extends IntentService {

    public static final String TAG = "TestIntentService";

    ArrayList<Mood> moods = null;

    // Keys for intent extras
    private static final String ARRAY_KEY = "ArrayListOfMoods";
    public static final String MESSAGE_KEY = "MESSAGE";

    String SERVICE_ENDPOINT = "http://moodyrest.azurewebsites.net";

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        String result = "Error"; // will be set to success if the call works

        Gson gson = new GsonBuilder()
                //custom handling of location objects
                .registerTypeAdapter(Location.class, new LocationDeserializer())
                .registerTypeAdapter(Location.class, new LocationSerializer())
                        //specify the date format
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();

        try {
            // create a RestAdapter
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(SERVICE_ENDPOINT)
                    .setConverter(new GsonConverter(gson))
                    .build();

            MoodsAPI moodsAPI = restAdapter.create(MoodsAPI.class);

            moods = moodsAPI.getMoods();

            result = "Success";
            Log.i(TAG, result);
            Log.i(TAG, moods.toString());

        } catch (Exception e) {

            result = "Error";
            Log.i(TAG, e.toString());

        } finally {
            doBroadcast(result);

        }

    }


    private void doBroadcast(final String result) {
        Intent intent = new Intent();
        intent.setAction("service");
        intent.putExtra(MESSAGE_KEY, result);
        sendBroadcast(intent);
    }

}
