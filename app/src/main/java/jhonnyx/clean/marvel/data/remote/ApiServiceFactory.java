package jhonnyx.clean.marvel.data.remote;

import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jhonnybarrios on 01-09-17.
 */

public class ApiServiceFactory {
    private ApiService apiService;

    @Inject
    public ApiServiceFactory(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService get(){
        return apiService;
    }
}