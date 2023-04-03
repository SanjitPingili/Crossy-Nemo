package com.example.firstapptests;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameScreenTests {

    private GameScreen gameScreen;

    @Before
    public void setUp() throws Exception {
        gameScreen = (new GameScreen());
    }

    @Test
    public void checkEasyLives() {assertEquals(10, gameScreen.getLives("Easy"));}
    @Test
    public void checkMediumLives() {assertEquals(5, gameScreen.getLives("Medium"));}
    @Test
    public void checkHardLives() {assertEquals(1, gameScreen.getLives("Hard"));}
    @Test
    public void checkNemoSprite() {assertEquals(R.drawable.nemo_icon, gameScreen.getCharacterSprite("Nemo"));}
    @Test
    public void checkDorySprite() {assertEquals(R.drawable.doripixel, gameScreen.getCharacterSprite("Dory"));}
    @Test
    public void checkTurtle1Sprite() {assertEquals(R.drawable.turtleofficial, gameScreen.getCharacterSprite("turtle1"));}
    @Test
    public void checkTurtle2Sprite() {assertEquals(R.drawable.turtlenemo, gameScreen.getCharacterSprite("turtle2"));}
    // New Test
    @Test
    public void checkOtherSprite() {assertEquals(0, gameScreen.getCharacterSprite("turtle6"));}

    @Test
    public void checkOtherLives() {assertEquals(0, gameScreen.getLives("turtle6"));}

}