package mvp.airbnb.data.source.remote;

import java.util.ArrayList;


import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import mvp.airbnb.data.Accommodation;
import mvp.airbnb.data.source.remote.response.AccommodationResponse;
import mvp.airbnb.data.source.remote.response.SearchAccomodationResponse;
import mvp.airbnb.data.source.remote.response.SearchDataResponse;


/**
 * Created by jp on 9/9/17.
 */

public class AccommodationService extends BaseService {

    private final static String CLIENT_ID = "3092nxybyb0otqw18e8nh5nty";
    private final static String FOMRATING_LIST = "v1_legacy_for_p3";
    private final static int SEARCH_NUMBER = 30;

    private AccommodationApi mApi;

    private static AccommodationService singleton;

    public static AccommodationService getInstance() {
        if (singleton == null) {
            singleton = new AccommodationService();
        }
        return singleton;
    }

    private AccommodationService() {
        super();
        mApi = buildApi(AccommodationApi.class);

    }

    public interface SearchAccommodationListListener {
        void onAccommodationListResult(ArrayList<Accommodation> mAccommodations);

        void onError();
    }

    public interface SearchAccommodationListener {
        void onAccommodationResult(Accommodation mAccomodations);

        void onError();
    }

    public void searchAccomodationsByCity(String city, @NonNull final SearchAccommodationListListener listener) {

        mApi.getAccommodationsByClientId(CLIENT_ID, city, SEARCH_NUMBER).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new DisposableObserver<SearchAccomodationResponse<SearchDataResponse>>() {
                    @Override
                    public void onNext(@NonNull SearchAccomodationResponse<SearchDataResponse> searchDataResponseSearchAccomodationResponse) {

                        ArrayList<Accommodation> mAccomodations = new ArrayList<>();
                        for (SearchDataResponse accommodationResponse : searchDataResponseSearchAccomodationResponse.searchData) {

                            Accommodation mAccommodation = new Accommodation();
                            mAccommodation.setBathroom(accommodationResponse.listingData.bathroom);
                            mAccommodation.setBedrooms(accommodationResponse.listingData.bedroom);
                            mAccommodation.setBeds(accommodationResponse.listingData.beds);
                            mAccommodation.setCapacity(accommodationResponse.listingData.capacity);
                            mAccommodation.setCity(accommodationResponse.listingData.city);
                            mAccommodation.setCountry(accommodationResponse.listingData.country);
                            mAccommodation.setCurrency(accommodationResponse.listingData.currency);
                            mAccommodation.setDescription(accommodationResponse.listingData.description);
                            mAccommodation.setGuest(accommodationResponse.listingData.guest);
                            mAccommodation.setName(accommodationResponse.listingData.name);
                            mAccommodation.setPropertyType(accommodationResponse.listingData.propertyType);
                            mAccommodation.setRoomType(accommodationResponse.listingData.roomType);
                            mAccommodation.setImage(accommodationResponse.listingData.image);
                            mAccommodation.setLatitude(accommodationResponse.listingData.latitude);
                            mAccommodation.setLongitude(accommodationResponse.listingData.longitude);
                            mAccommodation.setPrice(accommodationResponse.pricingData.price);
                            mAccomodations.add(mAccommodation);

                        }
                        listener.onAccommodationListResult(mAccomodations);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void searchAccommodationsById(int accommodationId, @NonNull final SearchAccommodationListener listener) {
        mApi.getAccommodationById(accommodationId, CLIENT_ID, FOMRATING_LIST).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new DisposableObserver<AccommodationResponse>(){

                    @Override
                    public void onNext(@NonNull AccommodationResponse accommodationResponse) {
                        Accommodation mAccommodation = new Accommodation();
                        mAccommodation.setBathroom(accommodationResponse.listingData.bathroom);
                        mAccommodation.setBedrooms(accommodationResponse.listingData.bedroom);
                        mAccommodation.setBeds(accommodationResponse.listingData.beds);
                        mAccommodation.setCapacity(accommodationResponse.listingData.capacity);
                        mAccommodation.setCity(accommodationResponse.listingData.city);
                        mAccommodation.setCountry(accommodationResponse.listingData.country);
                        mAccommodation.setCurrency(accommodationResponse.listingData.currency);
                        mAccommodation.setDescription(accommodationResponse.listingData.description);
                        mAccommodation.setGuest(accommodationResponse.listingData.guest);
                        mAccommodation.setName(accommodationResponse.listingData.name);
                        mAccommodation.setPropertyType(accommodationResponse.listingData.propertyType);
                        mAccommodation.setRoomType(accommodationResponse.listingData.roomType);
                        mAccommodation.setImage(accommodationResponse.listingData.image);
                        mAccommodation.setLatitude(accommodationResponse.listingData.latitude);
                        mAccommodation.setLongitude(accommodationResponse.listingData.longitude);
                        mAccommodation.setPrice(accommodationResponse.listingData.price);
                        listener.onAccommodationResult(mAccommodation);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
