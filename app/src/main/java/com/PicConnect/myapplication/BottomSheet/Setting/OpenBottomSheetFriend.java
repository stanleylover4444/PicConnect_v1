package com.PicConnect.myapplication.BottomSheet.Setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.CustomAdapter.Setting.ListFriendAdapter;
import com.PicConnect.myapplication.DTOS.FriendDTO;
import com.PicConnect.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class OpenBottomSheetFriend extends BottomSheetDialogFragment {

    private RecyclerView recyclerViewListFriend;
    private ListFriendAdapter listFriendAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_friend, container, false);
        recyclerViewListFriend = view.findViewById(R.id.rcv_itemlistfriend);
        listFriendAdapter = new ListFriendAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewListFriend.setLayoutManager(linearLayoutManager);

        listFriendAdapter.setData(getArraylistItemFriend());
        recyclerViewListFriend.setAdapter(listFriendAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
        if (bottomSheetDialog != null) {
            View bottomSheetInternal = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (bottomSheetInternal != null) {
                BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheetInternal);

                behavior.setPeekHeight(ViewGroup.LayoutParams.MATCH_PARENT);
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        }
    }

    private ArrayList<FriendDTO> getArraylistItemFriend() {
        ArrayList<FriendDTO> listFriendDTOArrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            listFriendDTOArrayList.add(new FriendDTO("Thành Danh", R.drawable.avta));
        }
        return listFriendDTOArrayList;
    }
}
