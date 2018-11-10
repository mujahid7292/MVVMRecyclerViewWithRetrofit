package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.APIModel.CategoryList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("e_commerce/category_list")
    Call<CategoryList> getCategoryList();
}
