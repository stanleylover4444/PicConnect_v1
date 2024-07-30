package com.PicConnect.myapplication.UI.Chat.FragnentOfChat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.CustomAdapter.Chat.ChatListAdapter;
import com.PicConnect.myapplication.DTOS.ChatDTO;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView rcvItemChat;
    private ChatListAdapter chatListAdapter;

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // Find the RecyclerView in the inflated layout
            rcvItemChat = view.findViewById(R.id.rcv_itemchat);

        // Initialize the adapter
        chatListAdapter = new ChatListAdapter(getContext());




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        // Set up the RecyclerView
        rcvItemChat.setLayoutManager(linearLayoutManager);
        chatListAdapter.setData(getArraylistTimeChat());
        rcvItemChat.setAdapter(chatListAdapter);




        return view;
    }


        private ArrayList<ChatDTO> getArraylistTimeChat(){

            ArrayList<ChatDTO>chatDTOArrayList = new ArrayList<>();
            chatDTOArrayList.add(new ChatDTO("Thành Danh " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));
            chatDTOArrayList.add(new ChatDTO("Nguyễn Trương " , R.drawable.avta , "Anh yêu em" , "10ph trước"));

            return chatDTOArrayList;
        }
}
