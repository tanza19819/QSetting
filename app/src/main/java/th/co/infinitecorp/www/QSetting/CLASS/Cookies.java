package th.co.infinitecorp.www.QSetting.CLASS;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import th.co.infinitecorp.www.QSetting.MODEL.API.EmployeeInfo;
import th.co.infinitecorp.www.QSetting.MODEL.CONFIG.Setting_System;

public class Cookies {
    //Branch info
//    public  static void SaveBranchDataInfo(Context context, List<BranchInfo> infos) {
//        SharedPreferences.Editor editor=context.getSharedPreferences("BranchInfo",Context.MODE_PRIVATE).edit();
//        Type type=new TypeToken<List<BranchInfo>>(){}.getType();
//        Gson gson=new Gson();
//        String json=gson.toJson(infos,type);
//        editor.putString("branchData",json);
//        editor.apply();
//    }
//    public static List<BranchInfo> RetrievedBranchDataInfo(Context context) {
//        SharedPreferences sharedPreferences=context.getSharedPreferences("BranchInfo",Context.MODE_PRIVATE);
//        String strData=sharedPreferences.getString("branchData",null);
//        Type type=new TypeToken<List<BranchInfo>>(){}.getType();
//        if(strData!=null)
//        {
//            Gson gson=new Gson();
//            List<BranchInfo> listLog=gson.fromJson(strData,type);
//            return  listLog;
//        }
//        List<BranchInfo> list=new ArrayList<>();
//        return list;
//    }

    public static void SaveCookies(Context context, String cookiesName, String propertiesCookies, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(cookiesName, Context.MODE_PRIVATE).edit();
        editor.putString(propertiesCookies, value);
        editor.apply();
    }

    public static String GetCookies(Context context, String cookiesName, String propertiesCookies) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(cookiesName, Context.MODE_PRIVATE);
        String strData = sharedPreferences.getString(propertiesCookies, null);
        return strData;
    }

    public static void SaveSettingSystem(Context context, Setting_System infos) {
        SharedPreferences.Editor editor = context.getSharedPreferences("SYSTEM", Context.MODE_PRIVATE).edit();
        Type type = new TypeToken<Setting_System>() {
        }.getType();
        Gson gson = new Gson();
        String json = gson.toJson(infos, type);
        editor.putString("SystemData", json);
        editor.apply();
    }

    public static Setting_System GetSetting_System(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SYSTEM", Context.MODE_PRIVATE);
        String strData = sharedPreferences.getString("SystemData", null);
        Type type = new TypeToken<Setting_System>() {
        }.getType();
        if (strData != null) {
            Gson gson = new Gson();
            Setting_System listLog = gson.fromJson(strData, type);
            return listLog;
        }
        Setting_System list = new Setting_System();
        return list;
    }

    public static void SaveEmployeeInfo(Context context, List<EmployeeInfo> infos)
    {
        SharedPreferences.Editor editor = context.getSharedPreferences("EMPLOYEE", Context.MODE_PRIVATE).edit();
        Type type = new TypeToken<List<EmployeeInfo>>() {
        }.getType();
        Gson gson = new Gson();
        String json = gson.toJson(infos, type);
        editor.putString("EmployeeInfo", json);
        editor.apply();
    }
    public static List<EmployeeInfo> GetEmployeeInfo(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("EMPLOYEE", Context.MODE_PRIVATE);
        String strData = sharedPreferences.getString("EmployeeInfo", null);
        Type type = new TypeToken<List<EmployeeInfo>>() {}.getType();
        if(strData != null)
        {
            Gson gson = new Gson();
            List<EmployeeInfo> employeeInfos = gson.fromJson(strData,type);
            return employeeInfos;
        }
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        return employeeInfos;
    }

    public static void ClearCookies(Context context, String cookiesName) {
        SharedPreferences.Editor editor = context.getSharedPreferences(cookiesName, context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
    }
}
