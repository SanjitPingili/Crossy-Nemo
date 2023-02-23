package com.example.firstapptests;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class KeyboardHandler implements View.OnKeyListener {

    private ImageView chosenPlayer;
    private int playerSpeed;


    public KeyboardHandler(int playerSpeed, ImageView chosenPlayer) {
        this.playerSpeed = playerSpeed;
        this.chosenPlayer = chosenPlayer;
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case KeyEvent.KEYCODE_DPAD_LEFT:

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                return true;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                return true;

                default:

                return false;
        }
    }
}

