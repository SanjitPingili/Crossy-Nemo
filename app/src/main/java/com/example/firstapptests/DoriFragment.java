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


public class DoriFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dori);

        Button backBtn  = findViewById(R.id.doriBackButton);
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Icons.class);
            startActivity(intent);
        });
        Button playBtn  = findViewById(R.id.doriPlay);
        playBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), GameScreen.class);
            startActivity(intent);
        });






    }

}
