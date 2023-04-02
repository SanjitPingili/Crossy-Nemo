package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import com.example.firstapptests.Enemy;

public class SharkEnemy implements Enemy {
    private Bitmap image;
    private int x;
    private int y;
    private int speed;
    private int SharkGap;

    // Screen height = 1794 AND screen Width = 1080
    public SharkEnemy(int x, int y, int SharkGap, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.SharkGap = SharkGap; // This isn't being used right either
    }
    public int getSpeed() {
        return speed;
    }
    public SharkEnemy(Bitmap bmp, int x, int y, int SharkGap, int speed) {
        image = bmp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.SharkGap = SharkGap; // This isn't being used right either
    }

    public static boolean offScreen(int x) {
        if (x <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.x + SharkGap, this.y, null);
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
