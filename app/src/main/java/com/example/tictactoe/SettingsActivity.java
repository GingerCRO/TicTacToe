package com.example.tictactoe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editorPrefs = sharedPreferences.edit();

        playerOne = (Button) findViewById(R.id.playerOneSet);
        playerTwo = (Button) findViewById(R.id.playerTwoSet);
        player = (Button) findViewById(R.id.playerSet);
        computer = (Button) findViewById(R.id.computerSet);
        save = (Button) findViewById(R.id.buttonSaveSettings);

        change1 = (ImageView) findViewById(R.id.changeArrows1);
        change2 = (ImageView) findViewById(R.id.changeArrows2);

        String playerOnePrefs, playerTwoPrefs, playerPrefs, computerPrefs;
        playerOnePrefs = sharedPreferences.getString("playeronesign", "X");
        playerTwoPrefs = sharedPreferences.getString("playertwosign", "O");
        playerPrefs = sharedPreferences.getString("playersign", "X");
        computerPrefs = sharedPreferences.getString("computersign", "O");

        assignPlayerSigns(playerOne, playerOnePrefs);
        assignPlayerSigns(playerTwo, playerTwoPrefs);
        assignPlayerSigns(player, playerPrefs);
        assignPlayerSigns(computer, computerPrefs);

        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerOneSign, playerTwoSign;
                playerOneSign = playerOne.getText().toString();
                playerTwoSign = playerTwo.getText().toString();

                playerOne.setText(playerTwoSign);
                playerTwo.setText(playerOneSign);

            }
        });

        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String playerSign, computerSign;
                playerSign = player.getText().toString();
                computerSign = computer.getText().toString();

                player.setText(computerSign);
                computer.setText(playerSign);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editorPrefs.putString("playeronesign", playerOne.getText().toString());
                editorPrefs.putString("playertwosign", playerTwo.getText().toString());
                editorPrefs.putString("playersign", player.getText().toString());
                editorPrefs.putString("computersign", computer.getText().toString());

                editorPrefs.apply();
                finish();
            }
        });

    }

    private void assignPlayerSigns(Button button, String text){
        button.setText(text);
    }

}