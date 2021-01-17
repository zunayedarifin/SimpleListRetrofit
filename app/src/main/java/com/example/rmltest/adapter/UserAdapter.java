package com.example.rmltest.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rmltest.R;
import com.example.rmltest.activity.DetailsActivity;
import com.example.rmltest.databinding.CallListAdapterBinding;
import com.example.rmltest.model.DataItem;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CallHolder> {

    private Context mContext;
    private ArrayList<DataItem> dataArrayList;
    private LayoutInflater layoutInflater;

    public UserAdapter(Context mContext, ArrayList<DataItem> forumsData) {
        this.mContext = mContext;
        this.dataArrayList = forumsData;
    }


    @NonNull
    @Override
    public CallHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        mContext = viewGroup.getContext();
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        CallListAdapterBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.call_list_adapter, viewGroup, false);

        return new CallHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CallHolder itemView, final int position) {

        DataItem data = dataArrayList.get(position);

        itemView.binding.tvDoctorName.setText(data.getName());

        itemView.binding.llDoctorProfile.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.putExtra("user_data", data);
            mContext.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class CallHolder extends RecyclerView.ViewHolder {
        private final CallListAdapterBinding binding;

        CallHolder(final CallListAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}
