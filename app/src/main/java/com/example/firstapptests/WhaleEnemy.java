package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class WhaleEnemy implements Enemy{
    private Bitmap image;
    private int x;
    private int y;
    private int speed;
    private int WhaleGap;

    // Screen height = 1794 AND screen Width = 1080

    public WhaleEnemy(Bitmap bmp, int x, int y, int WhaleGap, int speed) {
        image = bmp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.WhaleGap = WhaleGap; // This isn't being used right either
    }

    public boolean offScreen() {
        if (this.x <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.x + WhaleGap, this.y, null);
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
