package com.example.firstapptests;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConfigScreenTests {

    private ConfigScreen configScreen;
    private EditText userName;
    private RadioGroup difficultySelector;
    private Button submitBtn;
    private String validUserName = "John Doe";

    @Before
    public void setUp() throws Exception {
        // Create a new ConfigScreen instance and set up views
//        configScreen = mock(ConfigScreen.class);
        configScreen = (new ConfigScreen());
        userName = new EditText(configScreen);
        difficultySelector = new RadioGroup(configScreen);
        submitBtn = new Button(configScreen);
//        // Set up the views with some default values
//        userName.setText(validUserName);
//        difficultySelector.check(R.id.easy_btn);
//        submitBtn.performClick();
    }


    @Test
    public void checkNullName() {
        assertEquals(true, configScreen.isNullUserName(null));
    }
    @Test
    public void checkEmptyName() {
        assertEquals(false, configScreen.checkUserNameString(""));
    }
    @Test
    public void checkWhiteSpacedName() {
        assertEquals(false, configScreen.checkUserNameString("    \t"));
    }
    @Test
    public void checkValidName() {
        assertEquals(true, configScreen.checkUserNameString("User Name"));
    }
}