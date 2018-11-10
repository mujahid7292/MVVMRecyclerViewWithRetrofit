package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.RVAdapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.R;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.databinding.CategoryBinding;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder>{

    private ArrayList<MainViewModel>mainViewModelArrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public RVAdapter(ArrayList<MainViewModel> mainViewModelArrayList, Context context) {
        this.mainViewModelArrayList = mainViewModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        CategoryBinding categoryBinding = DataBindingUtil.inflate(
                layoutInflater,R.layout.single_category,parent,false);
        MyViewHolder holder = new MyViewHolder(categoryBinding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MainViewModel mainViewModel = mainViewModelArrayList.get(position);
        holder.bind(mainViewModel);
    }

    @Override
    public int getItemCount() {
        return mainViewModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public CategoryBinding categoryBinding;

        public MyViewHolder(@NonNull CategoryBinding categoryBinding) {
            super(categoryBinding.getRoot());
            this.categoryBinding = categoryBinding;
        }

        public void bind(MainViewModel mainViewModel) {
            this.categoryBinding.setMainViewModel(mainViewModel);
            categoryBinding.executePendingBindings();
        }

        public CategoryBinding getCategoryBinding() {
            return categoryBinding;
        }
    }
}
