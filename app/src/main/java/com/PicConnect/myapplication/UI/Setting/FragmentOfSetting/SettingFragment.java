package com.PicConnect.myapplication.UI.Setting.FragmentOfSetting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.PicConnect.myapplication.BottomSheet.Setting.OpenBottomSheetFriend;
import com.PicConnect.myapplication.R;

public class SettingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout layoutLinearFriend;




    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        layoutLinearFriend = view.findViewById(R.id.laypoutLinearFriend);
        layoutLinearFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBottomSheetFriend bottomSheet = new OpenBottomSheetFriend();
                bottomSheet.show(getParentFragmentManager(), bottomSheet.getTag());
            }
        });






        return view;
    }
}
