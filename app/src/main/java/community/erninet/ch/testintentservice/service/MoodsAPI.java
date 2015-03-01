package community.erninet.ch.testintentservice.service;

import java.util.ArrayList;

import community.erninet.ch.testintentservice.model.Mood;
import retrofit.http.GET;

public interface MoodsAPI {

    // get all the moods from the API
    @GET("/moods")
    ArrayList<Mood> getMoods();


}
