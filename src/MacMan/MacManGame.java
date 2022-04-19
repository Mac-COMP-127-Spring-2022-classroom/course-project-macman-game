package macman;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.KeyboardEvent;

public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;
    private Grid grid;
    private CanvasWindow canvas;
    private String[][] maze;
    private Player player;

    public MacManGame() {
        canvas = new CanvasWindow("mac-man", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        generateMaze();
        player = new Player(12, 12);
        grid = new Grid(24, 24, 30, maze, player);
        canvas.add(grid);

        canvas.onKeyDown(event -> {
            if (event.getKey().toString() == "RIGHT_ARROW") {
                grid.movePlayerRight();
            } else if (event.getKey().toString() == "LEFT_ARROW") {
                grid.movePlayerLeft();
            } else if (event.getKey().toString() == "UP_ARROW") {
                grid.movePlayerUp();
            } else if (event.getKey().toString() == "DOWN_ARROW") {
                grid.movePlayerDown();
            }
            System.out.println("KEY DOWN");
        });
    }  

    private void generateMaze() {
        maze = new String[24][24];
        maze[0] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
        maze[1] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[2] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[3] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[4] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[5] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[6] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[7] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[8] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[9] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[10] = new String[] { "B", "C", "C", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[11] = new String[] { "B", "C", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[12] = new String[] { "B", "C", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[13] = new String[] { "B", "C", "C", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[14] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[15] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[16] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[17] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[18] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[19] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[20] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[21] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[22] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[23] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}