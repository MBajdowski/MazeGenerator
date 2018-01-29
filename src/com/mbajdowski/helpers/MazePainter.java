package com.mbajdowski.helpers;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MazePainter {

    private int height;
    private int width;
    private int strokeSize;
    private Color mazeColor;
    private Color startingPoints;
    private BufferedImage frame;

    public MazePainter(int height, int width, int strokeSize, Color mazeColor, Color startingPoints) {
        this.height = height;
        this.width = width;
        this.strokeSize = strokeSize;
        this.mazeColor = mazeColor;
        this.startingPoints = startingPoints;
        this.frame = new BufferedImage(
                (2* width+1)*strokeSize,
                (2* height+1)*strokeSize,
                BufferedImage.TYPE_INT_RGB );
    }

    public BufferedImage colorNode(int x, int y) {
        int startX = (2*x+1)*strokeSize;
        int startY = (2*y+1)*strokeSize;

        Graphics g = frame.getGraphics();
        g.setColor(mazeColor);
        g.fillRect(startX, startY, strokeSize, strokeSize);
        g.dispose();

        return frame;
    }

    public BufferedImage colorTransition(int x, int y, int x1, int y1) {
        return colorTransition(x, y, x1, y1, mazeColor);
    }

    public void addStartAndEnd() {
        //Start
        colorTransition(0,0,-1,0, startingPoints);
        //End
        colorTransition(width-1, height-1, width, height-1, startingPoints);
    }

    public BufferedImage getFrame() {
        return frame;
    }

    private BufferedImage colorTransition(int x, int y, int x1, int y1, Color color) {
        int x_diff = x1-x+1;
        int y_diff = y1-y+1;
        int startX = (2*x+x_diff)*strokeSize;
        int startY = (2*y+y_diff)*strokeSize;

        Graphics g = frame.getGraphics();
        g.setColor(color);
        g.fillRect(startX, startY, strokeSize, strokeSize);
        g.dispose();

        return frame;
    }
}
