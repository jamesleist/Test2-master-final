package com.example.james.soccer;

/**
 * Created by james on 3/7/2017.
 */

public class Goalie extends Player {
    public Goalie(String fname, String lname, int[] numbers) {
        super(fname, lname, "G", numbers);
    }

    @Override
    public void setZone(int SIDE_OF_FIELD) {

    }

    @Override
    public void defend(Ball ball) {
        if(ball.getLocation().y>15){
            
        }
    }

    @Override
    public void attack(Ball ball) {

    }
}
