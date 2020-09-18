package th.co.infinitecorp.www.QSetting.API;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.co.infinitecorp.www.QSetting.MODEL.API.EmployeeInfo;

public class EmployeeinfoApi {
    public interface EmployeeApiListener {
        void onApiListener(int Status_Code, List<EmployeeInfo> employeeInfo, String error_des);
    }

    EmployeeApiListener employeeApiListener;

    public void GetEmployeeApi(String hostName, String search, final EmployeeApiListener employeeApiListener) {
        this.employeeApiListener = employeeApiListener;

        ResManager resManager = new ResManager();
        Call<ResponseBody> call;
        call = resManager.apiTrue(hostName).GetEmployeeinfoApi(search);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try
                    {
                        String txt_Response =  response.body().string();
                        List<EmployeeInfo> employeeInfo = new Gson().fromJson(txt_Response, new TypeToken<List<EmployeeInfo>>(){}.getType());
                        employeeApiListener.onApiListener(response.code(),employeeInfo,null);
                    }catch (Exception ex)
                    {
                        Log.d("API" , "messgae : " + ex.toString());
                        employeeApiListener.onApiListener(response.code(),null, ex.toString());
                    }
                } else {
                    employeeApiListener.onApiListener(response.code(),null,null);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                employeeApiListener.onApiListener(0,null,t.toString());
            }
        });
    }
}
