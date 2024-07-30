package com.PicConnect.myapplication.CustomAdapter.Chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.DTOS.ChatDTO;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatFriendViewHolder> {

    private Context mContext;
    private ArrayList<ChatDTO> mChatDTOS;

    public ChatListAdapter(Context mContext) {
        this.mContext = mContext;
        this.mChatDTOS = new ArrayList<>();
    }

    public void setData(ArrayList<ChatDTO> chatDTOArrayList) {
        this.mChatDTOS = chatDTOArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chatfriend, parent, false);
        return new ChatFriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatFriendViewHolder holder, int position) {
        ChatDTO chatDTO = mChatDTOS.get(position);
        if (chatDTO == null) {
            return;
        }
        // Assuming these methods exist in ChatDTO
        holder.avatarFriend.setImageResource(chatDTO.getFriendProfilePictureUrl());
        holder.nameFriend.setText(chatDTO.getFriendUsername());
        holder.lastMessage.setText(chatDTO.getLastMessageId());
        holder.lastMessageTime.setText(chatDTO.getLastMessageTimestamp());
    }

    @Override
    public int getItemCount() {
        if (mChatDTOS != null) {
            return mChatDTOS.size();
        }
        return 0;
    }

    public static class ChatFriendViewHolder extends RecyclerView.ViewHolder {

        private ImageView avatarFriend;
        private TextView nameFriend, lastMessage, lastMessageTime;

        public ChatFriendViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarFriend = itemView.findViewById(R.id.img_FriendChat);
            nameFriend = itemView.findViewById(R.id.text_NameFriendChat);
            lastMessage = itemView.findViewById(R.id.text_lastMessage);
            lastMessageTime = itemView.findViewById(R.id.text_lasttimeMessage);
        }
    }
}
