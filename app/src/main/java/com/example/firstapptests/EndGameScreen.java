package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameScreen extends AppCompatActivity {
    private TextView scoreText;
    private Button replayBtn;
    private Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_screen);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        scoreText = findViewById(R.id.endScoreText);
        scoreText.setText(score+"");

        replayBtn = findViewById(R.id.restart_btn);
        exitBtn = findViewById(R.id.exit_btn);

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameScreen.this, ConfigScreen.class);
                startActivity(intent);
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}