package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;

// 1794 AND 1080
public class Sprite {
    private Bitmap image;
    private int x;
    private int y;
    private final int speed = 10;

    public Sprite(Bitmap bmp, int x, int y) {
        image = bmp;
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        this.y = y > speed ? this.y - speed : this.y;
//        System.out.println(this.x + "HEIGHT" + this.y);
    }

    public void moveDown() {
        this.y = y < Constants.SCREEN_HEIGHT - speed - 220 ? this.y + speed : this.y;
//        System.out.println(this.x + "HEIGHT" + this.y);
//        System.out.println(Constants.SCREEN_HEIGHT + "AND" + Constants.SCREEN_WIDTH);
        // 220 is  guess and check val cuz of the bottom black part of phone

    }

    // the 5 is a guess and check value to keep the object on the screen
    public void moveLeft() {
        this.x = x > speed - 5 ? this.x - speed : this.x;
//        System.out.println(this.x + "HEIGHT" + this.y);

    }

    public void moveRight() {
        this.x = x < Constants.SCREEN_WIDTH - speed - 255 ? this.x + speed : this.x;
//        System.out.println(this.x + "HEIGHT" + this.y);

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

//    public void update (int x, int y) {
//        this.x+= speed;
//        this.y += speed;
//        canvas.drawBitmap(image, this.x, this.y, null);
//    }

}