package com.example.firstapptests;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Log {
    int x,y;
    int width;
    int speed;
    int direction;
    int height = LogLane.logHeight;
    boolean hasPlayer = false;

    public Log(int x, int y, int width, int speed, int direction) {
        this.direction = direction;
        this.speed = speed * direction;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void draw(Canvas canvas) {
        float x1 = (float) x;
        float y1 = (float) y;
        Paint paint = new Paint();
        paint.setColor(Color.argb(255, 181, 101, 30));
        canvas.drawRect(x1,y1 + 10,x1+width, y1+height, paint);
    }
    public void update() {
        x += speed;
//        if (x+width > 1400) {
//            speed = -20;
//        }
//        if (x < 0) {
//            speed = 20;
//        }
    }
    public boolean offScreen() {
        if (direction == 1 && x > 1400) {
            return true;
        }
        if (direction == -1 && x+width < 0) {
            return true;
        }
        return false;
    }

    public boolean intersects(int x1, int x2, int y1, int y2) {
        int bx1 = x;
        int by1 = y;
        int bx2 = x + width;
        int by2 = y + height;
        int by = (by2+by1)/2;
        if (by+30 >= y1 && by-30 <= y2) {
            if ((x1 < bx2 && x1 > bx1)) {
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
        return intersects(x1, x2, y1, y2);
    }

    public int getCenterX() {
        return x + width/2;
    }
    public int getCenterY() {
        return (y+height/2);
    }

    public int getSpeed() {
        return speed;
    }

    public void attach() {
        hasPlayer = true;
    }

    public void detach() {
        hasPlayer = false;
    }

    public boolean getHasPlayer() {
        return hasPlayer;
    }

    public void setX(int x) {
        this.x = x;
    }
}
