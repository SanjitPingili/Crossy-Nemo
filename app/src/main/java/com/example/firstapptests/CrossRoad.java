package com.example.firstapptests;

import android.app.Activity;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

/**
 * This class is the link btwn the GameView and the Canvas where we are drawing stuff
 */
public class CrossRoad extends Activity {

    private GameView gameView;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        // on below line we are getting metrics for display using window manager.
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        // The Width and Height of the AVD display is used to calculate bounds for sprite.

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gameView = new GameView(this, screenWidth, screenHeight);
        setContentView(gameView); // This allows us to work off the canvas
    }
}
