package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SharkManager {

    private ArrayList<SharkEnemy> sharkEnemies;
    private int sharkGap;
    private long startTime;
    private long initTime;
    private int score = 0;
    private Bitmap image;
    private long timeLast;
    private final int ENEMY_SPACING = 20;

    public SharkManager(Bitmap bm, int sharkGap) {
        this.sharkGap = sharkGap;
        this.image = bm;
        startTime = initTime = System.currentTimeMillis();
        sharkEnemies = new ArrayList<SharkEnemy>();
        populateSharks(Constants.SCREEN_HEIGHT-200);
    }

    // ENEMY_SPACING Not being used right
    private void populateSharks(int spacing) {
        for (int i = 0; i < 10; i++) {
            sharkEnemies.add(new SharkEnemy(image, spacing, 1200, ENEMY_SPACING, 15));
            spacing+=200;
        }
    }

    public void update(){
        if(startTime < Constants.INIT_TIME){
            startTime = Constants.INIT_TIME;
        }
        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        System.out.println(elapsedTime);
        startTime = System.currentTimeMillis();
//        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/2000.0))* Constants.SCREEN_WIDTH/(10000.0f);             //sets speed for cars to reach bottom of screen (10s)
//        System.out.println("Speed is" + speed /10);
        int xStart = Constants.SCREEN_WIDTH - 200;
        for(SharkEnemy shk : sharkEnemies){
            shk.update(10);
        }
        if(sharkEnemies.get(0).offScreen()){        //if goes off screen
//            int xStart = (int) (Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            System.out.println("OFF SCREEN");
            sharkEnemies.remove(0);
            sharkEnemies.add(sharkEnemies.size() - 1,
                    new SharkEnemy(image, xStart, 1200, 20, 1));
            xStart-=200;
            score++;
        }
    }
    public void draw(Canvas canvas){
        for(SharkEnemy shk: sharkEnemies) {
            shk.draw(canvas);
        }
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        canvas.drawText(""+score, 50,50 + paint.descent() - paint.ascent(), paint);

    }

    public ArrayList<SharkEnemy> getSharkEnemies() {
        return sharkEnemies;
    }
}
