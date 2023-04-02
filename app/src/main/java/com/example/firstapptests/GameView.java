package com.example.firstapptests;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.firstapptests.enemies.EelManager;
import com.example.firstapptests.enemies.SharkManager;
import com.example.firstapptests.enemies.WhaleManager;
import com.example.firstapptests.tiles.GoalTile;
import com.example.firstapptests.tiles.RiverTile;
import com.example.firstapptests.tiles.SafeTile;

//import androidx.annotation.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Sprite characterSprite;
    private SafeTile safeTile1;
    private GoalTile goalTile;
    private SharkManager sharkManager;
    private WhaleManager whaleManager;
    private EelManager eelManager;
    private RiverTile riverTile;
    private Canvas canvas = getHolder().lockCanvas();
    private int score = 0;
    private int lives;
    String c;

    public GameView(Context context, String c, int lives) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        this.lives = lives;
        this.c = c;
        setFocusable(true);

    }

    public void update(){
        sharkManager.update();
        whaleManager.update();
        eelManager.update();
    }

    // KEY MOVEMENT
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case(KeyEvent.KEYCODE_DPAD_LEFT) :
            characterSprite.moveLeft();
            invalidate();
            return true;

        case(KeyEvent.KEYCODE_DPAD_UP) :
            characterSprite.moveUp();
            score = Math.max(score, calculateScore(characterSprite.getY()));
            invalidate();
            return true;

        case(KeyEvent.KEYCODE_DPAD_DOWN) :
            characterSprite.moveDown();
            invalidate();
            return true;

        case(KeyEvent.KEYCODE_DPAD_RIGHT) :
            characterSprite.moveRight();
            invalidate();
            return true;
        default:
            return true;
        }
    }

    public static int calculateScore(int charY) {
        int newScore = 0;
        int[] pointsArray = new int[]{4,5,6,7,8};
//        int[] pointsBounds = new int[]{1250, 1050, 850, 100};
        int[] pointsBounds = new int[]{1800, 1200, 850, 600, 100};
//        System.out.println("Current y value: " + charY);
        int i = 0;
        while (i < pointsArray.length && i < pointsBounds.length) {
            if (charY < pointsBounds[i]) {
                newScore += pointsArray[i];
            } else {
                break;
            }
            i++;
        }
        return newScore;
    }

    public int resetScore() {
        score = 0;
        return score;
    }



    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Character Declaration

        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), getCharacterSprite(c));
        characterSprite = new Sprite(this, getResizedBitmap(bm1, 200, 200),
                700, 2100, lives);

        Bitmap bm0 = BitmapFactory.decodeResource(getResources(), R.drawable.whale);
        whaleManager = new WhaleManager(getResizedBitmap(bm0, 150, 150), 30);

        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.eel);
        eelManager = new EelManager(getResizedBitmap(bm3, 300, 300), 30, characterSprite);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.shark);
        sharkManager = new SharkManager(getResizedBitmap(bm, 100, 100), 30);


        // tile Stuff
        safeTile1 = new SafeTile(getResizedBitmap(BitmapFactory
                .decodeResource(getResources(), R.drawable.safetile), Constants.SCREEN_WIDTH, 150));
        goalTile = new GoalTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.goaltile), Constants.SCREEN_WIDTH, 200));
        riverTile = new RiverTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.rivertile), Constants.SCREEN_WIDTH, 800));

        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();

    }

    int getCharacterSprite(String character) {
        int result = 0;
        switch (character) {
            case "Nemo":
                result = R.drawable.nemo_icon;
                break;
            case "Dory":
                result = R.drawable.doripixel;
                break;
            case "turtle1":
                result = R.drawable.turtleofficial;
                break;
            case "turtle2":
                result = R.drawable.turtlenemo;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }



    // Not really using this right now
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    // this does the Character Update Work,
    // gets called in mainThread run method which causes it to update
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        carManager.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.BLUE);
            safeTile1.draw(canvas);
            goalTile.draw(canvas);
            riverTile.draw(canvas);
            characterSprite.draw(canvas);
            sharkManager.draw(canvas, score);
            whaleManager.draw(canvas);
            eelManager.draw(canvas, score);


        }
    }

    // Resizes the bitmap or the image
    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap =
                Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }
}