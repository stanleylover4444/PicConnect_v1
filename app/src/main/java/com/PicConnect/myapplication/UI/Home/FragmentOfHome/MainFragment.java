package com.PicConnect.myapplication.UI.Home.FragmentOfHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.PicConnect.myapplication.CustomAdapter.ImagePagerAdapter;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ImagePagerAdapter.AdapterCallback {

    private ViewPager2 viewPager2Main;
    private ImagePagerAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager2Main = view.findViewById(R.id.viewPager2_Main);

        List<Integer> imageResources = new ArrayList<>();
        imageResources.add(R.drawable.deptrai);
        imageResources.add(R.drawable.songuku);
        imageResources.add(R.drawable.avta);
        imageResources.add(R.drawable.songuku);
        imageResources.add(R.drawable.baki);

        List<Integer> imgViewTakePic = new ArrayList<>();
        imgViewTakePic.add(R.drawable.baki);

        adapter = new ImagePagerAdapter(getContext(), imageResources, imgViewTakePic, getViewLifecycleOwner(), this);
        viewPager2Main.setAdapter(adapter);
        viewPager2Main.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        return view;
    }

    @Override
    public void onImageViewClicked() {
        // Chuyển về VIEW_TYPE_TAKE_PIC
        viewPager2Main.setCurrentItem(0, true); // Chuyển về trang đầu tiên (VIEW_TYPE_TAKE_PIC)
    }
}
