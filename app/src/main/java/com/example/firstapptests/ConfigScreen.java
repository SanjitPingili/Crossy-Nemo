package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConfigScreen extends AppCompatActivity {

    private EditText userName;
    private RadioGroup difficultySelector;
    private Button submitBtn;


    private ImageButton turtle1Btn;
    private ImageButton turtle2Btn;
    private ImageButton doriBtn;
    private ImageButton nemoBtn;

    private ImageButton[] imageButtons;

    private String selectedCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);
        getImageButtons();

        userName = findViewById(R.id.editUsername);
        difficultySelector = findViewById(R.id.radioGroup);
        submitBtn = findViewById(R.id.config_submit_btn);

        for (ImageButton btn : imageButtons) {
            btn.setOnClickListener(view -> {
                selectedCharacter = ((ImageButton)view).getContentDescription().toString();
                for (ImageButton btn1 : imageButtons) {
                    btn1.setBackgroundColor(Color.parseColor("#0099cc"));}
                ((ImageButton)view).setBackgroundColor(Color.parseColor("#224782"));
            });
        }



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText() == null || userName.getText().toString().isEmpty() || userName.getText().toString().trim().length() == 0) {
                    Toast.makeText(ConfigScreen.this, "Enter Valid Username", Toast.LENGTH_SHORT).show();
                } else if (difficultySelector.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(ConfigScreen.this, "Choose a difficulty", Toast.LENGTH_SHORT).show();
                } else if (selectedCharacter == null) {
                    Toast.makeText(ConfigScreen.this, "Choose a character", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
                    intent.putExtra("Username", userName.getText().toString());
                    String difficulty = ((RadioButton)findViewById(difficultySelector.getCheckedRadioButtonId())).getText().toString();
                    intent.putExtra("Difficulty", difficulty);
                    intent.putExtra("Character", selectedCharacter);
                    startActivity(intent);
                }
            }
        });
    }
    private void getImageButtons() {
        turtle1Btn = findViewById(R.id.turtle1Btn);
        turtle2Btn = findViewById(R.id.turtle2Btn);
        doriBtn = findViewById(R.id.doriBtn);
        nemoBtn = findViewById(R.id.nemoBtn);

        imageButtons = new ImageButton[4];
        imageButtons[0] = turtle1Btn;
        imageButtons[1] = turtle2Btn;
        imageButtons[2] = doriBtn;
        imageButtons[3] = nemoBtn;
    }


}