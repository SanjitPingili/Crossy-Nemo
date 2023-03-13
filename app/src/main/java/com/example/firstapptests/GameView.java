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

import java.util.Timer;
import java.util.TimerTask;

//import androidx.annotation.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Sprite characterSprite;
    private SafeTile safeTile1;
    private GoalTile goalTile;
    private SharkManager sharkManager;
    private RiverTile riverTile;
    private Canvas canvas = getHolder().lockCanvas();
    private int score = 0;
    String c;

    public GameView(Context context, String c) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        this.c = c;
        setFocusable(true);

    }

    public void update(){
        sharkManager.update();
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


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Character Declaration

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.nemo_icon);
        sharkManager = new SharkManager(getResizedBitmap(bm, 100, 100), 30);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), getCharacterSprite(c));
        characterSprite = new Sprite(getResizedBitmap(bm1, 200, 200),
                 430, 1570);
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
            sharkManager.draw(canvas);


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