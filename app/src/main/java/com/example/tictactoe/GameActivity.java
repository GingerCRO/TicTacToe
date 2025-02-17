package com.example.tictactoe;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Dialog dialogWinner;
    Button playerOneSign, playerTwoSign;
    Button gameButton0, gameButton1, gameButton2, gameButton3, gameButton4, gameButton5, gameButton6, gameButton7, gameButton8;
    Button winnerDialogYes, winnerDialogNo;
    TextView playerOneLabel, playerTwoLabel, winnerName;
    ImageView restartArrows;

    int step = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random random = new Random();

        playerOneSign = (Button) findViewById(R.id.playerOneSign);
        playerTwoSign = (Button) findViewById(R.id.playerTwoSign);

        gameButton0 = (Button) findViewById(R.id.buttonPanel0);
        gameButton1 = (Button) findViewById(R.id.buttonPanel1);
        gameButton2 = (Button) findViewById(R.id.buttonPanel2);
        gameButton3 = (Button) findViewById(R.id.buttonPanel3);
        gameButton4 = (Button) findViewById(R.id.buttonPanel4);
        gameButton5 = (Button) findViewById(R.id.buttonPanel5);
        gameButton6 = (Button) findViewById(R.id.buttonPanel6);
        gameButton7 = (Button) findViewById(R.id.buttonPanel7);
        gameButton8 = (Button) findViewById(R.id.buttonPanel8);

        Button[] buttonList = {gameButton0, gameButton1, gameButton2, gameButton3, gameButton4, gameButton5, gameButton6, gameButton7, gameButton8};

        playerOneLabel = (TextView) findViewById(R.id.playerOneLabel);
        playerTwoLabel = (TextView) findViewById(R.id.playerTwoLabel);

        restartArrows = (ImageView) findViewById(R.id.imageButtonRestart);

        dialogWinner = new Dialog(GameActivity.this);
        dialogWinner.setContentView(R.layout.game_result_box);
        dialogWinner.setCancelable(false);
        dialogWinner.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        winnerDialogYes = (Button) dialogWinner.findViewById(R.id.buttonYes);
        winnerDialogNo = (Button) dialogWinner.findViewById(R.id.buttonNo);
        winnerName = (TextView) dialogWinner.findViewById(R.id.displayWinner);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String gameMode = sharedPreferences.getString("gamemode", "false");
        String playerOneSignPrefs = sharedPreferences.getString("playeronesign", "X");
        String playerTwoSignPrefs = sharedPreferences.getString("playertwosign", "O");
        String playerSignPrefs = sharedPreferences.getString("playersign", "X");
        String computerSignPrefs = sharedPreferences.getString("computersign", "O");

        boolean pvpMode;

        if (gameMode.equals("pvp")){

            pvpMode = true;
            playerOneLabel.setText("Player One:");
            playerTwoLabel.setText("Player Two:");

            playerOneSign.setText(playerOneSignPrefs);
            playerTwoSign.setText(playerTwoSignPrefs);

        } else{

            pvpMode = false;
            playerOneLabel.setText("Player:");
            playerTwoLabel.setText("Computer:");

            playerOneSign.setText(playerSignPrefs);
            playerTwoSign.setText(computerSignPrefs);

        }

        gameButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton0, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton1, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton2, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton3, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton4, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton5, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton6, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton7, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        gameButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSetSign(buttonList, gameButton8, pvpMode, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs, random);
                checkForWinner(buttonList, pvpMode, step, playerOneSignPrefs, playerTwoSignPrefs, playerSignPrefs, computerSignPrefs);
            }
        });

        restartArrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Button button : buttonList){
                    button.setText("");
                    button.setClickable(true);
                }
                step = 0;
            }
        });

        winnerDialogYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Button button : buttonList){
                    button.setText("");
                    button.setClickable(true);
                }
                step = 0;
                dialogWinner.dismiss();
            }
        });

        winnerDialogNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void buttonSetSign(Button[] buttonList, Button button, boolean pvpMode, String playerOneSignPrefs, String playerTwoSignPrefs, String playerSignPrefs, String computerSignPrefs, Random random){

        if (pvpMode){
            if (this.step % 2 == 0){
                button.setText(playerOneSignPrefs);
            } else{
                button.setText(playerTwoSignPrefs);
            }
            this.step++;
        } else{

            int randomNumber;
            button.setText(playerSignPrefs);
            this.step++;

            if (this.step < 8){
                do {
                    randomNumber = random.nextInt(9);
                } while (!buttonList[randomNumber].getText().equals(""));
                this.step++;
                buttonList[randomNumber].setText(computerSignPrefs);
                buttonList[randomNumber].setClickable(false);
            }
        }
        button.setClickable(false);
    }

    private void checkForWinner(Button[] buttonList, boolean pvpMode, int step, String playerOneSignPrefs, String playerTwoSignPrefs, String playerSignPrefs, String computerSignPrefs){

        boolean winner = false;

        int[][] winCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combination : winCombinations){

            int a = combination[0], b = combination[1], c = combination[2];

            if (!buttonList[a].getText().toString().isEmpty() && buttonList[a].getText().equals(buttonList[b].getText()) && buttonList[b].getText().equals(buttonList[c].getText())){
                if (pvpMode && buttonList[a].getText().equals(playerOneSignPrefs)){
                    showWinner("PLAYER ONE");
                } else if (pvpMode && buttonList[a].getText().equals(playerTwoSignPrefs)){
                    showWinner("PLAYER TWO");
                } else if (!pvpMode && buttonList[a].getText().equals(playerSignPrefs)){
                    showWinner("PLAYER");
                } else if (!pvpMode && buttonList[a].getText().equals(computerSignPrefs)){
                    showWinner("COMPUTER");
                }

                winner = true;
                break;
            }

        }

        if (winner){
            disableAllButtons(buttonList);
            return;
        }

        if (step == 9){
            showWinner("DRAW");
            disableAllButtons(buttonList);
        }

    }

    private void showWinner(String name){

        if (name.equals("PLAYER ONE")){
            winnerName.setText("PLAYER ONE WON THE GAME");
        } else if (name.equals("PLAYER TWO")){
            winnerName.setText("PLAYER TWO WON THE GAME");
        } else if (name.equals("PLAYER")){
            winnerName.setText("PLAYER WON THE GAME");
        } else if (name.equals("COMPUTER")){
            winnerName.setText("COMPUTER WON THE GAME");
        } else if (name.equals("DRAW")){
            winnerName.setText("IT'S A DRAW");
        }

        dialogWinner.show();

    }

    private void disableAllButtons(Button[] buttonList){
        for (Button button : buttonList){
            button.setClickable(false);
        }
    }

}