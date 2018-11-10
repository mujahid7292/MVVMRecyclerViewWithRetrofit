package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.RestAPI.APIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainModel.Category;

import java.util.ArrayList;

public class CategoryList {
    @SerializedName("Category_List")
    @Expose()
    public ArrayList<Category> categoryArrayList = new ArrayList<Category>();

    public CategoryList() {

    }

    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }
}
