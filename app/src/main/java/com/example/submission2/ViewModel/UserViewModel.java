package com.example.submission2.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission2.Connection.ApiService;
import com.example.submission2.Connection.RetrofitClient;

import com.example.submission2.Response.UserResponse;




import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    private MutableLiveData<UserResponse> userData;

    public void setUserUVM(String query) {
        try {
            String token = "eef8d4a980d5d84afdff78637599c8a7bf00109a";
            ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
            Call<UserResponse> eventCall = apiService.userDetail(token, query);
            eventCall.enqueue(new Callback<UserResponse>() {

                private Response<UserResponse> uvmResponse;

                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    this.uvmResponse = response;
                    userData.setValue(response.body());

                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Log.e("onFailure: ...", t.toString());
                }
            });

        } catch (Exception e) {
            Log.d("Exception", e.getMessage());
        }
    }
    public LiveData<UserResponse> getUserUVM() {
        if (userData == null) {
            userData = new MutableLiveData<>();
        }
        return userData;
    }
}
