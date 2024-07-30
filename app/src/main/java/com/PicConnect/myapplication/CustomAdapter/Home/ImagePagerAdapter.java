package com.PicConnect.myapplication.CustomAdapter.Home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.PicConnect.myapplication.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ImagePagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_IMAGE = 0;
    private static final int VIEW_TYPE_TAKE_PIC = 1;

    private final Context context;
    private final List<Integer> imageResources;
    private final List<Integer> imgViewTakePic;
    private final LifecycleOwner lifecycleOwner;
    private final AdapterCallback adapterCallback;

    private int cameraFacing = CameraSelector.LENS_FACING_BACK;
    private boolean isCameraActive = false;
    private ProcessCameraProvider cameraProvider;

    public interface AdapterCallback {
        void onImageViewClicked();
    }

    public ImagePagerAdapter(Context context, List<Integer> imageResources, List<Integer> imgViewTakePic, LifecycleOwner lifecycleOwner, AdapterCallback adapterCallback) {
        this.context = context;
        this.imageResources = imageResources;
        this.imgViewTakePic = imgViewTakePic;
        this.lifecycleOwner = lifecycleOwner;
        this.adapterCallback = adapterCallback;

        ListenableFuture<ProcessCameraProvider> listenableFuture = ProcessCameraProvider.getInstance(context);
        listenableFuture.addListener(() -> {
            try {
                cameraProvider = listenableFuture.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }, ContextCompat.getMainExecutor(context));
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
            return new TakePicViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.viewpager_img, parent, false);
            return new ImageViewHolder(view, adapterCallback);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_TAKE_PIC) {
            TakePicViewHolder takePicViewHolder = (TakePicViewHolder) holder;
            takePicViewHolder.imageView.setImageResource(imgViewTakePic.get(0));

            if (!isCameraActive) {
                startCamera(takePicViewHolder.previewView);
                isCameraActive = true;
            }

            takePicViewHolder.flipCamera.setOnClickListener(v -> {
                cameraFacing = (cameraFacing == CameraSelector.LENS_FACING_BACK) ?
                        CameraSelector.LENS_FACING_FRONT : CameraSelector.LENS_FACING_BACK;
                startCamera(takePicViewHolder.previewView);
            });
        } else {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;

            imageViewHolder.imageView.setImageResource(imageResources.get(position - 1));

            if (isCameraActive) {
                stopCamera();
                isCameraActive = false;
            }
        }
    }

    @Override
    public int getItemCount() {
        return imageResources.size() + 1;
    }

    private void startCamera(PreviewView previewView) {
        int aspectRatio = aspectRatio(previewView.getWidth(), previewView.getHeight());

        if (cameraProvider == null) {
            ListenableFuture<ProcessCameraProvider> listenableFuture = ProcessCameraProvider.getInstance(context);
            listenableFuture.addListener(() -> {
                try {
                    cameraProvider = listenableFuture.get();
                    configureCamera(previewView, aspectRatio);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }, ContextCompat.getMainExecutor(context));
        } else {
            configureCamera(previewView, aspectRatio);
        }
    }

    private void configureCamera(PreviewView previewView, int aspectRatio) {
        Preview preview = new Preview.Builder()
                .setTargetAspectRatio(aspectRatio)
                .build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(cameraFacing)
                .build();

        cameraProvider.unbindAll();
        //Om camera
      //  Camera camera = cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview);

        preview.setSurfaceProvider(previewView.getSurfaceProvider());
    }

    private void stopCamera() {
        if (cameraProvider != null) {
            cameraProvider.unbindAll();
        }
    }

    private int aspectRatio(int width, int height) {
        double previewRatio = (double) Math.max(width, height) / Math.min(width, height);
        if (Math.abs(previewRatio - 4.0 / 3.0) <= Math.abs(previewRatio - 16.0 / 9.0)) {
            return AspectRatio.RATIO_4_3;
        }
        return AspectRatio.RATIO_16_9;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView imageButtonCallBack;

        ImageViewHolder(View itemView, AdapterCallback adapterCallback) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_backgroundView);
            imageButtonCallBack = itemView.findViewById(R.id.mButtonCallBack);
            imageButtonCallBack.setOnClickListener(v -> adapterCallback.onImageViewClicked());
        }
    }

    static class TakePicViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        PreviewView previewView;
        ImageView flipCamera;

        TakePicViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.takepic_backgroundView);
            previewView = itemView.findViewById(R.id.cameraPreview);
            flipCamera = itemView.findViewById(R.id.mFlipCamera);
        }
    }
}
