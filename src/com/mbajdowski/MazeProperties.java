package com.mbajdowski;

import java.awt.*;

public class MazeProperties {

    private int height;
    private int width;
    private int strokeSize;
    private boolean inLoop;
    private String path;
    private String name;
    private int speed;
    private Color colorOfMaze;
    private Color colorOfStartingPoints;

    public MazeProperties() {
        height = 10;
        width = 10;
        strokeSize = 10;
        inLoop = false;
        path = "";
        name = "maze";
        speed = 10;
        colorOfMaze = Color.WHITE;
        colorOfStartingPoints = Color.RED;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public boolean isInLoop() {
        return inLoop;
    }

    public void setInLoop(boolean inLoop) {
        this.inLoop = inLoop;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColorOfMaze() {
        return colorOfMaze;
    }

    public void setColorOfMaze(Color colorOfMaze) {
        this.colorOfMaze = colorOfMaze;
    }

    public Color getColorOfStartingPoints() {
        return colorOfStartingPoints;
    }

    public void setColorOfStartingPoints(Color colorOfStartingPoints) {
        this.colorOfStartingPoints = colorOfStartingPoints;
    }
}
