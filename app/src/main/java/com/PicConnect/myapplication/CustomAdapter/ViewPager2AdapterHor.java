package com.PicConnect.myapplication.CustomAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.PicConnect.myapplication.UI.Chat.FragnentOfChat.ChatFragment;
import com.PicConnect.myapplication.UI.Home.FragmentOfHome.MainFragment;
import com.PicConnect.myapplication.UI.Setting.FragmentOfSetting.SettingFragment;

public class ViewPager2AdapterHor extends FragmentStateAdapter {

    public ViewPager2AdapterHor(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SettingFragment();
            case 1 :
                return new MainFragment();
            case 2 :
                return new ChatFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
