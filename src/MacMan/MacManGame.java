package macman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Mac-Man.
 */
public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;
    private Grid grid;
    private List<Wall> walls;
    private CanvasWindow canvas;
    private Wall wall;
    private String[][] maze;
    private Player player;

    public MacManGame() {
        walls = new ArrayList<>();
        canvas = new CanvasWindow("mac-man", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        generateMaze();
        grid = new Grid(9, 10, 80, maze, canvas);
        canvas.add(grid);
        player = new Player(0, 0, 0, 0);
        

        canvas.onKeyDown(event -> {
            player.movePlayer(event);
        });
    }

    private void generateMaze() {
        maze = new String[9][10];
        maze[0] = new String[]{"C", "C", "X", "C", "X", "C", "X", "X", "C", "C"};
        maze[1] = new String[]{"C", "C", "X", "X", "C", "X", "X", "X", "X", "X"};
        maze[2] = new String[]{"C", "X", "X", "X", "X", "X", "X", "X", "X", "X"};
        maze[3] = new String[]{"C", "X", "X", "X", "X", "C", "P", "X", "X", "X"};
        maze[4] = new String[]{"C", "C", "X", "X", "X", "X", "X", "X", "X", "X"};
        maze[5] = new String[]{"X", "C", "C", "X", "X", "X", "X", "X", "X", "X"};
        maze[6] = new String[]{"X", "X", "C", "X", "X", "X", "X", "X", "X", "X"};
        maze[7] = new String[]{"C", "X", "C", "X", "C", "X", "X", "X", "X", "X"};
        maze[8] = new String[]{"X", "X", "C", "C", "X", "X", "X", "X", "X", "X"};
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}