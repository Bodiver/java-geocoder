package rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by stepanv on 27.10.16.
 */
public class ServiceFactory {
    //ServiceFactory to encapsulate rest object creation using Factory Design Pattern

    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        //Setting request end point and converter factory for converting response to model object
        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Return generated implementation of the interface
        return restAdapter.create(clazz);
    }
}
