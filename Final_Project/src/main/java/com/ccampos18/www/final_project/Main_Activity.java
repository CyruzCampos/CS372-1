package com.ccampos18.www.final_project;

import android.content.EntityIterator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Main_Activity class that class that shows two edit text fields for users to sign in with their
 * own username and password. Which will be sent to a parse library and checked. Everything is
 * connected to a certain parse library. Due to parse not working, it will bypass the check,
 * and automatically send the user to the game without credentials.
 */
public class Main_Activity extends AppCompatActivity {

    /**
     * OnCreate is the function to create the activity in the application, this activity is called
     * Main_Activity. The button that is set will grab whatever the user puts for the fields and
     * send it to parse to be checked, then the user is sent to the game choice to play the game.
     * There is also a create account button to send users to the create account screen to
     * create their account if they have not made one yet.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        final EditText UserNameText = (EditText) findViewById(R.id.Username);
        final EditText PassWordText = (EditText) findViewById(R.id.Password);
        final Button CreateAccount = (Button) findViewById(R.id.CreateAccount);
        Button SignIn = (Button) findViewById(R.id.Sign_in);

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main_Activity.this, Create_Account.class));
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ParseUser.logInInBackground(UserNameText.getText().toString(), PassWordText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            System.out.println("User Successfully Signed in!");
                */            startActivity(new Intent(Main_Activity.this, Game_Choice.class));
                /*        }
                        else {
                            System.out.println("Something went wrong: " + e.getLocalizedMessage());
                        }
                    }
                });
        */    }
        });
    }
}
