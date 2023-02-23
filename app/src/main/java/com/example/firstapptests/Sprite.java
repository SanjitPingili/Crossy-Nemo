package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class Sprite {
    private Bitmap image;

    public Sprite(Bitmap bmp) {
        image = bmp;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 630, 2100, null);
    }

}
