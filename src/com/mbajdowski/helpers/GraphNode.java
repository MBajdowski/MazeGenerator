package com.mbajdowski.helpers;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public List<GraphNode> mates;
    public boolean visited;
    public int x, y;

    public GraphNode(){
        mates = new ArrayList<>();
        visited = false;
    }
}
