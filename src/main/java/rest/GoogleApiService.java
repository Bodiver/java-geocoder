package rest;

import model.GeocoderResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by stepanv on 27.10.16.
 */
public interface GoogleApiService {
    String MAPS_ENDPOINT = "https://maps.googleapis.com/maps/api/";

    @GET("geocode/json")
    Call<GeocoderResult> getLocation(@Query("address") String address);

}
