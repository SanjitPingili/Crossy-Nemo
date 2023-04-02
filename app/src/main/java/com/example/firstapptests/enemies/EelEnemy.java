package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class EelEnemy implements Enemy {
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
//        float tempX = (float) x;
//        float tempY = (float) y;
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        paint.setColor(Color.BLACK);
//        canvas.drawRect(tempX,tempY+100,tempX+320,tempY+220, paint);
        canvas.drawBitmap(image, this.x, this.y, null);
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
        int bx1 = x + 0;
        int by1 = y + 100;
        int bx2 = x + 320;
        int by2 = y + 220;
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


