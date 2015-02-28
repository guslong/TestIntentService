package community.erninet.ch.testintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "community.erninet.ch.testintentservice.action.FOO";
    private static final String ACTION_BAZ = "community.erninet.ch.testintentservice.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "community.erninet.ch.testintentservice.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "community.erninet.ch.testintentservice.extra.PARAM2";
    public static final String TAG = "TestIntentService";


    public MyIntentService() {
        super("MyIntentService");
    }

    public static final String MESSAGE_KEY = "MESSAGE";

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("TestIntentService", "onHandleIntent called");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        Log.i("TestIntentService", "ActionFoo called");

        // then pass a broadcast and add the string to the message
        Intent intent = new Intent();
        intent.setAction("service");
        intent.putExtra(MESSAGE_KEY, "This is my message from the intent service class");
        sendBroadcast(intent);
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        Log.i(TAG, "ActionBaz called");
    }
}
