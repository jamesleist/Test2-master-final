package com.example.james.soccer;

import android.graphics.Point;

import java.io.InvalidObjectException;
import java.util.ArrayList;

/**
 * Created by james on 2/27/2017.
 */

public class Player {
    private String fname, lname = "";
    private ArrayList<Integer> stats;
    private int overall, teamId;
    private Point location;
    private boolean hasBall;
    private Point zoneCenter;


    public Player(String fname, String lname, int[] numbers){
        this.fname = fname;
        this.lname = lname;
        for(int i = 0; i < numbers.length; i++) {
            switch (i) {
                case 0:
                    overall = numbers[i];
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
                case 10:
                    stats.add(numbers[i]);
                    break;
                case 11:
                    teamId = numbers[i];
            }
        }
    }
    public void setLocation(Point location){
        this.location = location;
    }
    public void setZone(Point location){
        this.location = location;
    }
    public void pass(Ball ball, Point goal, Player target){
        if(!hasBall)
            return;
        ball.isKicked(goal, getVelocityPass(goal));
        hasBall = false;
    }
    public void shoot(Ball ball, Point goal){
        if(!hasBall)
            return;

        hasBall = false;
    }
    private double getVelocityShot(){
        return 0.0;
    }
    private double getVelocityPass(Point goal){
        return 0.0;
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
