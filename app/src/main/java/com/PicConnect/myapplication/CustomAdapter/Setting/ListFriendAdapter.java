package com.PicConnect.myapplication.CustomAdapter.Setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.DTOS.FriendDTO;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ListFriendViewHolder> {
    private Context mContext;
    private ArrayList<FriendDTO> mFriendDtos;

    public ListFriendAdapter(Context mContext) {
        this.mContext = mContext;
        this.mFriendDtos = new ArrayList<>();
    }

    public void setData(ArrayList<FriendDTO> friendDTOArrayList) {
        this.mFriendDtos = friendDTOArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_friendlist, parent, false);
        return new ListFriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFriendViewHolder holder, int position) {
        FriendDTO friendDTO = mFriendDtos.get(position);
        if (friendDTO == null) {
            return;
        }
        // Assuming these methods exist in FriendDTO
        holder.avatarFriend.setImageResource(friendDTO.getFriendProfilePictureUrl()); // Replace with the method to set the image
        holder.nameFriend.setText(friendDTO.getFriendUsername());
    }

    @Override
    public int getItemCount() {
        if (mFriendDtos != null) {
            return mFriendDtos.size();
        }
        return 0;
    }

    public static class ListFriendViewHolder extends RecyclerView.ViewHolder {

        private ImageView avatarFriend;
        private TextView nameFriend;

        public ListFriendViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarFriend = itemView.findViewById(R.id.img_AvataFriendLists);
            nameFriend = itemView.findViewById(R.id.text_NameFriendLists);
        }
    }
}
