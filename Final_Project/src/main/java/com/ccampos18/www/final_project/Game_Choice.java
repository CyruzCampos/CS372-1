package com.ccampos18.www.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Game_Choice class is the main screen for users to decide whether they wish to sign out, decide
 * what game they wish to play, a help button to send them to the help screen, as well as high score
 * button to send them to the high score screen.
 */
public class Game_Choice extends AppCompatActivity {

    /**
     * OnCreate is the funtction to create the activity in the application, this activity is called
     * Game_Choice. There are multiple buttons that are set to have certain images and text to send
     * the user to whatever they decide to click on.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__choice);

        Button Addition = (Button) findViewById(R.id.Addition); Addition.setBackgroundResource(R.drawable.addition);
        Button Subtraction = (Button) findViewById(R.id.Subtraction); Subtraction.setBackgroundResource(R.drawable.subtraction);
        Button Multiplication = (Button) findViewById(R.id.Multiplicaiton); Multiplication.setBackgroundResource(R.drawable.multiplication);
        Button Division = (Button) findViewById(R.id.Division); Division.setBackgroundResource(R.drawable.division);
        Button Help = (Button) findViewById(R.id.Help);
        Button Sign_Out = (Button) findViewById(R.id.Sign_Out);
        final Button High_Score = (Button) findViewById(R.id.HighScores);

        Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, com.ccampos18.www.final_project.Addition.class));
            }
        });

        Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, com.ccampos18.www.final_project.Subtraction.class));
            }
        });

        Multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, com.ccampos18.www.final_project.Multiplication.class));
            }
        });

        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, com.ccampos18.www.final_project.Division.class));
            }
        });

        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, com.ccampos18.www.final_project.Help.class));
            }
        });

        Sign_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, Main_Activity.class));
            }
        });

        High_Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Choice.this, High_Score.class));
            }
        });
    }
}
