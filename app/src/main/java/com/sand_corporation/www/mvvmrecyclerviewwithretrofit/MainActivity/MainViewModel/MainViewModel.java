package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainModel.Category;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainRepository.MainRepository;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    public Category category;
    public MutableLiveData<ArrayList<MainViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<Category> categoryArrayList;
    private MainRepository mRepository;

    public MainViewModel() {
        mRepository = new MainRepository();
        arrayListMutableLiveData = mRepository.arrayListMutableLiveData;
    }

    public MainViewModel(Category category) {
        this.category = category;
    }

    public String getImageUrl(){
        return category.imageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }


    public MutableLiveData<ArrayList<MainViewModel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }

    public void loadRVFromServer(){
        mRepository.getArrayListMutableLiveData();
    }
}
