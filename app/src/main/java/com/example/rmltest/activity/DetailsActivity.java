package com.example.rmltest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.rmltest.R;
import com.example.rmltest.databinding.ActivityDetailsBinding;
import com.example.rmltest.model.dekur.MessageItem;
import com.example.rmltest.model.users.DataItem;
import com.example.rmltest.shared_preference.AppPrefsManager;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {


    ActivityDetailsBinding binding;
    Context mContext;
    AppPrefsManager appPrefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        mContext=this;
        appPrefsManager = new AppPrefsManager(mContext);
        MessageItem dataItem = (MessageItem) getIntent().getSerializableExtra("user_data");
        if (dataItem != null) {
            binding.name.setText(dataItem.getName());
            binding.email.setText(dataItem.getNumber());
            binding.gender.setText(dataItem.getBirthDay());
//            binding.status.setText(dataItem.getStatus());
//            binding.created.setText(dataItem.getCreatedAt());
        }
        binding.llChamberToolbar.ivCustomBack.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        binding.llChamberToolbar.tvCustomDone.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            appPrefsManager.setIsLogin(false);
            finish();
        });
        Picasso.get().load(dataItem.getImage()).placeholder(R.drawable.ic_placeholder   )
                .fit()
                .centerCrop()
                .into(binding.ivProfileToolbar);
    }
}