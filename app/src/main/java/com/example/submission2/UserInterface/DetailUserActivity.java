package com.example.submission2.UserInterface;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.submission2.Response.UserResponse;
import com.example.submission2.ViewModel.UserViewModel;
import com.example.submission2b.R;

import com.google.android.material.tabs.TabLayout;

public class DetailUserActivity extends AppCompatActivity {
    private TextView tvName, tvNickname, tvLocation, tvCompany, tvEmail, tvWebsite;
    private TextView tvCountFollowers, tvCountRepository, tvCountFollowing;
    private ImageView imgProfile;
    ProgressBar progressBar;

    public static String clickedUser;
    UserViewModel userViewModel;

    private ViewPager viewPager;
    TabLayout tabLayout;

    private final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_user_activity);
        tvName = findViewById(R.id.tv_item_name);
        tvNickname = findViewById(R.id.tv_item_nickname);
        tvLocation = findViewById(R.id.tv_item_location);
        tvCompany = findViewById(R.id.tv_item_company);
        tvEmail = findViewById(R.id.tv_item_email);
        tvWebsite = findViewById(R.id.tv_item_website);
        imgProfile = findViewById(R.id.img_item_photo);
        tvCountFollowers = findViewById(R.id.tv_count_follower);
        tvCountRepository = findViewById(R.id.tv_count_repo);
        tvCountFollowing = findViewById(R.id.tv_count_following);
        progressBar = findViewById(R.id.progressbar2);

        //        if (savedInstanceState != null){
//            followingFragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FOLLOWING);
//            //
////            followerFragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FOLLOWER);
////            getSupportFragmentManager().beginTransaction().replace(R.id.tv_view_pager, followerFragment).commit();
//        } else {
//            followingFragment = new FollowingFragment();
//
////            followerFragment = new FollowersFragment();
////            getSupportFragmentManager().beginTransaction().replace(R.id.tv_view_pager, followerFragment).commit();
//            getSupportFragmentManager().beginTransaction().replace(R.id.tv_view_pager, followingFragment).commit();
//        }

        setForUserData();
        setForTabLayout();
    }


    private void setForUserData(){
        Intent detailIntent = getIntent();
        clickedUser = detailIntent.getStringExtra("EXTRA_DATA");
        userViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(UserViewModel.class);
        userViewModel.setUserUVM(clickedUser);
        userViewModel.getUserUVM().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                progressBar.setVisibility(View.GONE);
                Glide.with(getApplicationContext())
                        .load(userResponse.getAvatarUrl())
                        .into(imgProfile);
                tvName.setText(userResponse.getLogin());
                tvLocation.setText(userResponse.getLocation());
                tvNickname.setText(userResponse.getName());
                tvCompany.setText(userResponse.getCompany());
                tvEmail.setText(userResponse.getEmail());
                tvWebsite.setText(userResponse.getBlog());

                tvCountRepository.setText(String.valueOf(userResponse.getPublicRepos()));
                tvCountFollowers.setText(String.valueOf(userResponse.getFollowers()));
                tvCountFollowing.setText(String.valueOf(userResponse.getFollowing()));
            }
        });
    }

    //cast tab and view pager
    private void setForTabLayout(){
        tabLayout = findViewById(R.id.tv_tab_layout);
        viewPager = findViewById(R.id.tv_view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int totalTab;
        @SuppressWarnings("deprecation")
        ViewPagerAdapter(FragmentManager fragmentManager, int totalTabs) {
            super(fragmentManager);
            this.totalTab = totalTabs;
        }

        //connecting fragment to detail activity
        @SuppressWarnings("ConstantConditions")
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FollowersFragment();
                case 1:
                    return new FollowingFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return totalTab;
        }
    }

    //    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        getSupportFragmentManager().putFragment(outState, KEY_FOLLOWING, followingFragment );
////       getSupportFragmentManager().putFragment(outState, KEY_FOLLOWER, followerFragment);
//        super.onSaveInstanceState(outState);
//    }
}
