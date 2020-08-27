package com.example.submission2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submission2.Response.FollowersResponse;
import com.example.submission2b.R;

import java.util.ArrayList;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    private ArrayList<FollowersResponse> followersData = new ArrayList<>();

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<FollowersResponse> followerData) {
        this.followersData.clear();
        this.followersData.addAll(followerData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FollowersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup,false);
        return new FollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FollowersViewHolder holder, int position) {
        FollowersResponse item = followersData.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getAvatarUrl())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgProfile);

        holder.tvName.setText(item.getLogin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(followersData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return followersData.size();
    }

    public class FollowersViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProfile;
        TextView tvName;
        public FollowersViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(FollowersResponse followersResponse);
    }
}
