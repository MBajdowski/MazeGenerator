package com.mbajdowski;

import com.mbajdowski.AnimatedGifEncoder.AnimatedGifEncoder;
import com.mbajdowski.helpers.GraphNode;
import com.mbajdowski.helpers.MazePainter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class MazeBuilder {

    private MazeProperties mp;
    private GraphNode[][] mazeGraph;
    private AnimatedGifEncoder age;
    private MazePainter mazePainter;
    private int notVisited;
    private Stack<GraphNode> stack;

    //----------------CONSTRUCTORS-----------------

    public MazeBuilder(MazeProperties mp){
        this.mp = mp;
        mazeGraph = new GraphNode[mp.getWidth()][mp.getHeight()];
        age = new AnimatedGifEncoder();
        if(mp.isInLoop()){
            age.setRepeat(0);
        }
        age.setDelay(mp.getSpeed());
        mazePainter = new MazePainter(
                mp.getHeight(),
                mp.getWidth(),
                mp.getStrokeSize(),
                mp.getColorOfMaze(),
                mp.getColorOfStartingPoints());
        mazePainter.addStartAndEnd();
        initializeGraph();
        notVisited = mp.getWidth()*mp.getHeight()-1;
        stack = new Stack<>();
    }

    //------------------PUBLIC-----------------

    public void generateMaze(){
        age.start(mp.getPath()+mp.getName()+".gif");
        age.addFrame(mazePainter.getFrame());
        GraphNode initialNode = mazeGraph[0][0];

        randomizedDFS(initialNode);
        age.finish();

        try {
            ImageIO.write(mazePainter.getFrame(), "bmp", new java.io.File(mp.getPath()+mp.getName()+".bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //------------------PRIVATE------------------

    private void randomizedDFS(GraphNode node) {
        if(!node.visited){
            age.addFrame(mazePainter.colorNode(node.x, node.y));
        }
        node.visited = true;
        while(notVisited>0) {
            List<GraphNode> notVisitedMates = new ArrayList<>();
            for (GraphNode mate : node.mates) {
                if (!mate.visited) {
                    notVisitedMates.add(mate);
                }
            }
            if(!notVisitedMates.isEmpty()){
                notVisited--;
                int randomNum = ThreadLocalRandom.current().nextInt(0, notVisitedMates.size());
                GraphNode randomMate = notVisitedMates.get(randomNum);
                stack.push(randomMate);
                age.addFrame(mazePainter.colorTransition(node.x, node.y, randomMate.x, randomMate.y));
                randomizedDFS(randomMate);
            }else{
                if(!stack.empty()){
                    GraphNode popped = stack.pop();
                    randomizedDFS(popped);
                }
            }
        }
    }

    private void initializeGraph(){
        for(int x = 0; x<mazeGraph.length;x++){
            for(int y = 0; y<mazeGraph[x].length;y++){
                mazeGraph[x][y] = new GraphNode();
                mazeGraph[x][y].x = x;
                mazeGraph[x][y].y = y;
            }
        }
        for(int x = 0; x<mazeGraph.length;x++){
            for(int y = 0; y<mazeGraph[x].length;y++){
                GraphNode n = mazeGraph[x][y];
                List<GraphNode> mates = n.mates;
                if (x > 0) {     // has west
                    mates.add(mazeGraph[x-1][y]);
                }
                if (x < mazeGraph.length - 1) { // has east
                    mates.add(mazeGraph[x+1][y]);
                }
                if (y > 0) {     // has north
                    mates.add(mazeGraph[x][y-1]);
                }
                if (y < mazeGraph[x].length - 1) { // has south
                    mates.add(mazeGraph[x][y+1]);
                }
            }
        }
    }

}
