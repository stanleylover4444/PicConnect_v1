package com.PicConnect.myapplication.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.R;

import java.util.List;

public class ImagePagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_IMAGE = 0;
    private static final int VIEW_TYPE_TAKE_PIC = 1;

    private final Context context;
    private final List<Integer> imageResources;

    public ImagePagerAdapter(Context context, List<Integer> imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_TAKE_PIC;
        } else {
            return VIEW_TYPE_IMAGE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_TAKE_PIC) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewpager_takeipc, parent, false);
            return new ImageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.viewpager_img, parent, false);
            return new TakePicViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_TAKE_PIC) {
            ((ImageViewHolder) holder).imageView.setImageResource(imageResources.get(position));
        } else  {
//            ((ImageViewHolder) holder).imageView.setImageResource(imageResources.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return imageResources.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageView1;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.takepic_backgroundView);


            imageView1 = itemView.findViewById(R.id.img_backgroundView);
        }
    }

    static class TakePicViewHolder extends RecyclerView.ViewHolder {
        // Định nghĩa các thành phần của takePicView

        TakePicViewHolder(View itemView) {
            super(itemView);
            // Khởi tạo các thành phần của takePicView
        }
    }
}
