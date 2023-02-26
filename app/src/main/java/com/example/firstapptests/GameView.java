package com.example.firstapptests;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

//import androidx.annotation.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Sprite characterSprite;
    private SafeTile safeTile1;
    private GoalTile goalTile;
    private RiverTile riverTile;
    private Canvas canvas = getHolder().lockCanvas();
    private int screenX, screenY, score = 0;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        this.screenX = screenX; // Gets the Width of Screen Display
        this.screenY = screenY; // Gets the Height of Screen Display
    }

    public void update() {
        // update the sprite's position based on keyboard input

    }

    // KEY MOVEMENT
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       switch (keyCode) {
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

           case(KeyEvent.KEYCODE_DPAD_LEFT) :
               characterSprite.moveLeft();
               invalidate();
               return true;
           }
           return true;
       }




    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        // Character Declaration
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.nemo_icon);
        characterSprite = new Sprite(getResizedBitmap(bm, 300, 300),400, 1400, 10, screenX, screenY);
        // tile Stuff
        safeTile1 = new SafeTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.safetile), screenX, 200));
        goalTile = new GoalTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.goaltile), screenX, 200));
        riverTile = new RiverTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rivertile), screenX, 800));
        thread.setRunning(true);
        thread.start();

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




    // this does the Character Update Work, gets called in mainThread run method which causes it to update
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.BLUE);
            safeTile1.draw(canvas);
            goalTile.draw(canvas);
            riverTile.draw(canvas);
            characterSprite.draw(canvas);
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