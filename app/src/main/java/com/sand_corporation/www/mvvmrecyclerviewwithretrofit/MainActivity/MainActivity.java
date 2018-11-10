package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainPresenter.MainPresenter;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.MainActivity.RVAdapter.RVAdapter;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.R;
import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private MainViewModel mViewModel;
    private RecyclerView recyclerView;
    private RVAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);

        mViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<MainViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MainViewModel> mainViewModels) {
                mAdapter = new RVAdapter(mainViewModels,MainActivity.this);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(mAdapter);
            }
        });

        mainBinding.setMainPresenter(new MainPresenter() {
            @Override
            public void OnClick() {
                mViewModel.loadRVFromServer();
            }
        });
    }
}
