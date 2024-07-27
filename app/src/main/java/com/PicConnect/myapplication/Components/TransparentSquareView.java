package com.PicConnect.myapplication.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TransparentSquareView extends View {

    private Paint paint;

    public TransparentSquareView(Context context) {
        super(context);
        init();
    }

    public TransparentSquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TransparentSquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK); // Thiết lập màu đen

        // Thiết lập độ mờ
        int alpha = 240; // Giá trị từ 0 đến 255, 128 là nửa trong suốt
        paint.setAlpha(alpha);
    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int saveLayer = canvas.saveLayer(0, 0, getWidth(), getHeight(), null);

        // Vẽ nền đen mờ
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        // Thiết lập Xfermode để tạo vùng trong suốt
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        float squareSize = 1100; // Fixed size of 600 pixels
        float verticalOffset = 200;


        float left = centerX - squareSize / 2;
        float top = centerY - squareSize / 2 - verticalOffset; // Di chuyển lên trên
        float right = centerX + squareSize / 2;
        float bottom = centerY + squareSize / 2 - verticalOffset; // Di chuyển lên trên
        float cornerRadius = 100.0f; // Bán kính bo góc
        RectF rectF = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        paint.setXfermode(null);

        canvas.restoreToCount(saveLayer);
    }

}
