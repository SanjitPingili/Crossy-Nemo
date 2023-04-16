package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.firstapptests.Constants;

import java.util.ArrayList;

public class WhaleManager {

    private ArrayList<WhaleEnemy> whaleEnemies;

    private int WhaleGap;
    private long startTime;
    private long initTime;
    private Bitmap image;
    private long timeLast;
    private final int ENEMY_SPACING = 24;

    public WhaleManager(Bitmap bm, int WhaleGap) {
        this.WhaleGap = WhaleGap;
        this.image = bm;
        startTime = initTime = System.currentTimeMillis();
        whaleEnemies = new ArrayList<WhaleEnemy>();
        populateWhales(Constants.SCREEN_WIDTH - 200);
    }

    // ENEMY_SPACING Not being used right
    private void populateWhales(int spacing) {
        for (int i = 0; i < 5; i++) {
            whaleEnemies.add(new WhaleEnemy(image, spacing, 600, ENEMY_SPACING, 15));
            spacing += 320;
        }
    }

    public void update() {
        if (startTime < Constants.INIT_TIME) {
            startTime = Constants.INIT_TIME;
        }
        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
//        System.out.println(elapsedTime);
        startTime = System.currentTimeMillis();
//        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/2000.0))* Constants.SCREEN_WIDTH/(10000.0f);             //sets speed for cars to reach bottom of screen (10s)
//        System.out.println("Speed is" + speed /10);
        int xStart = Constants.SCREEN_WIDTH - 200;
        for (WhaleEnemy whle : whaleEnemies) {
            whle.update(10);
        }
        if (whaleEnemies.get(0).offScreen()) {        //if goes off screen
//            int xStart = (int) (Math.random()*(Constants.SCREEN_WIDTH - playerGap));
//            System.out.println("OFF SCREEN");
            whaleEnemies.remove(0);
            whaleEnemies.add(whaleEnemies.size() - 1,
                    new WhaleEnemy(image, xStart, 600, 20, 1));
            xStart -= 200;
        }
    }

    public void draw(Canvas canvas) {
        for (WhaleEnemy whl : whaleEnemies) {
            whl.draw(canvas);
        }
    }


    public ArrayList<WhaleEnemy> getWhaleEnemiesEnemies() {
        return whaleEnemies;
    }
}
