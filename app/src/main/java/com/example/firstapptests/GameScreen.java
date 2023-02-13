package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        gameText = findViewById(R.id.gameText);
        gameText.setText(String.format("Player: %s \n Difficulty: %s", userName, difficulty));


    }
}