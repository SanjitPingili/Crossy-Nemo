package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class SafeTile {
    private Bitmap image;

    public SafeTile(Bitmap bmp) {

        image = bmp;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(image, 0, 1000, null);
    }

}
