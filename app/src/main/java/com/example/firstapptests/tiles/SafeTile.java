package com.example.firstapptests.tiles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SafeTile {
    private Bitmap image;

    public SafeTile(Bitmap bmp) {

        image = bmp;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(image, 0, 1000, null);
    }

}
