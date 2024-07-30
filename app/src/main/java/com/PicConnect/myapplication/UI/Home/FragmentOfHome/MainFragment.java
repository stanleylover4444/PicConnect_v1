package com.PicConnect.myapplication.UI.Home.FragmentOfHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.PicConnect.myapplication.CustomAdapter.Home.ImagePagerAdapter;
import com.PicConnect.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ImagePagerAdapter.AdapterCallback {

    // Khai báo các biến cho view
    private ViewPager2 viewPager2Main;
    private ImagePagerAdapter adapter;
    private ViewPager2 FragmentHorzi;
    private ImageView mButtonSetting, mButtonChat;

    // Constructor mặc định
    public MainFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Nạp layout cho fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Khởi tạo các view
        mButtonSetting = view.findViewById(R.id.mAvata);
        mButtonChat = view.findViewById(R.id.mChatBtn);
        FragmentHorzi = requireActivity().findViewById(R.id.viewBGMain); // Lấy ViewPager2 từ activity

        // Thiết lập sự kiện khi nhấn nút Setting
        mButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Di chuyển đến Fragment ở vị trí 0
                if (FragmentHorzi != null) {
                    FragmentHorzi.setCurrentItem(0);
                }
            }
        });

        // Thiết lập sự kiện khi nhấn nút Chat
        mButtonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Di chuyển đến Fragment ở vị trí 2
                if (FragmentHorzi != null) {
                    FragmentHorzi.setCurrentItem(2);
                }
            }
        });

        // Khởi tạo ViewPager2 để hiển thị hình ảnh
        viewPager2Main = view.findViewById(R.id.viewPager2_Main);
        List<Integer> imageResources = new ArrayList<>();

        // Thêm các hình ảnh vào danh sách
        imageResources.add(R.drawable.deptrai);
        imageResources.add(R.drawable.songuku);
        imageResources.add(R.drawable.avta);
        imageResources.add(R.drawable.songuku);
        imageResources.add(R.drawable.baki);

        List<Integer> imgViewTakePic = new ArrayList<>();
        imgViewTakePic.add(R.drawable.baki);

        // Khởi tạo adapter và gán cho ViewPager2
        adapter = new ImagePagerAdapter(getContext(), imageResources, imgViewTakePic, getViewLifecycleOwner(), this);
        viewPager2Main.setAdapter(adapter);
        viewPager2Main.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        return view;
    }

    @Override
    public void onImageViewClicked() {
        // Di chuyển đến hình ảnh đầu tiên khi được nhấn
        viewPager2Main.setCurrentItem(0, true);
    }

    // Hàm điều hướng đến một Fragment cụ thể
    private void navigateToFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment); // Thay thế fragment trong ViewGroup với ID fragment_container
        transaction.addToBackStack(null); // Thêm vào back stack để có thể quay lại Fragment trước đó
        transaction.commit();
    }
}
