package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class GoalTile {
    private Bitmap image;

    public GoalTile(Bitmap bmp) {

        image = bmp;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(image, 0, 0, null);
    }

}
