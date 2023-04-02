package com.example.firstapptests.enemies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.firstapptests.Constants;
import com.example.firstapptests.Sprite;

import java.util.ArrayList;

public class SharkManager {

    private ArrayList<SharkEnemy> sharkEnemies;
    private int sharkGap;
    private long startTime;
    private long initTime;
    private Bitmap image;
    private long timeLast;
    private final int ENEMY_SPACING = 30;

    private Sprite player;

    public SharkManager(Bitmap bm, int sharkGap, Sprite player) {
        this.sharkGap = sharkGap;
        this.image = bm;
        this.player = player;
        startTime = initTime = System.currentTimeMillis();
        sharkEnemies = new ArrayList<SharkEnemy>();
        populateSharks(Constants.SCREEN_WIDTH-200);
    }

    // ENEMY_SPACING Not being used right
    private void populateSharks(int spacing) {
        for (int i = 0; i < 7; i++) {
            sharkEnemies.add(new SharkEnemy(image, spacing, 1200, ENEMY_SPACING, 15));
            spacing+=200;
        }
    }

    public void update(){
        if(startTime < Constants.INIT_TIME){
            startTime = Constants.INIT_TIME;
        }
        int elapsedTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        int xStart = Constants.SCREEN_WIDTH - 200;
        for(SharkEnemy shk : sharkEnemies){
//            TODO: Uncomment to add collision with sharks
//            if (shk.intersectsBox(player.getBoundingBox())){
//                player.dead();
//            }
            shk.update(10);
        }
        if(sharkEnemies.get(0).offScreen(sharkEnemies.get(0).getX())){
            sharkEnemies.remove(0);
            sharkEnemies.add(sharkEnemies.size() - 1,
                    new SharkEnemy(image, xStart, 1200, 20, 1));
            xStart-=200;
        }
    }
    public void draw(Canvas canvas, int score){
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
