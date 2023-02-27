package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Sprite {
    private Bitmap image;
    private int x;
    private int y;
    private int speed;
    private int screenX;
    private int screenY;

    public Sprite(Bitmap bmp, int x, int y, int speed, int screenX, int screenY) {
        image = bmp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    public void moveUp() {
        this.y = y > speed ? this.y - speed : this.y;
    }

    public void moveDown() {
        this.y = y < screenY - speed - 220 ? this.y + speed : this.y;
        // 220 is  guess and check val cuz of the bottom black part of phone

    }

    // the 5 is a guess and check value to keep the object on the screen
    public void moveLeft() {
        this.x = x > speed - 5 ? this.x - speed : this.x;

    }

    public void moveRight() {
        this.x = x < screenX - speed - 255 ? this.x + speed : this.x;
        System.out.println(image.getWidth());
        System.out.println(screenY + " AND " + screenX);
        System.out.println(this.x);

    }

    public int getSpeed() {
        return this.speed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setPositions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, this.x, this.y, null);
    }

    //public void update (int x, int y) {
    //    this.x+= speed;
    //    this.y += speed;
    //    canvas.drawBitmap(image, this.x, this.y, null);
    //}

}