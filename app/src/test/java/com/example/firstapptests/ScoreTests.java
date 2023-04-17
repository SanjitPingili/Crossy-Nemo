package com.example.firstapptests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScoreTests {

    private GameScreen gameScreen;
    private GameView gameView;

    @Before
    public void setUp() throws Exception {
        gameScreen = (new GameScreen());
    }
    // int[] pointsArray = new int[]{4,5,6,7,8};
    // int[] pointsBounds = new int[]{1800, 1200, 850, 600, 100};
    @Test
    public void checkScoreStart() {assertEquals(0, GameView.calculateScore(2000));}
    @Test
    public void checkScoreMid1() {assertEquals(4, GameView.calculateScore(1790));}
    @Test
    public void checkScoreMid2() {assertEquals(9, GameView.calculateScore(1199));}
    @Test
    public void checkScoreLong2() {assertEquals(9, GameView.calculateScore(1190));}
    @Test
    public void checkScoreMid3() {assertEquals(15, GameView.calculateScore(849));}
    @Test
    public void checkScoreMid4() {assertEquals(22, GameView.calculateScore(599));}
    @Test
    public void checkScoreEnd() {assertEquals(30, GameView.calculateScore(99));}
    @Test
    public void checkScoreEnd2() {assertEquals(30, GameView.calculateScore(98));}
}
