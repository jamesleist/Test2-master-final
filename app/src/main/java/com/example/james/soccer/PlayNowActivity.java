package com.example.james.soccer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PlayNowActivity extends AppCompatActivity{
    private int TEAM_SELECT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_now);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void teamSelect(View view) {
        Intent myIntent = new Intent(this,TeamSelectActivity.class);
        startActivityForResult(myIntent, TEAM_SELECT_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TEAM_SELECT_CODE) {
            if(resultCode == RESULT_OK) {

            }
        }
    }
}
