package com.example.firstapptests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConfigScreen extends AppCompatActivity {

    private EditText userName;
    private RadioGroup difficultySelector;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        userName = findViewById(R.id.editUsername);
        difficultySelector = findViewById(R.id.radioGroup);
        submitBtn = findViewById(R.id.config_submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText() == null || userName.getText().toString().isEmpty() || userName.getText().toString().trim().length() == 0) {
                    Toast.makeText(ConfigScreen.this, "Enter Valid Username", Toast.LENGTH_SHORT).show();
                } else if (difficultySelector.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(ConfigScreen.this, "Choose a difficulty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ConfigScreen.this, GameScreen.class);
                    intent.putExtra("Username", userName.getText().toString());
                    String difficulty = ((RadioButton)findViewById(difficultySelector.getCheckedRadioButtonId())).getText().toString();
                    intent.putExtra("Difficulty", difficulty);
                    startActivity(intent);
                }
            }
        });
    }

}