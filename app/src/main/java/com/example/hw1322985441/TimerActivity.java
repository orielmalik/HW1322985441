package com.example.hw1322985441;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {
    final int DELAY = 1000;

long startTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
        public void updateTimerUI() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            int hours = minutes / 60;
            minutes = minutes % 60;
            hours %= 24;

        }

    public void stopTimer() {
        timer.cancel();
    }

    private Timer timer = new Timer();


    private void rockFalls(ImageView[][]rocks) {

        Random r = new Random();
        int ra = r.nextInt(2);
       rocks[2][ra].setVisibility(View.VISIBLE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 2 && j != ra) {
                   rocks[i][j].setVisibility(View.INVISIBLE);
                }
            }
        }


    }




    public void startTimer(ImageView[][]rocks) {
        startTime = System.currentTimeMillis();
        timer = new Timer();
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        Log.d("TimerCount A:", Thread.currentThread().getName() + " " + System.currentTimeMillis());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rockFalls(rocks);
                                Log.d("TimerCount B:", Thread.currentThread().getName() + " " + System.currentTimeMillis());

                            }
                        });
                    }
                }
                , DELAY, DELAY);
    }



    }