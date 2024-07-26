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
            return VIEW_TYPE_IMAGE;
        } else {
            return VIEW_TYPE_TAKE_PIC;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_IMAGE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_take_pic, parent, false);
            return new TakePicViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_IMAGE) {
            ((ImageViewHolder) holder).imageView.setImageResource(imageResources.get(position));
        } else {
            // Handle takePicView binding logic if needed
        }
    }

    @Override
    public int getItemCount() {
        return imageResources.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    static class TakePicViewHolder extends RecyclerView.ViewHolder {
        // Define takePicView components

        TakePicViewHolder(View itemView) {
            super(itemView);
            // Initialize takePicView components
        }
    }
}
