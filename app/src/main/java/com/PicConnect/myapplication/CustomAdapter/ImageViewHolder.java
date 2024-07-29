package com.PicConnect.myapplication.CustomAdapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.PicConnect.myapplication.R;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView imgViewBackgourd;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imgViewBackgourd = itemView.findViewById(R.id.img_backgroundView);
    }
}
