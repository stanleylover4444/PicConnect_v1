package com.PicConnect.myapplication.UI.Home.FragmentOfHome;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.PicConnect.myapplication.CustomAdapter.ImagePagerAdapter;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Khởi tạo ViewPager2
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);

        // Tạo danh sách hình ảnh
        List<Integer> imageResources = new ArrayList<>();
        imageResources.add(R.drawable.avta); // Thay đổi tên hình ảnh
        imageResources.add(R.drawable.avta); // Thay đổi tên hình ảnh
        // Thêm các hình ảnh khác vào danh sách

        // Tạo adapter và gán cho ViewPager2
        ImagePagerAdapter adapter = new ImagePagerAdapter(getContext(), imageResources);
        viewPager2.setAdapter(adapter);

        // Cài đặt hướng của ViewPager2
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        return view;
    }
}
