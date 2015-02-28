package community.erninet.ch.testintentservice;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

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

        super.onAttach(activity);
    }
}
