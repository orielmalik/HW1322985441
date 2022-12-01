package com.example.hw1322985441;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public  class TimerActivity extends AppCompatActivity {

    final int DELAY = 1000;

   int[][]rocks;
    ImageView[][]target;

    long startTime = 0;
private  View vv;

public  TimerActivity( ImageView[][]tar,int[][] a)
{
    //this.rocks=new int[3][3];

  //  this.target=new ImageView[3][3];
    this.target=tar;
    this.rocks=a;
}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, DELAY); //do it again in a second.
                updateRocks(rocks,3,3,target);
            }
        };

    }

    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY); //do it again in a second.
            updateRocks(rocks,3,3,target);
        }
    };

    private void updateTimerUI() {
        Log.d("TimerCount", "" + System.currentTimeMillis());
        long millis = System.currentTimeMillis() - startTime;
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        int hours = minutes / 60;
        minutes = minutes % 60;
        hours %= 24;

    }

  private void helper(int[][] rocks,int c,int r) {
      Random rs = new Random();

      int ra = rs.nextInt(rocks[0].length - 1);
     rs = new Random();

      int rt = rs.nextInt(rocks.length - 1);

      rocks[rt][ra] = 1;

      for (int i = 0; i < r; i++) {
          for (int j = 0; j < c; j++) {
              if (i != rt && j != ra) {
                  rocks[i][j] = 0;
              }
          }
      }
  }
    public void stopTimer() {
        handler.removeCallbacks(runnable);
    }

   public void startTimer() {
        startTime = System.currentTimeMillis();
        handler.postDelayed(runnable,DELAY);

    }

              private void updateRocks(int[][] rocks, int c, int r, ImageView[][] target)
              {
                  helper(rocks,c,r);
                  for (int i = 0; i < r; i++) {
                      for (int j = 0; j < c; j++) {

                          if(rocks[i][j]==1)
                          {
                          target[i][j].setVisibility(View.VISIBLE);
                          }
                          else
                          {
                              target[i][j].setVisibility(View.INVISIBLE);

                          }
                  }
                      }

              }


    public void setRocks(int[][] rocks) {
        this.rocks = rocks;
    }

    public int[][] getRocks() {
        return rocks;
    }

    public void setTarget(ImageView[][] target) {
        this.target = target;
    }

    public ImageView[][] getTarget() {
        return target;
    }
}