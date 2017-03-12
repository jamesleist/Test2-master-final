package com.example.james.soccer;

import android.graphics.Point;

import java.io.InvalidObjectException;
import java.util.ArrayList;

/**
 * Created by james on 2/27/2017.
 */

public abstract class Player {
    private String fname, lname, position = "";
    private ArrayList<Integer> stats;
    private int overall, teamId, SIDE_OF_FIELD;
    private Point location, zoneCenter, goal;
    private boolean hasBall, user = false;
    private double velocity;

    public Player(String fname, String lname,String position, int[] numbers){
        this.fname = fname;
        this.lname = lname;
        this.position = position;
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
    public abstract void setZone(int SIDE_OF_FIELD);
    public abstract void defend(Ball ball);
    public abstract void attack(Ball ball);

    public void pass(Ball ball, Point goal){
        if(!hasBall)
            return;
        ball.isKicked(goal, getVelocityPass(ball, goal));
        hasBall = false;
    }
    public void shoot(Ball ball, int SIDE_OF_FIELD, Point goal){
        if(!hasBall)
            return;
        double distance = ball.getDistanceFrom(goal);
        if(SIDE_OF_FIELD == Constants.RIGHT_SIDE){
            goal.set(150, goal.y);
        } else {
            goal.set(-150, goal.y);
        }
        ball.isKicked(goal, getVelocityShot(distance));
        hasBall = false;
    }
    private double getVelocityShot(double distance){
        int shooting = stats.get(5);
        return distance * (.3) * (shooting/100);
    }
    private double getVelocityPass(Ball ball, Point goal){
        double distance = ball.getDistanceFrom(goal);
        int passing = stats.get(6);
        return distance * (.3) * (passing/100);
    }
    public void move(Point goal){
        int speed = stats.get(2);
        int newX = (int)(location.x + ((speed/100)*((goal.x - location.x)/((goal.x - location.x)+(goal.y - location.y)))));
        int newY = (int)(location.y + ((speed/100)*((goal.y - location.y)/((goal.x - location.x)+(goal.y - location.y)))));
        location.set(newX, newY);
    }
    public void dribble(Ball ball, Point goal){
        move(goal);
        ball.setLocation(location);
    }


    public String getPosition(){
        return position;
    }
    public void setZoneCenter(Point location){
        zoneCenter = location;
    }
    public void setLocation(Point location){
        this.location = location;
    }
    public Point getGoal() {
        return goal;
    }
    public void setGoal(Point goal) {
        this.goal = goal;
    }
    public Point getZoneCenter() {
        return zoneCenter;
    }
    public Point getLocation() {
        return location;
    }
    public String getLname() {
        return lname;
    }
    public String getFname() {
        return fname;
    }
    public boolean getHasBall(){
        return hasBall;
    }
    public void giveBall() {
        hasBall = true;
    }
    public boolean isUser(){
        return user;
    }
    public void setUser(boolean user){
        this.user = user;
    }
    public boolean isMoving(){
        return (velocity != 0);
    }

    public int getSIDE_OF_FIELD() {
        return SIDE_OF_FIELD;
    }

    public void setSIDE_OF_FIELD(int SIDE_OF_FIELD) {
        this.SIDE_OF_FIELD = SIDE_OF_FIELD;
    }
}
