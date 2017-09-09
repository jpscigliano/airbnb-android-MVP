package mvp.airbnb.data.source.remote;

/**
 * Created by jp on 9/9/17.
 */

public class AccommodationService extends BaseService {

    private final static String cliente_id = "3092nxybyb0otqw18e8nh5nty";
    private final static String formatListing = "v1_legacy_for_p3";

    public AccommodationApi mApi;

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
}
