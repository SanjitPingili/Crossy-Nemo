package com.example.firstapptests;

import static org.junit.Assert.assertEquals;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;

import com.example.firstapptests.enemies.EelEnemy;
import com.example.firstapptests.enemies.SharkEnemy;
import com.example.firstapptests.enemies.WhaleEnemy;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

public class SharkTests {

    private SharkEnemy sharkEnemy;
    private EelEnemy eelEnemy;
    private WhaleEnemy whaleEnemy;
    private Sprite playerSprite;
    private Bitmap bm;
    int[] box;
    int[] boxTwo;


    @Before
    public void setUp() throws Exception {
        box = new int[]{90, 1200, 1200, 1270};
        boxTwo = new int[]{30, 1400, 1400, 10};
        sharkEnemy = new SharkEnemy(50,1200,20,5);
    }

    @Test
    public void checkIntersection() {assertEquals(true, sharkEnemy.intersectsCoords(90,
            1200,1200,1270));}
    @Test
    public void checkIntersectionTrue() {assertEquals(true, sharkEnemy.intersectsCoords(90,
            1200,1200,1260));}
    @Test
    public void checkIntersectionFalse() {assertEquals(false, sharkEnemy.intersectsCoords(
            30,1400,10,10));}
    @Test
    public void checkIntersectionFalseTwo() {assertEquals(false, sharkEnemy.intersectsCoords(
            80,1000,10,10));}
    @Test
    public void checkBoxIntersection() {assertEquals(true, sharkEnemy.intersectsBox(box));}
    @Test
    public void checkBoxIntersectionTwo() {assertEquals(false, sharkEnemy.intersectsBox(boxTwo));}




}

