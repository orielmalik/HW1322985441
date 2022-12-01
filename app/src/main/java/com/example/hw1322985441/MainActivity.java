package com.example.hw1322985441;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
public class MainActivity extends AppCompatActivity  {

    private ExtendedFloatingActionButton efl, efr;
    private ImageView h1, h2, h3, cruise, c2, c3;//c2-left
    private ImageView[][] rocks;
private static  int b=0;
private TimerActivity timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

this.timer=new TimerActivity();
this.timer.onCreate(savedInstanceState);
      this.timer.startTimer(this.rocks);



        cruise = new ImageView(this);
        c2 = new ImageView(this);
        c3 = new ImageView(this);
        findViews();
       // visi(c2, c3);
       // startMatrix();

     //   rockFalls();
        MakeActiotoLeft();
        MakeActiotoRight();
    }

    private void findViews() {
        efl = findViewById(R.id.main_BTN_left);
        efr = findViewById(R.id.main_BTN_right);
        h1 = findViewById(R.id.ic_heart1);
        h2 = findViewById(R.id.ic_heart2);
        h3 = findViewById(R.id.ic_heart3);
        cruise = findViewById(R.id.ic_LBL_car2);
        c2 = findViewById(R.id.ic_LBL_car);
        c3 = findViewById(R.id.ic_LBL_car3);


    }

    private void MakeActiotoLeft() {
        efr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                visi(cruise, c3);
                timer.stopTimer();
            }
        });
    }

    private void MakeActiotoRight() {
        efl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                visi(cruise, c3);
b=0;

            }
        });
    }

    private void visi(ImageView a, ImageView v) {
        a.setVisibility(View.INVISIBLE);
        v.setVisibility(View.INVISIBLE);

    }






    private void startMatrix() {
        this.rocks = new ImageView[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.rocks[i][j] = new ImageView(this);
            }
        }
        this.rocks[0][0].findViewById(R.id.r1);
        this.rocks[0][1].findViewById(R.id.r2);
        this.rocks[2][0].findViewById(R.id.r3);
        this.rocks[1][0].findViewById(R.id.r4);
        this.rocks[1][1].findViewById(R.id.r5);
        this.rocks[1][2].findViewById(R.id.r6);
        this.rocks[0][2].findViewById(R.id.r7);
        this.rocks[2][1].findViewById(R.id.r8);
        this.rocks[2][2].findViewById(R.id.r9);












    }
}



