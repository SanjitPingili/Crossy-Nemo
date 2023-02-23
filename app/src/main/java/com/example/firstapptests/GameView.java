package com.example.firstapptests;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//import androidx.annotation.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private Sprite characterSprite;
    private SafeTile safeTile1;
    private GoalTile goalTile;
    private RiverTile riverTile;


    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterSprite = new Sprite(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.nemo_icon), 300, 300));
        safeTile1 = new SafeTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.safetile), 1500, 200));
        goalTile = new GoalTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.goaltile), 1500, 200));
        riverTile = new RiverTile(getResizedBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.rivertile), 1500, 800));
        thread.setRunning(true);
        thread.start();
    }

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
    public void update() {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.BLUE);
            characterSprite.draw(canvas);
            safeTile1.draw(canvas);
            goalTile.draw(canvas);
            riverTile.draw(canvas);
        }
    }
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
