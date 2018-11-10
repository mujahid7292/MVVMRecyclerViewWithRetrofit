package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.Global;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.APIService;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://192.168.0.53/api/";

    public static APIService getAPIService(){
        return RetrofitClient.getRetrofit(BASE_URL).create(APIService.class);
    }
}
