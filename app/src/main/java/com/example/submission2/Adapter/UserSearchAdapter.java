package com.example.submission2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission2.Response.User;
import com.example.submission2b.R;

import com.example.submission2.UserInterface.DetailUserActivity;
import com.example.submission2.UserInterface.MainActivity;

import java.util.ArrayList;


public class UserSearchAdapter extends RecyclerView.Adapter<UserSearchAdapter.UserViewHolder>{

    private Context context;
    MainActivity mainActivity;
    private ArrayList<User> userList = new ArrayList<>();

    public UserSearchAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }



    public void setDataUSA(ArrayList<User> users) {
        this.userList.clear();
        this.userList.addAll(users);
        notifyDataSetChanged();
    }

    public UserSearchAdapter(Context context) {
        this.mainActivity = mainActivity;
        this.context = context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup, false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(user.getAvatarUrl())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgProfile);
        holder.tvName.setText(user.getLogin());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProfile;
        TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                User mUser = userList.get(position);
                Intent intent = new Intent(view.getContext(), DetailUserActivity.class);
                intent.putExtra("EXTRA_DATA", mUser.getLogin());
                view.getContext().startActivity(intent);

            }
        }
    }
}
