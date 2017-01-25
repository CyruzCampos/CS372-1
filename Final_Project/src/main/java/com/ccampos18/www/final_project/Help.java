package com.ccampos18.www.final_project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Help class reads from a text file and then displays that text file so the users can see what to
 * do in the game. It is read from a text file so it could be alter whenever.
 */
public class Help extends AppCompatActivity {

    /**
     * OnCreate is the function to create the activity in the application, this activity is called
     * Help. There is a button to send the user back to the main menu and displays the rules of the
     * game.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final Button Main_Menu = (Button) findViewById(R.id.Main_Menu);
        final TextView Help_Text = (TextView) findViewById(R.id.Help_Text);

        Main_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Help.this, Game_Choice.class));
            }
        });

        String text = "";

        try {
            InputStream IS = getAssets().open("Helpful_Tips.txt");
            int size = IS.available();
            byte[] buffer = new byte[size];
            IS.read(buffer);
            IS.close();
            text = new String(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Help_Text.setText(text);
    }
}
