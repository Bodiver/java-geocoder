import model.GeocoderResult;
import model.Result;
import rest.GoogleApiService;
import rest.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by stepanv on 27.10.16.
 */
class RequestMaker {
    //Get service implementation from ServiceFactory
    private static GoogleApiService service = ServiceFactory.createRetrofitService(GoogleApiService.class, GoogleApiService.MAPS_ENDPOINT);

    static void getCoordinatesFor(String city) {
        //Make asynchronous request
        service.getLocation(city).enqueue(new Callback<GeocoderResult>() {
            //Handle response
            public void onResponse(Call<GeocoderResult> call, Response<GeocoderResult> response) {
                for (Result result : response.body().getResults()) {
                    System.out.println(result.getFormattedAddress() + ": " + result.getGeometry().getLocation().getLat() + " " + result.getGeometry().getLocation().getLng());
                }
            }

            //Handle request failure
            public void onFailure(Call<GeocoderResult> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
