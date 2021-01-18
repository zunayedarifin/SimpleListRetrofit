package com.example.rmltest.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rmltest.model.dekur.DekurUserResponse;
import com.example.rmltest.model.users.UserResponse;
import com.example.rmltest.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository();

    }

    public LiveData<UserResponse> userDetails() {
        return repository.userDetails();
    }
    public LiveData<DekurUserResponse> dekurUserList() {
        return repository.dekurUserDetails();
    }

}
