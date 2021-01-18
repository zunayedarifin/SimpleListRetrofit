package com.example.rmltest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.rmltest.R;
import com.example.rmltest.adapter.UserAdapter;
import com.example.rmltest.databinding.ActivityMainBinding;
import com.example.rmltest.shared_preference.AppPrefsManager;
import com.example.rmltest.viewModel.UserViewModel;

public class MainActivity extends AppBaseActivity {

    private ActivityMainBinding binding;
    UserViewModel viewModel;
    UserAdapter adapter;
    private Context mContext;
    AppPrefsManager appPrefsManager;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        mContext=this;
        appPrefsManager = new AppPrefsManager(mContext);
        binding.llChamberToolbar.ivCustomBack.setVisibility(View.INVISIBLE);
        binding.llChamberToolbar.tvCustomDone.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            appPrefsManager.setIsLogin(false);
            finish();
        });
        layoutManager = new LinearLayoutManager(mContext);
        viewModel.dekurUserList().observe(this, userResponse -> {
            adapter = new UserAdapter(mContext,userResponse.getMessage());
            binding.recyclerView.setLayoutManager(layoutManager);
            binding.recyclerView.setAdapter(adapter);
        });
    }
}