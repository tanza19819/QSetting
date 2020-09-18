package th.co.infinitecorp.www.QSetting.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("employeeinfoApi")
    Call<ResponseBody> GetEmployeeinfoApi (@Query("search") String search);
}
