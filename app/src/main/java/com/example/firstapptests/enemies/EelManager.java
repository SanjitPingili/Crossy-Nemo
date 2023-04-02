package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.firstapptests.Constants;
import com.example.firstapptests.Sprite;

import java.util.ArrayList;

public class EelManager {

        private ArrayList<EelEnemy> eelEnemies;

        private int EelGap;
        private long startTime;
        private long initTime;
        private Bitmap image;
        private long timeLast;
        private final int ENEMY_SPACING = 24;

        private Sprite player;

        public EelManager(Bitmap bm, int WhaleGap, Sprite player) {
            this.EelGap = WhaleGap;
            this.image = bm;
            this.player = player;
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
            startTime = System.currentTimeMillis();
            int xStart = Constants.SCREEN_WIDTH - 200;
            for(EelEnemy whle : eelEnemies){
                if (whle.intersectsBox(player.getBoundingBox())){
                    System.out.println("Life lost.");
                }
                whle.update(10);
            }
            if(eelEnemies.get(0).offScreen()){        //if goes off screen
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


