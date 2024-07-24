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

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ViewHolder> {

    private final Context context;
    private final List<Integer> imageResources;

    public ImagePagerAdapter(Context context, List<Integer> imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(imageResources.get(position));
    }

    @Override
    public int getItemCount() {
        return imageResources.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
