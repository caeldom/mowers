package com.example.mowers;

import java.util.*;

/**
 * Created by Dan on 20/04/2015.
 */
public class Root {

    public static void main(String[] args){
        List<Mower> mowers = new ArrayList<>();             // create list of mowers
        Scanner in = new Scanner(System.in);                // input
        int count = 0;                                      // holds max number of steps

        System.out.println("PART 1 : LAWN MOWING\n\n" +
                "1 - grid dimensions: {x y} eg. '5 5' <press enter>\n" +
                "2 - create a mower: {x y direction[N,E,S,W]} eg. '1 2 N' <press enter>\n" +
                "3 - instructions for mower: M - move, L - rotate left, R - rotate right\n" +
                "      eg. 'LMLMLMLMM' <press enter>\n" +
                "4 - repeat steps 2 & 3 for each additional mower, then press enter to run.\n\n" +
                "Input:");
        String input = in.nextLine();                       // input the grid dimensions
        String[] split = input.split(" ");
        int gridx = Integer.parseInt(split[0]);             // store grid xbound
        int gridy = Integer.parseInt(split[1]);             // store grid ybound
        while(!(input = in.nextLine()).equals("")){         // loop for inputting mowers
            split = input.split(" ");                       // split and store input x y direction
            input = in.nextLine();                          // input for steps
            if (input.length() > count)                     // store highest number of steps to take
                count = input.length();
            mowers.add(new Mower(Integer.parseInt(split[0]),Integer.parseInt(split[1]),split[2].charAt(0),input));
                                                            // add the mower to list: (x, y, direction, steps)
        }

        run:
        for (int i=0;i<=count;i++){                         // for each step
            for (Mower mower : mowers){                     // for each mower in list
                if (i==count){                              // if no more steps then print end position
                    System.out.println(mower.x()+" "+mower.y()+" "+mower.direction());
                } else {
                    mower.next(i);                          // process next step
                    for (Mower other : mowers) {            // for each other mower in list check if collision
                        if (mower != other && mower.x() == other.x() && mower.y() == other.y()) {
                            System.out.println("error: mower collision");
                            break run;
                        }
                    }
            }                                               // check if mower is still on grid
                if (mower.x() > gridx || mower.y() > gridy || mower.x() < 0 || mower.y() < 0) {
                    System.out.println("error: mower off grid");
                    break run;
                }
            }
        }
    }
}
