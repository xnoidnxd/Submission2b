package com.example.submission2.UserInterface;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submission2.Adapter.FollowersAdapter;
import com.example.submission2.Response.FollowersResponse;
import com.example.submission2.ViewModel.FollowersViewModel;

import com.example.submission2b.R;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;


public class FollowersFragment extends Fragment {

    public static final String KEY_FOLLOWER = "key_follower";

    private RecyclerView recyclerView;
    private FollowersViewModel followersViewModel;
    private FollowersAdapter followersAdapter;

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    ArrayList<FollowersResponse> followersResponse = new ArrayList<>();
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_followers, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        followersViewModel = ViewModelProviders.of(requireActivity()).get(FollowersViewModel.class);

        if (savedInstanceState == null){

        }else {
            followersResponse = savedInstanceState.getParcelableArrayList(KEY_FOLLOWER);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_follower);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_frame_layout1);


        followersAdapter = new FollowersAdapter();
        followersAdapter.setOnItemClickCallback(new FollowersAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(FollowersResponse followersResponse) {
                showSelectedItem(followersResponse);
            }
        });
        showRecyclerView();
        getData();
    }

    private void getData() {
        followersViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FollowersViewModel.class);
        followersViewModel.setDataFollower(DetailUserActivity.clickedUser);
        followersViewModel.getDataFollowers().observe(getViewLifecycleOwner(), new Observer<ArrayList<FollowersResponse>>() {
            @Override
            public void onChanged(ArrayList<FollowersResponse> followerResponses) {
                shimmerFrameLayout.setVisibility(View.GONE);
                shimmerFrameLayout.stopShimmer();
                followersAdapter.setData(followersResponse);
                followersResponse.addAll(followerResponses);
                recyclerView.setAdapter(followersAdapter);
                followersAdapter.notifyDataSetChanged();
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
        followersViewModel.setDataFollower(DetailUserActivity.clickedUser);
    }

    private void showSelectedItem(FollowersResponse item) {
        Intent intent = new Intent(getContext(), DetailUserActivity.class);
        intent.putExtra("EXTRA_DATA", item.getLogin());
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_FOLLOWER, followersResponse);
        super.onSaveInstanceState(outState);

    }
}