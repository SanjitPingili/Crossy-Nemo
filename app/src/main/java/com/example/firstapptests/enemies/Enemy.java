package com.example.firstapptests.enemies;

import android.graphics.Canvas;

// interface j to make things easier

public interface Enemy {
    public void draw(Canvas canvas);
    public void update(float y);
    public void spawn();

}
