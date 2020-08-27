package com.example.submission2.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission2.Connection.ApiService;
import com.example.submission2.Connection.RetrofitClient;
import com.example.submission2.Response.FollowersResponse;
import com.example.submission2b.BuildConfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowersViewModel extends ViewModel {
    private MutableLiveData<ArrayList<FollowersResponse>> userData;
    public void setDataFollower(String username) {
        try {
            ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
            String token = BuildConfig.TOKEN;
            Call<ArrayList<FollowersResponse>> eventCall = apiService.getFollowers(token,username);
            eventCall.enqueue(new Callback<ArrayList<FollowersResponse>>() {

                private Response<ArrayList<FollowersResponse>> response;

                @Override
                public void onResponse(Call<ArrayList<FollowersResponse>> call, Response<ArrayList<FollowersResponse>> response) {
                    this.response = response;
                    userData.setValue(response.body());

                }

                @Override
                public void onFailure(Call<ArrayList<FollowersResponse>> call, Throwable t) {
                    Log.e("failure", t.toString());

                }
            });
        } catch (Exception e) {
            Log.d("token e", String.valueOf(e));
        }
    }
    public LiveData<ArrayList<FollowersResponse>> getDataFollowers() {
        if (userData == null) {

            userData = new MutableLiveData<>();

        }
        return userData;
    }
}
