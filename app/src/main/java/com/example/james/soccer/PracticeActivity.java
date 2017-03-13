package com.example.james.soccer;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.swing.*;

public class PracticeActivity extends AppCompatActivity {
    ImageView airbud, trump, ball_image;
    RelativeLayout myLayout;
    private int deltaX;
    private int deltaY;
    Striker user = new Striker("Air","Bud","LST",new int[]{26, 99, 99, 99, 99, 99, 99, 99, 99, 0, 1});
    Goalie goalie = new Goalie("Donald", "Trump", new int[]{70, 85, 85, 85, 85, 85, 85, 85, 85, 85, 12});
    Ball ball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        myLayout = (RelativeLayout)findViewById(R.id.layout);
        airbud = (ImageView)findViewById(R.id.airbud);
        trump = (ImageView)findViewById(R.id.trump);
        ball_image = (ImageView)findViewById(R.id.ball);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 100);
        user.setLocation(new Point((int)airbud.getX(), (int)airbud.getY()));
        ball = new Ball(new Point((int)ball_image.getX(), (int)ball_image.getY()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        myTimer timer = new myTimer(99999999, Constants.FIRST_HALF, user, goalie, ball, myLayout );
    }

    public boolean onTouch(View view, MotionEvent event){
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        user.setGoal(new Point(X,Y));
        return true;
    }
}
