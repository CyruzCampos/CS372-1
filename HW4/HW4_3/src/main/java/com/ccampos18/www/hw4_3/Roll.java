package com.ccampos18.www.hw4_3;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

import java.util.logging.LogRecord;

/**
 * Created by ccampos18 on 1/20/2017.
 */

public class Roll implements Runnable {
    ImageView _Image;
    Random random = new Random();
    Context c;
    Handler mainHandler;

    public Roll(ImageView Image, Context c) {
        _Image = Image;
        this.c = c;
        dice_roll();
    }

    public void dice_roll() {
        mainHandler = new Handler(c.getMainLooper());
        Runnable runnable = new Runnable() {
            public void run () {
                int randoms = random.nextInt(6) + 1;
                switch (randoms) {
                    case 1:
                        _Image.setImageResource(R.drawable.die_face_1);
                        break;

                    case 2:
                        _Image.setImageResource(R.drawable.die_face_2);
                        break;

                    case 3:
                        _Image.setImageResource(R.drawable.die_face_3);
                        break;

                    case 4:
                        _Image.setImageResource(R.drawable.die_face_4);
                        break;

                    case 5:
                        _Image.setImageResource(R.drawable.die_face_5);
                        break;

                    case 6:
                        _Image.setImageResource(R.drawable.die_face_6);
                        break;
                }
            }
        };
        mainHandler.post(runnable);
    }

    @Override
    public void run() {
        int timer = random.nextInt(100) + 1;
        for (int i = timer; i >= 0; i--) {
            this.dice_roll();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {
                ;
            }
        }
    }
}
