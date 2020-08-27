package com.example.submission2.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.submission2.Adapter.UserSearchAdapter;
import com.example.submission2.Response.User;
import com.example.submission2.ViewModel.SearchViewModel;


import com.example.submission2b.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvUser;
    SearchView svUser;
    UserSearchAdapter userSearchAdapter;
    SearchViewModel searchViewModel;
    ImageView imageView2;
    TextView textView2;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setVisibility(View.VISIBLE);
        textView2 = findViewById(R.id.textImageView2);
        textView2.setVisibility(View.VISIBLE);


        showRecyclerList();
        searchViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SearchViewModel.class);
        searchViewModel.getUserSVM().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> searchUser) {
                progressBar.setVisibility(View.GONE);

                if (searchUser.size() != 0) {
                    userSearchAdapter.setDataUSA(searchUser);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.user_not_found), Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void showRecyclerList(){
        rvUser = findViewById(R.id.rv_users);
        svUser = findViewById(R.id.sv_users);

        rvUser.setLayoutManager(new LinearLayoutManager(this));

        userSearchAdapter = new UserSearchAdapter(this);
        rvUser.setAdapter(userSearchAdapter);
        userSearchAdapter.notifyDataSetChanged();

        svUser.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchViewModel.setUserSVM(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textView2.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                searchViewModel.setUserSVM(newText);





                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

}