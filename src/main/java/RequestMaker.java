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
public class RequestMaker {
    private static GoogleApiService service = ServiceFactory.createRetrofitService(GoogleApiService.class, GoogleApiService.MAPS_ENDPOINT);

    public static void getCoordinatesFor(String city) {
        service.getLocation(city).enqueue(new Callback<GeocoderResult>() {
            public void onResponse(Call<GeocoderResult> call, Response<GeocoderResult> response) {
                for (Result result : response.body().getResults()) {
                    System.out.println(result.getFormattedAddress() + result.getGeometry().getLocation().getLat() + result.getGeometry().getLocation().getLng());
                }
            }

            public void onFailure(Call<GeocoderResult> call, Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
