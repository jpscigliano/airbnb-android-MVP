package mvp.airbnb.data.source.remote;



import io.reactivex.Observable;
import mvp.airbnb.data.source.remote.response.AccommodationResponse;
import mvp.airbnb.data.source.remote.response.SearchAccomodationResponse;
import mvp.airbnb.data.source.remote.response.SearchDataResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



/**
 * Created by Juan on 09/03/2017.
 */
public interface AccommodationApi {

    @GET("search_results")
    Observable<SearchAccomodationResponse<SearchDataResponse>> getAccommodationsByClientId(
            @Query("client_id") String Id,
            @Query("location") String location,
            @Query("_limit") int limit
    );

    @GET("listings/{listing_id}")
    Observable<AccommodationResponse> getAccommodationById(
            @Path("listing_id") int listingId,
            @Query("client_id") String Id,
            @Query("_format") String format
    );

}
