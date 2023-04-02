package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class GameScreen extends AppCompatActivity {

    private TextView gameText;
    private Button readyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("Username");
        String difficulty = intent.getStringExtra("Difficulty");
        String character = intent.getStringExtra("Character");
        int lives = getLives(difficulty);



        gameText = findViewById(R.id.gameText);
        gameText.setText(String.format("Player: %s \n Difficulty: %s \n Character: %s "
                + "\n Lives: %d", userName, difficulty, character, lives));
        setSprite(character);



        readyBtn = findViewById(R.id.readyButton);
        readyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), getCharacterSprite(character));
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                byte[] b = baos.toByteArray();
                Intent intent = new Intent(GameScreen.this, CrossRoad.class);
                intent.putExtra("charUsed", character);
//                System.out.println("Character is  " + character);
                startActivity(intent);
            }
        });
    }

    int getLives(String difficulty) {
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
        default:
            lives = 0;
            break;
        }
        return lives;
    }

    int getCharacterSprite(String character) {
        int result = 0;
        switch (character) {
        case "Nemo":
            result = R.drawable.nemo_icon;
            break;
        case "Dory":
            result = R.drawable.doripixel;
            break;
        case "turtle1":
            result = R.drawable.turtleofficial;
            break;
        case "turtle2":
            result = R.drawable.turtlenemo;
            break;
        default:
            result = 0;
            break;
        }
        return result;
    }
    void setSprite(String character) {
        ((ImageView) findViewById(R.id.spriteImage))
                .setImageResource(getCharacterSprite(character));
    }

}