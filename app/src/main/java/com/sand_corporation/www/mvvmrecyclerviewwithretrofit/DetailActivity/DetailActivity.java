package com.sand_corporation.www.mvvmrecyclerviewwithretrofit.DetailActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sand_corporation.www.mvvmrecyclerviewwithretrofit.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle,txtDescription;
    private ImageView imgCategory;
    private String categoryId, categoryTitle, categoryDescription, categoryImageUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        imgCategory = findViewById(R.id.imgCategory);

        Intent intent = getIntent();
        categoryId = intent.getExtras().getString("categoryId");
        categoryTitle = intent.getExtras().getString("categoryTitle");
        categoryDescription = intent.getExtras().getString("categoryDescription");
        categoryImageUrl = intent.getExtras().getString("categoryImageUrl");

        txtTitle.setText(categoryTitle);
        txtDescription.setText(categoryDescription);

        Picasso.get().load(categoryImageUrl).placeholder(R.drawable.ic_launcher_background)
                .into(imgCategory);

    }
}
