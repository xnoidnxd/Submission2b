package com.example.submission2.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission2.Connection.ApiService;
import com.example.submission2.Connection.RetrofitClient;
import com.example.submission2.Response.FollowingResponse;
import com.example.submission2b.BuildConfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowingViewModel extends ViewModel {
    private MutableLiveData<ArrayList<FollowingResponse>> userData;
    public void setDataFollowing(String username) {
        try {
            ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
            String token = BuildConfig.TOKEN;
            Call<ArrayList<FollowingResponse>> eventCall = apiService.getFollowing(token,username);
            eventCall.enqueue(new Callback<ArrayList<FollowingResponse>>() {

                private Response<ArrayList<FollowingResponse>> response;

                @Override
                public void onResponse(Call<ArrayList<FollowingResponse>> call, Response<ArrayList<FollowingResponse>> response) {
                    this.response = response;
                    userData.setValue(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<FollowingResponse>> call, Throwable t) {
                    Log.e("failure", t.toString());

                }
            });
        } catch (Exception e) {
            Log.d("token e", String.valueOf(e));
        }
    }
    public LiveData<ArrayList<FollowingResponse>> getDataFollowing() {
        if (userData == null) {
            userData = new MutableLiveData<>();
        }
        return userData;
    }

}
