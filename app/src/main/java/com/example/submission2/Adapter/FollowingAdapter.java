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
import com.example.submission2.Response.FollowingResponse;
import com.example.submission2b.R;

import java.util.ArrayList;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder> {

    private ArrayList<FollowingResponse> followingData = new ArrayList<>();

    private FollowingAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(FollowingAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setData(ArrayList<FollowingResponse> followingDatas) {
        this.followingData.clear();
        this.followingData.addAll(followingDatas);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FollowingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup,false);
        return new FollowingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FollowingViewHolder holder, int position) {
        FollowingResponse item = followingData.get(position);

        Glide.with(holder.itemView.getContext())
                .load(item.getAvatarUrl())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgProfile);

        holder.tvName.setText(item.getLogin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(followingData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return followingData.size();
    }

    public class FollowingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProfile;
        TextView tvName;
        public FollowingViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(FollowingResponse followingResponse);
    }
}
