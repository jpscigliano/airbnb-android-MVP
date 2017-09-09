package mvp.airbnb.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

import mvp.airbnb.data.source.remote.response.data.ListingDataResult;
import mvp.airbnb.data.source.remote.response.data.PricingDataResult;

/**
 * Created by Juan on 10/03/2017.
 */
public class SearchDataResponse {
    @SerializedName("listing")
    public ListingDataResult listingData;

    @SerializedName("pricing_quote")
    public PricingDataResult pricingData;

}

