package com.example.submission2.Connection;

import com.example.submission2.Response.FollowersResponse;
import com.example.submission2.Response.FollowingResponse;
import com.example.submission2.Response.UserResponse;
import com.example.submission2.Response.UserSearchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    @GET("users/{username}/following")
    Call<ArrayList<FollowingResponse>> getFollowing(@Header("Authorization") String authorization,
                                                    @Path("username") String username);

    @GET("users/{username}/followers")
    Call<ArrayList<FollowersResponse>> getFollowers(@Header("Authorization") String authorization,
                                                    @Path("username") String username);

    @GET("users/{username}")
    Call<UserResponse> userDetail(@Header("Authorization") String token,
                                  @Path("username") String username);
    @GET("/search/users")
    Call<UserSearchResponse> getUserSearch(@Header("Authorization") String authorization,
                                           @Query("q") String username );


//    https://api.github.com/search/users?q={username}
//    https://api.github.com/users/{username}
//    https://api.github.com/users/{username}/followers
//    https://api.github.com/users/{username}/following

}
