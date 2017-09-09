package mvp.airbnb.data.source.remote.response;


import com.google.gson.annotations.SerializedName;

import mvp.airbnb.data.source.remote.response.data.ListingDataResult;

/**
 * Created by Juan on 09/03/2017.
 */
public class AccommodationResponse {

    @SerializedName("listing")
    public ListingDataResult listingData;


}
