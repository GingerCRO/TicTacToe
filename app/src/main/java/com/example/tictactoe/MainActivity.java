package com.example.tictactoe;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button playerVsPlayer, playerVsComputer, settings, about;
    Dialog dialogAbout;
    TextView githubLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playerVsPlayer = (Button) findViewById(R.id.buttonPlayerVsPlayer);
        playerVsComputer = (Button) findViewById(R.id.buttonPlayerVsComputer);
        settings = (Button) findViewById(R.id.buttonSettings);
        about = (Button) findViewById(R.id.buttonAbout);

        dialogAbout = new Dialog(MainActivity.this);
        dialogAbout.setContentView(R.layout.about_box);
        dialogAbout.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        githubLink = (TextView) dialogAbout.findViewById(R.id.textViewGithub);

        playerVsPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(playGame);
            }
        });

        playerVsComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(playGame);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(openSettings);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAbout.show();
            }
        });

        githubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visitGithub = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/gingercro"));
                startActivity(visitGithub);
            }
        });

        //

    }

}