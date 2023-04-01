package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class EelEnemy implements Enemy{
    private Bitmap image;
    private int x;
    private int y;
    private int speed;
    private int EelGap;

    // Screen height = 1794 AND screen Width = 1080

    public EelEnemy(Bitmap bmp, int x, int y, int EelGap, int speed) {
        image = bmp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.EelGap = EelGap; // This isn't being used right either
    }

    public boolean offScreen() {
        if (this.x <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.x + EelGap, this.y, null);
    }

    @Override
    public void update(float delta) {
        this.x -= delta;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void spawn() {
        // idk if we need this
    }

}


