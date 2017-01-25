package com.ccampos18.www.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Create_Account class that shows two edit text fields for users to generate their own username
 * and password that will be sent to a parse library and saved, so that one user will be the only
 * one who knows their account information. Everything is connected to a certain parse library.
 */
public class Create_Account extends AppCompatActivity {

    /**
     * OnCreate is the function to create the activity in the application, this activity is called
     * Create_Account. The button that is set will grab whatever the user puts for the fields and
     * send it to parse to be saved in the database, then the user is sent to the main screen to
     * sign in to play the game.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account);

        Button Finish = (Button) findViewById(R.id.Finish);

        final EditText NewUserName = (EditText) findViewById(R.id.NewUserName);
        final EditText NewPassWord = (EditText) findViewById(R.id.NewPassWord);

        Finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername(NewUserName.getText().toString());
                user.setPassword(NewPassWord.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            System.out.println("Account was created!");
                            startActivity(new Intent(Create_Account.this, Main_Activity.class));
                        }
                        else {
                            System.out.println("Something went wrong: " + e.getLocalizedMessage());
                            startActivity(new Intent(Create_Account.this, Main_Activity.class));
                        }
                    }
                });
            }
        });
    }
}
