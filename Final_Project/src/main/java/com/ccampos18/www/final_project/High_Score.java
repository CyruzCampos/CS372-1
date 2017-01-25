package com.ccampos18.www.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * High_Score class reads from a text file and then displays that text file so the users can see what to
 * do in the game. It is read from a text file so it could be alter whenever.
 */
public class High_Score extends AppCompatActivity {

    /**
     * OnCreate is the function to create the activity in the application, this activity is called
     * High_Score. There is a button to send the user back to the main menu and displays the users
     * who have achieved a high score.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high__score);

        Button Main_Menu = (Button) findViewById(R.id.button);
        TextView Scores = (TextView) findViewById(R.id.Scores);

        Main_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(High_Score.this, Game_Choice.class));
            }
        });

        String text = "";

        try {
            InputStream IS = getAssets().open("High_Scores.txt");
            int size = IS.available();
            byte[] buffer = new byte[size];
            IS.read(buffer);
            IS.close();
            text = new String(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Scores.setText(text);
    }
}
