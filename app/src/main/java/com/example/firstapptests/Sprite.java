package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

// 1794 AND 1080
public class Sprite {
    private Bitmap image;
    private int x;
    private int y;
    private final int speed = 45;
    private int lives;

    private int logSpeed;
    private boolean onLog;

    private GameView gameView;

    public Sprite(GameView gameView, Bitmap bmp, int x, int y, int lives) {
        this.gameView = gameView;
        this.lives = lives;
        image = bmp;
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (!onLog) {
            this.y = y > speed ? this.y - speed : this.y;
        } else {
            this.y = y > speed ? this.y - (speed + 55) : this.y;
        }
        if (this.y < 870 && !onLog) {
            dead();
        }
    }

    public void moveDown() {

        if (!onLog) {
            this.y = y < Constants.SCREEN_HEIGHT - speed - 220 ? this.y + speed : this.y;
        } else {
            this.y = y < Constants.SCREEN_HEIGHT - speed - 220 ? this.y + (speed+55) : this.y;
        }
        if (this.y < 870 && !onLog) {
            dead();
        }
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
//        float tempX = (float) x;
//        float tempY = (float) y;
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        paint.setColor(Color.BLACK);
//        canvas.drawRect(tempX+30,tempY+30,tempX+150,tempY+150, paint);
        canvas.drawBitmap(image, this.x, this.y, null);
    }

    public boolean intersectsBox(int x1, int x2, int y1, int y2) {
        int bx1 = x + 30;
        int by1 = y + 30;
        int bx2 = x + 150;
        int by2 = y + 150;
        int by = (by2+by1)/2;
        if (by >= y1 && by <= y2) {
            if (x1 < bx2 && x1 > bx1) {
                return true;
            }
        }
        return false;
    }

    public int[] getBoundingBox(){
        return new int[] {x+30, y+30, x+150, y+150};
    }

    public void dead() {
        lives--;
        if (lives > 0) {
            respawn();
        } else {
            gameOver();
        }
    }

    public void won() {
        if (this.y >= 155) {
            win();
        }
    }

    private void win() {
        gameView.winScreen();
    }

    private void gameOver() {
        gameView.gameOver();
    }

    private int respawn() {
        setPositions(700, 2100);
        gameView.resetScore();
        System.out.println("Life lost... You have " + lives + " lives remaining.");
        return lives;
    }

    public void attach(int centerX, int centerY, int speed) {
        x = centerX - 90;
        y = centerY - 90;
        logSpeed = speed;
        onLog = true;
    }
    public boolean isOnLog() {
        return onLog;
    }
    public void detach() {
        onLog = false;
    }
}