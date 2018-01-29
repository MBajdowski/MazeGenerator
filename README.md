# MazeGenerator
This is a Java program which generates maze using randomized DFS (Depth-first search) algorithm. 
Also it produce maze in BMP format, as well as GIF animation presenting maze creation.

## Some words about DFS and maze creation
DFS is an alorighm used for trawersing through the graph and go through all possilble nodes starting from the initial one. 
There is serveral variations of DFS regarding te purpouse. In this project we are interested in maze creation and as well as maze resolving using ["_Randomized DFS_"](https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_backtracker). 

**Maze solving DFS**
1. Mark current node as visited 
2. If current node is the end of the maze  
   * End serch  
3. If the current node has any unvisited neighbours  
   * Choose randomly one of the unvisited neighbours  
   * Push the current node to the stack  
   * Make the chosen node the current cell  
   * Run recursively DFS  
4. Else if stack is not empty
   * Pop a node from the stack  
   * Make it the current node  
   * Run recursively DFS  
  
**Maze creating DFS** 
1. Mark current node as visited   
2. While there are unvisited nodes  
   1. If the current node has any unvisited neighbours  
      * Choose randomly one of the unvisited neighbours  
      * Remove wall between current node and chosen one   
      * Push the current node to the stack  
      * Make the chosen node the current cell  
      * Run recursively DFS  
   2. Else if stack is not empty    
      * Pop a node from the stack  
      * Make it the current node  
      * Run recursively DFS  

## Options
The MazeBuilder class trakes as a parameter MazeProperties which can customize generated maze. 
MazeProperites has following options to set:
1. **Height** - Number of the maze nodes in height _(10 is default)_
2. **Width** - Number of the maze nodes in width _(10 is default)_
3. **Strokesize** - Stroke size in pixels _(10 is default)_
4. **inLoop** - If animation should play in loop _(false is default)_
5. **Speed** - Time in 10 millis (1 = 10 millis) between frames in gif _(10 is default)_
6. **ColorOfMaze** - Color of the corridors _(white is default)_
7. **ColorOfTheStartingPoints** - Color of the start and end of the maze _(red is default)_
8. **Path** - Output directory _(program directory is default)_
9. **Name** - Name of the output files _("maze" is default)_

## Examples of usage
Deafult properties:

    MazeBuilder mb = new MazeBuilder(new MazeProperties());
    mb.generateMaze();

Customised maze:

    MazeProperties mp = new MazeProperties();
    mp.setHeight(20);
    mp.setWidth(30);
    mp.setStrokeSize(5);
    mp.setInLoop(true);
    mp.setSpeed(3);
    mp.setColorOfMaze(Color.GRAY);
    mp.setColorOfStartingPoints(Color.ORANGE);
    mp.setName("CustomMaze");
      
    MazeBuilder mb = new MazeBuilder(mp);
    mb.generateMaze();

## AnimatedGifEncoder
For gif creation I used [AnimatedGifEncoder](https://github.com/videlalvaro/gifsockets/blob/master/src/java/AnimatedGifEncoder.java) class which is free and opensource and may be used for any purpose, however, refer to the Unisys LZW patent for restrictions on use of the associated LZWEncoder class. Please forward any corrections to kweiner@fmsware.com. 
