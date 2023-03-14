package com.example.firstapptests;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * This class is the link btwn the GameView and the Canvas where we are drawing stuff
 */
public class CrossRoad extends Activity {

    private GameView gameView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        // on below line we are getting metrics for display using window manager.
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        Constants.SCREEN_WIDTH = displayMetrics.widthPixels;
        Constants.SCREEN_HEIGHT = displayMetrics.heightPixels;
        // The Width and Height of the AVD display is used to calculate bounds for sprite.
//        Bundle extras = getIntent().getExtras();
//        byte[] b = extras.getByteArray("picture");
//
//        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
//        ImageView image = (ImageView) findViewById(R.id.imageView1);

//        image.setImageBitmap(bmp);
        Bundle intent = getIntent().getExtras();
        String characterNeeded = (String) intent.get("charUsed");

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gameView = new GameView(this, characterNeeded);
        setContentView(gameView); // This allows us to work off the canvas
    }
    public GameView getGameView() {
        return gameView;
    }
}
