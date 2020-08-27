package com.example.submission2.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.submission2.Connection.ApiService;
import com.example.submission2.Connection.RetrofitClient;
import com.example.submission2.Response.User;
import com.example.submission2.Response.UserSearchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

    private MutableLiveData<ArrayList<User>> userData = new MutableLiveData<>();

    public void setUserSVM(String query) {

        try {
            String token = "eef8d4a980d5d84afdff78637599c8a7bf00109a";
            ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
            Call<UserSearchResponse> eventCall = apiService.getUserSearch(token, query);
            eventCall.enqueue(new Callback<UserSearchResponse>() {

                @Override
                public void onResponse(Call<UserSearchResponse> call, Response<UserSearchResponse> response) {

                    if (!response.isSuccessful()) {
                        Log.d("On Response : ....", response.message());
                    }
                    else if (response.body() != null) {
                        ArrayList<User> userItem = new ArrayList<>(response.body().getUsers());
                        userData.postValue(userItem);
                    }



                }

                @Override
                public void onFailure(Call<UserSearchResponse> call, Throwable t) {
                    Log.e("On Failure : ....", t.toString());
                }
            });

        } catch (Exception e) {

        }

    }
    public LiveData<ArrayList<User>> getUserSVM() {

        return userData;
    }
}
