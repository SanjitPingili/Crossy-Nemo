package com.example.firstapptests;

import static org.junit.Assert.assertEquals;

import com.example.firstapptests.enemies.SharkEnemy;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EnemyManagerTests {

    private SharkEnemy sharkEnemy;

    @Before
    public void setUp() throws Exception {
        sharkEnemy = new SharkEnemy(50,70,20,5);
    }

    @Test
    public void checkSharkOffScreen() {assertEquals(true, SharkEnemy.offScreen(-2));}
    @Test
    public void checkSharkOnScreen() {assertEquals(false, SharkEnemy.offScreen(200));}
    @Test
    public void sharkX() {assertEquals(50, sharkEnemy.getX());}
    @Test
    public void sharkY() {assertEquals(70, sharkEnemy.getY());}
    @Test
    public void sharkSpeed() {assertEquals(5, sharkEnemy.getSpeed());}
}
