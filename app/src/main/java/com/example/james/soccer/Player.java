package com.example.james.soccer;

import android.graphics.Point;

import java.io.InvalidObjectException;
import java.util.ArrayList;

/**
 * Created by james on 2/27/2017.
 */

public abstract class Player {
    private String fname, lname = "";
    private ArrayList<Integer> stats;
    private int overall, teamId;
    private Point location;
    private boolean hasBall;
    private Point zoneCenter;

    public Player() throws InvalidObjectException {
        throw new InvalidObjectException("Player");
    }
    public Player(String fname, String lname, int[] numbers){
        this.fname = fname;
        this.lname = lname;
        for(int i = 0; i < numbers.length; i++){
            switch(i){
                case 0: overall = numbers[i];
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10: stats.add(numbers[i]);
                    break;
                case 11: teamId = numbers[i];
            }
        }
        setLocation();
        setZone();
    }
    public abstract void setLocation();
    public abstract void setZone();
    public void pass(Ball ball){

    }
    public void shoot(Ball ball){

    }
    public void move(Point goal){

    }
    public boolean getHasBall(){
        return hasBall;
    }
    public void giveBall() {
        hasBall = true;
    }
}
