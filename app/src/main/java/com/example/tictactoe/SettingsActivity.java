package com.example.tictactoe;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    Button playerOne, playerTwo, player, computer, save;
    ImageView change1, change2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playerOne = (Button) findViewById(R.id.playerOneSet);
        playerTwo = (Button) findViewById(R.id.playerTwoSet);
        player = (Button) findViewById(R.id.playerSet);
        computer = (Button) findViewById(R.id.computerSet);
        save = (Button) findViewById(R.id.buttonSaveSettings);

        change1 = (ImageView) findViewById(R.id.changeArrows1);
        change2 = (ImageView) findViewById(R.id.changeArrows2);

    }
}