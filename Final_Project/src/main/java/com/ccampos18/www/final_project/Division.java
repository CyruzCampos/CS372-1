package com.ccampos18.www.final_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Division class that shows only division problems to the users, each problem is randomly generated.
 * Also it will keep track of how many times they attempted to answer a question as well as how many
 * questions they got correct.
 */
public class Division extends AppCompatActivity {
    java.util.Random Random = new Random();
    int Answer = 0;
    int Correct = 0;
    int Tries = 1;

    int R_1 = 0;
    int R_2 = 0;
    int R_3 = 0;
    int R_4 = 0;

    /**
     * OnCreate is the function to create the activity in the application, this activity is called
     * Division.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        Questions();
    }

    /**
     * The Message function outputs how many questions the user got correctly out of how many tries
     * they are given. Once the user hits the "OK" button, they will be sent back to the game_choice
     * screen.
     */
    public void Message () {
        AlertDialog Text = new AlertDialog.Builder(Division.this).create();
        Text.setTitle("Correct Guesses");
        Text.setMessage(String.format("%d / %d", Correct, Tries));
        Text.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Division.this, Game_Choice.class));
            }
        });
        Text.show();
    }

    /**
     * The Questions function generates different numbers each time the user answers a question,
     * once they reach a certain amount of tries the message will be outputted and they are sent
     * to the game_choice screen. Each button will generate a different answer for the quesiton,
     * except one button (picked at random) will have the correct answer, and will change every time,
     * the user clicks on a button.
     */
    public void Questions () {
        int Num_1 = Random.nextInt(50);
        int Num_2 = Random.nextInt(50);
        Answer = Num_1 / Num_2;

        String Q = String.format("%d / %d", Num_1, Num_2);

        TextView Question = (TextView) findViewById(R.id.Question);
        Question.setText(Q);

        Button Answer_1 = (Button) findViewById(R.id.Answer_1);
        Button Answer_2 = (Button) findViewById(R.id.Answer_2);
        Button Answer_3 = (Button) findViewById(R.id.Answer_3);
        Button Answer_4 = (Button) findViewById(R.id.Answer_4);

        int R_Answer_1 = Random.nextInt(100) + 1;
        int R_Answer_2 = Random.nextInt(100) + 1;
        int R_Answer_3 = Random.nextInt(100) + 1;
        int R_Answer_4 = Random.nextInt(100) + 1;

        Answer_1.setText(String.format("%d", R_Answer_1));
        Answer_2.setText(String.format("%d", R_Answer_2));
        Answer_3.setText(String.format("%d", R_Answer_3));
        Answer_4.setText(String.format("%d", R_Answer_4));

        int choice = Random.nextInt(4) + 1;

        switch (choice) {
            case 1: Answer_1.setText(String.format("%d", Answer)); R_Answer_1 = Answer;
                break;
            case 2: Answer_2.setText(String.format("%d", Answer)); R_Answer_2 = Answer;
                break;
            case 3: Answer_3.setText(String.format("%d", Answer)); R_Answer_3 = Answer;
                break;
            case 4: Answer_4.setText(String.format("%d", Answer)); R_Answer_4 = Answer;
                break;
        }

        R_1 = R_Answer_1;
        R_2 = R_Answer_2;
        R_3 = R_Answer_3;
        R_4 = R_Answer_4;

        Answer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R_1 == Answer) {
                    Correct++;
                }

                if (Tries == 5) {
                    Message();
                }
                Tries++;
                Questions();
            }
        });

        Answer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R_2 == Answer) {
                    Correct++;
                }

                if (Tries == 5) {
                    Message();
                }
                Tries++;
                Questions();
            }
        });

        Answer_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R_3 == Answer) {
                    Correct++;
                }

                if (Tries == 5) {
                    Message();
                }
                Tries++;
                Questions();
            }
        });

        Answer_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R_4 == Answer) {
                    Correct++;
                }

                if (Tries == 5) {
                    Message();
                }
                Tries++;
                Questions();
            }
        });
    }
}
