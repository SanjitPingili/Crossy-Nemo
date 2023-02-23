package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    private TextView gameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("Username");
        String difficulty = intent.getStringExtra("Difficulty");
        String character = intent.getStringExtra("Character");
        int lives = 0;

        switch (difficulty) {
            case "Easy":
                lives = 10;
                break;
            case "Medium":
                lives = 5;
                break;
            case "Hard":
                lives = 1;
                break;
        }

        gameText = findViewById(R.id.gameText);
        gameText.setText(String.format("Player: %s \n Difficulty: %s \n Character: %s \n Lives: %d", userName, difficulty, character, lives));

        switch (character) {
            case "Nemo":
                ((ImageView)findViewById(R.id.spriteImage)).setImageResource(R.drawable.nemo_icon);
                break;
            case "Dory":
                ((ImageView)findViewById(R.id.spriteImage)).setImageResource(R.drawable.doripixel);
                break;
            case "turtle1":
                ((ImageView)findViewById(R.id.spriteImage)).setImageResource(R.drawable.turtleofficial);
                break;
            case "turtle2":
                ((ImageView)findViewById(R.id.spriteImage)).setImageResource(R.drawable.turtlenemo);
                break;
        }
    }
}