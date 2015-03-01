package community.erninet.ch.testintentservice.presenter;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.R;
import community.erninet.ch.testintentservice.application.Globals;
import community.erninet.ch.testintentservice.model.Mood;
import community.erninet.ch.testintentservice.service.MyIntentService;


public class BlankFragment extends Fragment {


    IntentFilter filter;
    MyReceiver myReceiver;

    public static final String MESSAGE_KEY = "MESSAGE";

    public static final String TAG = "TestIntentService";
    private static final String ACTION_FOO = "community.erninet.ch.testintentservice.action.FOO";

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onAttach(Activity activity) {

        // create an intent
        Intent intent = new Intent(getActivity(),MyIntentService.class);

        // add an extra to trigger the proper action in the service
        intent.setAction(ACTION_FOO);

        // start the service
        getActivity().startService(intent);

        Log.i("TestIntentService", "OnAttach");

        // register a broadcast receiver to receive the broadcast from the service
        filter = new IntentFilter("service");
        myReceiver = new MyReceiver();
        getActivity().registerReceiver(myReceiver, filter);

        super.onAttach(activity);
    }

    @Override
    public void onResume() {
        getActivity().registerReceiver(myReceiver, filter);
        super.onResume();
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(myReceiver);
        super.onPause();
    }


    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, intent.getStringExtra(MESSAGE_KEY), Toast.LENGTH_SHORT).show();

            // then update the TextView with the text retrieved from the backend
            updateView();
        }
    }

    private void updateView() {
        TextView tv1 = (TextView)getView().findViewById(R.id.tv1);
        ArrayList<Mood> moodyList = ((Globals)getActivity().getApplication()).getMoodsStorage();
        tv1.setText(moodyList.toString());
    }



}
