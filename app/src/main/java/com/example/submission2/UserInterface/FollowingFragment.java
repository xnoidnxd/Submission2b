package com.example.submission2.UserInterface;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.submission2.Adapter.FollowingAdapter;
import com.example.submission2.Response.FollowingResponse;
import com.example.submission2.ViewModel.FollowingViewModel;

import com.example.submission2b.R;


import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;


public class FollowingFragment extends Fragment {

    public static final String KEY_FOLLOWING = "key_following";

    private RecyclerView recyclerView;
    private FollowingViewModel followingViewModel;
    private FollowingAdapter followingAdapter;

    ShimmerFrameLayout shimmerFrameLayout;

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    ArrayList<FollowingResponse> followingResponse = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_following, container, false);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){

        }
        else {
            followingResponse = savedInstanceState.getParcelableArrayList(KEY_FOLLOWING);
        }

        followingViewModel = ViewModelProviders.of(this).get(FollowingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_following);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_frame_layout2);


        followingAdapter = new FollowingAdapter();
        followingAdapter.setOnItemClickCallback(new FollowingAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(FollowingResponse followingResponse) {
                showSelectedItem(followingResponse);
            }
        });
        showRecyclerView();
        getData();
    }

    private void getData() {
        followingViewModel.setDataFollowing(DetailUserActivity.clickedUser);
        followingViewModel.getDataFollowing().observe(getViewLifecycleOwner(), new Observer<ArrayList<FollowingResponse>>() {
            @Override
            public void onChanged(ArrayList<FollowingResponse> followingResponses) {
                shimmerFrameLayout.setVisibility(View.GONE);
                shimmerFrameLayout.stopShimmer();
                followingAdapter.setData(followingResponse);
                followingResponse.addAll(followingResponses);
                recyclerView.setAdapter(followingAdapter);
                followingAdapter.notifyDataSetChanged();
            }
        });
    }
    private void showRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void onResume() {
        super.onResume();
        followingViewModel.setDataFollowing(DetailUserActivity.clickedUser);

    }
    private void showSelectedItem(FollowingResponse item) {
        Intent intent = new Intent(getContext(), DetailUserActivity.class);
        intent.putExtra("EXTRA_DATA", item.getLogin());
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_FOLLOWING, followingResponse);
        super.onSaveInstanceState(outState);
    }
}