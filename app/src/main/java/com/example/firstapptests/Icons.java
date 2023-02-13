package com.example.firstapptests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Icons extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_icons);

        Button backBtn = findViewById(R.id.backToWelcomeScreen);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        ImageButton doriBtn = findViewById(R.id.dori);
        doriBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DoriFragment.class);
            startActivity(intent);
        });

        ImageButton turtleBtn = findViewById(R.id.turtle);
        turtleBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TurtleFragment.class);
            startActivity(intent);
        });





    }

}
