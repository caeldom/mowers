package com.example.mowers;

/**
 * Created by Dan on 20/04/2015.
 */
public class Mower {
    private int direction;                                          // current direction
    private char[] directionLetter = {'N', 'E', 'S', 'W'};          // char array to store direction letters
    private int x = 0;                                              // x coord
    private int y = 0;                                              // y coord
    private char[] steps;                                           // char array to store steps

    public Mower() {
        x = y = direction = 0;
    }

    public Mower(int x, int y, char d, String s){                   // args(x, y, direction, steps)
        this.x = x;
        this.y = y;
        direction = new String(directionLetter).indexOf(d+"");      // get direction int based off letter
        steps = s.toCharArray();                                    // convert input steps to array of char
    }

    public void next(int i){
    if (i < steps.length) {                                         // if there are still steps
            //System.out.print("current: "+steps[i]+". ");
            if (steps[i] == 'M') {                                  // move if step M
                move(directionLetter[direction]);
            } else {                                                // otherwise turn
                turn(steps[i]);
            }
        }
    }

    public void move(char d){
        //System.out.print("move "+d+" from ("+x+","+y+") to ");
        switch (d) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
            default:
                break;
        }
        //System.out.println("("+x+","+y+")");
    }

    public void turn(char d){
        //System.out.print("Turn "+d+" from "+direction+" "+directionLetter[direction]+" to ");
        if (d == 'L') {
            if (direction == 0) direction = 3;
            else direction--;
        } else {
            if (direction == 3) direction = 0;
            else direction++;
        }
        //System.out.println(direction+" "+directionLetter[direction]);
    }

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

    public char direction(){
        return directionLetter[direction];
    }
}
