package com.mbajdowski;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        MazeProperties mp = new MazeProperties();
        mp.setSpeed(3);
        mp.setHeight(10);
        mp.setWidth(10);
        mp.setStrokeSize(10);
        mp.setInLoop(false);
        mp.setColorOfMaze(Color.WHITE);
        MazeBuilder mb = new MazeBuilder(mp);

        long startTime = System.currentTimeMillis();
        mb.generateMaze();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}
