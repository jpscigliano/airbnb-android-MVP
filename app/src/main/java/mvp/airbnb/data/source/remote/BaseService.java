package mvp.airbnb.data.source.remote;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by jp on 9/9/17.
 */

public class BaseService {

    private static final String HTTPS = "https://api.airbnb.com/v2/";


    public <T> T buildApi(Class<T> clazz) {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient client = httpClient.
                readTimeout(60, TimeUnit.SECONDS).
                connectTimeout(60, TimeUnit.SECONDS).
                build();


        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }

        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTPS)
                .client(client)
                .build();

        return retrofit.create(clazz);

    }

}
