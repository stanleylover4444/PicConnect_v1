package com.PicConnect.myapplication.CustomAdapter.Home;

import android.view.View;
import android.widget.ImageView;
import androidx.camera.view.PreviewView;
import androidx.recyclerview.widget.RecyclerView;
import com.PicConnect.myapplication.R;

public class TakePicViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    PreviewView previewView;
    ImageView flipCamera;



    public TakePicViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.takepic_backgroundView);
        previewView = itemView.findViewById(R.id.cameraPreview);
        flipCamera = itemView.findViewById(R.id.mFlipCamera);
    }
}
