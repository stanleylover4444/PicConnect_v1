package com.PicConnect.myapplication.UI.Home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.PicConnect.myapplication.CustomAdapter.ViewPager2AdapterHor;
import com.PicConnect.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager_2;
    private ViewPager2AdapterHor viewPager2AdapterHor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager_2 = findViewById(R.id.viewPager_2);
        viewPager2AdapterHor = new ViewPager2AdapterHor(this);
        viewPager_2.setAdapter(viewPager2AdapterHor);
        viewPager_2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager_2.setCurrentItem(1);
    }
}
