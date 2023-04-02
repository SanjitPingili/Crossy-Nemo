package com.example.firstapptests.tiles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class RiverTile {
    private Bitmap image;

    public RiverTile(Bitmap bmp) {

        image = bmp;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(image, 0, 200, null);
    }

}
