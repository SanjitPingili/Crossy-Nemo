package com.example.firstapptests;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

public class TurtleFragment extends AppCompatActivity {

    private int lives = 3;
    private final String difficulty = "Hard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_turtle);

        Button backBtn = findViewById(R.id.turtleBackButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Icons.class);
                startActivity(intent);
            }
        });

        Button playBtn  = findViewById(R.id.turtlePlay);
        playBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), GameScreen.class);
            startActivity(intent);
        });

    }
}

