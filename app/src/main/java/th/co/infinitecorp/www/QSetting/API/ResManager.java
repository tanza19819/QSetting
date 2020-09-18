package th.co.infinitecorp.www.QSetting.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResManager {
    private ApiService apiService;
    public ApiService apiTrue(String hostName)
    {
        if(apiService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(hostName)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }
        return  apiService;
    }
}
