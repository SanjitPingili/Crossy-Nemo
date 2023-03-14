package com.example.firstapptests;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class EelManager {

        private ArrayList<EelEnemy> eelEnemies;

        private int EelGap;
        private long startTime;
        private long initTime;
        private Bitmap image;
        private long timeLast;
        private final int ENEMY_SPACING = 24;

        public EelManager(Bitmap bm, int WhaleGap) {
            this.EelGap = WhaleGap;
            this.image = bm;
            startTime = initTime = System.currentTimeMillis();
            eelEnemies = new ArrayList<EelEnemy>();
            populateEels(Constants.SCREEN_WIDTH-200);
        }

        // ENEMY_SPACING Not being used right
        private void populateEels(int spacing) {
            for (int i = 0; i < 2; i++) {
                eelEnemies.add(new EelEnemy(image, spacing, 1800, ENEMY_SPACING, 15));
                //spacing;
            }
        }

        public void update(){
            if(startTime < Constants.INIT_TIME){
                startTime = Constants.INIT_TIME;
            }
            int elapsedTime = (int) (System.currentTimeMillis() - startTime);
//            System.out.println(elapsedTime);
            startTime = System.currentTimeMillis();
//        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/2000.0))* Constants.SCREEN_WIDTH/(10000.0f);             //sets speed for cars to reach bottom of screen (10s)
//        System.out.println("Speed is" + speed /10);
            int xStart = Constants.SCREEN_WIDTH - 200;
            for(EelEnemy whle : eelEnemies){
                whle.update(10);
            }
            if(eelEnemies.get(0).offScreen()){        //if goes off screen
//            int xStart = (int) (Math.random()*(Constants.SCREEN_WIDTH - playerGap));
                System.out.println("OFF SCREEN");
                eelEnemies.remove(0);
                eelEnemies.add(eelEnemies.size() - 1,
                        new EelEnemy(image, xStart, 1800, 20, 1));
                xStart-=200;
            }
        }
        public void draw(Canvas canvas, int score){
            for(EelEnemy whl: eelEnemies) {
                whl.draw(canvas);
            }
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.BLACK);
            canvas.drawText(""+score, 50,50 + paint.descent() - paint.ascent(), paint);

        }

        public ArrayList<EelEnemy> getWhaleEnemiesEnemies() {
            return eelEnemies;
        }
    }


