package mvp.airbnb.data.source.remote.response.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Juan on 09/03/2017.
 */
public class PricingDataResult {

    @SerializedName("nightly_price")
    public int price;
    @SerializedName("localized_currency")
    public String currency;

}
