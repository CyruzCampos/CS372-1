package com.ccampos18.www.hw4_3;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main_Function extends AppCompatActivity{
    public Roll[] dice = new Roll[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__function);

        Button Start = (Button) this.findViewById(R.id.StartButton);
        ImageView one = (ImageView) this.findViewById(R.id.image1);
        ImageView two = (ImageView) this.findViewById(R.id.image2);
        ImageView three = (ImageView) this.findViewById(R.id.image3);
        ImageView four = (ImageView) this.findViewById(R.id.image4);
        ImageView five = (ImageView) this.findViewById(R.id.image5);

        dice[0] = new Roll(one, this);
        dice[1] = new Roll(two, this);
        dice[2] = new Roll(three, this);
        dice[3] = new Roll(four, this);
        dice[4] = new Roll(five, this);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    Thread[] t = new Thread[5];
                    t[i] = new Thread(dice[i]);
                    t[i].start();
            }
    }
});
    }
}
