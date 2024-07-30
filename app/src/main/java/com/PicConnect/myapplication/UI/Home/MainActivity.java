package com.PicConnect.myapplication.UI.Home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.PicConnect.myapplication.CustomAdapter.FragmentAdapter;
import com.PicConnect.myapplication.R;

public class MainActivity extends AppCompatActivity {

    // Khai báo biến cho ViewPager2 và adapter
    private ViewPager2 BackgroundMain;
    private FragmentAdapter viewPager2AdapterHor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Nạp layout cho Activity

        // Khởi tạo ViewPager2 và FragmentAdapter
        BackgroundMain = findViewById(R.id.viewBGMain);
        viewPager2AdapterHor = new FragmentAdapter(this);

        // Gán adapter cho ViewPager2
        BackgroundMain.setAdapter(viewPager2AdapterHor);

        // Thiết lập chế độ cuộn ngang cho ViewPager2
        BackgroundMain.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Đặt trang mặc định là Fragment ở vị trí 1 (Fragment 2)
        BackgroundMain.setCurrentItem(1);
    }
}
