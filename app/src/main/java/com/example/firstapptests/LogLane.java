package com.example.firstapptests;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogLane {
    int y;
    int direction;
    List<Log> logs = new ArrayList<>();
    public static final int logHeight = 100;
    Sprite player;

    // Direction: 1 = right, -1 = left
    public LogLane(int y, int direction, Sprite player) {
        this.player = player;
        this.y = y;
        this.direction = direction;
        int x = (int) (Math.random()*350);
        addNewLog(250, x+650);
        addNewLog(400, x);
    }

    public void addNewLog(int width) {
        addNewLog(width, 0);
    }
    public void addNewLog(int width, int x) {
        logs.add(new Log(x-width, y, width,7, direction));
    }


    public void draw(Canvas canvas) {
        for (Log l : logs) {
            l.draw(canvas);
        }
    }

    public void update() {
//        Iterator<Log> it = logs.iterator();
//        while (it.hasNext()) {
//            Log l = it.next();
//            l.update();
//            if (l.intersectsBox(player.getBoundingBox())) {
//                l.attach();
//                player.attach(l.getCenterX(), l.getCenterY(), l.getSpeed());
//            }
////            if (l.offScreen()) {
////                it.remove();
////                addNewLog(300);
////            }
//        }
        for (Log l : logs) {
            l.update();
            if (l.intersectsBox(player.getBoundingBox())) {
                l.attach();
                player.attach(l.getCenterX(), l.getCenterY(), l.getSpeed());
            }
            if (l.offScreen()) {
                if (direction == 1) {
                    l.setX(-450);
                } else {
                    l.setX(1400+350);
                }

            }
        }
//        if (direction == 1) {
//            if (logs.get(logs.size() - 1).offScreen()) {
//                logs.remove(logs.size() - 1);
//                addNewLog(300);
//            }
//        } else {
//            if (logs.get(0).offScreen()) {
//                logs.remove(0);
//                addNewLog(300, 1000);
//            }
//        }
    }
}
