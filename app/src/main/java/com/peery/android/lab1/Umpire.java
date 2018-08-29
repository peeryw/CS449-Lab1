package com.peery.android.lab1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Umpire extends AppCompatActivity {

    int mCounterStrike = 0;
    int mCounterBall = 0;
    TextView mStrikeCount;
    TextView mBallCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpire);

        mStrikeCount = findViewById(R.id.textViewStrikeCount);
        mBallCount = findViewById(R.id.textViewBallCount);
    }

    public void ball_count_up(View view) {
        if (mCounterBall < 3) {
            mCounterBall++;
            mBallCount.setText(String.valueOf(mCounterBall));
        } else {
            AlertDialog.Builder mWalkBuilder = new AlertDialog.Builder(Umpire.this);

            mWalkBuilder.setMessage("WALK!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mCounterBall = 0;
                    mCounterStrike = 0;
                    mBallCount.setText(String.valueOf(mCounterBall));
                    mStrikeCount.setText(String.valueOf(mCounterStrike));
                }
            }).setNegativeButton("", null).setCancelable(false);

            AlertDialog alert = mWalkBuilder.create();
            alert.show();
        }
    }

    public void strike_count_up(View view) {
        if (mCounterStrike < 2) {
            mCounterStrike++;
            mStrikeCount.setText(String.valueOf(mCounterStrike));
        } else {
            AlertDialog.Builder mStrikeBuilder = new AlertDialog.Builder(Umpire.this);

            mStrikeBuilder.setMessage("OUT!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mCounterStrike = 0;
                    mCounterBall = 0;
                    mStrikeCount.setText(String.valueOf(mCounterStrike));
                    mBallCount.setText(String.valueOf(mCounterBall));
                }
            }).setNegativeButton("", null).setCancelable(false);

            AlertDialog alert = mStrikeBuilder.create();
            alert.show();
        }
    }

}
