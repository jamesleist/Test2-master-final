package com.example.james.soccer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Richard Frolia on 3/12/2017.
 */

public class PracticeActivity extends AppCompatActivity {
    Striker st = new Striker("Air", "Bud", "RS", new int[]{26, 99, 99, 99, 99, 99, 99, 99, 99, 0, 1});
    Goalie gk = new Goalie("Donald", "Trump", new int[]{70, 85, 85, 85, 85, 85, 85, 85, 85, 85, 12});


    GameplayActivity g = new GameplayActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

    }
}
