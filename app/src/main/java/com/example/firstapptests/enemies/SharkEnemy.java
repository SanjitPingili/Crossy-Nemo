package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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
        float tempX = (float) x;
        float tempY = (float) y;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawRect(tempX+30,tempY+0,tempX+100,tempY+100, paint);
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

    public boolean intersectsCoords(int x1, int x2, int y1, int y2) {
        int bx1 = x + 30;
        int by1 = y + 0;
        int bx2 = x + 100;
        int by2 = y + 100;
        int by = (by2+by1)/2;
        if (by+30 >= y1 && by-30 <= y2) {
            if (x1 < bx2 && x1 > bx1) {
                return true;
            }
        }
        return false;
    }

    public boolean intersectsBox(int[] box) {
        int x1 = box[0];
        int y1 = box[1];
        int x2 = box[2];
        int y2 = box[3];
        return intersectsCoords(x1, x2, y1, y2);
    }

}
