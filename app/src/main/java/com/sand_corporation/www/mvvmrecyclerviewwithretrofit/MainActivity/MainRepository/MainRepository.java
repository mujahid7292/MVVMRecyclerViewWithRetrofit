package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainRepository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.Global.Common;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainModel.Category;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.APIModel.CategoryList;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    public MutableLiveData<ArrayList<MainViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<Category> categoryArrayList;
    public ArrayList<MainViewModel> mainViewModelArrayList;
    private static final String TAG = "RVExample";

    public MutableLiveData<ArrayList<MainViewModel>> getArrayListMutableLiveData() {
        Log.i(TAG,"getArrayListMutableLiveData Called");
        categoryArrayList = new ArrayList<>();
        APIService apiService = Common.getAPIService();
        Call<CategoryList>getCategoryList = apiService.getCategoryList();
        getCategoryList.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                if (response != null && response.body() != null){
                    categoryArrayList = response.body().getCategoryArrayList();
                    Category category;
                    MainViewModel mainViewModel;
                    mainViewModelArrayList = new ArrayList<>();
                    for (int i =0; i<categoryArrayList.size();i++){
                        category = categoryArrayList.get(i);
                        mainViewModel = new MainViewModel(category);
                        mainViewModelArrayList.add(mainViewModel);
                    }
                    arrayListMutableLiveData.setValue(mainViewModelArrayList);
                }
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {

            }
        });

        return arrayListMutableLiveData;
    }
}
