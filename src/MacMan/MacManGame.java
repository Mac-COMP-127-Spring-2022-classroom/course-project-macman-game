package macman;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 720;
    private Grid grid;
    private CanvasWindow canvas;
    private String[][] maze;
    private Player player;
    private Ghost blinky, pinky, inky, clyde;
    private int tracker = 0;


    public MacManGame() {
        canvas = new CanvasWindow("Mac-man!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        settingUpGame();
        player = new Player(20, 20);
        grid = new Grid(24, 24, 30, maze, player, blinky, pinky, inky, clyde);
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
        });

        canvas.animate(() -> {
            if (tracker % 17 == 0) {
                grid.moveGhost(blinky);
                grid.moveGhost(pinky);
                grid.moveGhost(inky);
                grid.moveGhost(clyde);
            }
            tracker++;
        });
    }

    private void settingUpGame() {
        generateMaze();
        createGhosts();
        canvas.draw();
    }

    private void generateMaze() {
        maze = new String[24][24];
        maze[0] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
        maze[1] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[2] = new String[] { "B", "C", "B", "B", "B", "B", "B", "C", "C", "B", "", "B", "C", "B", "B", "B", "C", "B", "B", "B", "B", "B", "C", "B" };
        maze[3] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "B", "B", "B", "C", "C", "C", "C", "C", "B", "C", "B" };
        maze[4] = new String[] { "B", "C", "B", "C", "B", "B", "B", "C", "C", "B", "B", "B", "C", "B", "B", "B", "C","B", "B", "B", "C", "B", "C", "B" };
        maze[5] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "C", "B", "C", "B" };
        maze[6] = new String[] { "B", "C", "B", "C", "B", "C", "C", "B", "B", "B", "B", "B", "C", "C", "C", "B", "B", "C", "C", "B", "C", "B", "C", "B" };
        maze[7] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[8] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B", "B", "B", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[9] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[10] = new String[] { "B", "B", "B", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B", "C", "C", "B", "B", "B", "B", "B" };
        maze[11] = new String[] { "", "", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "B", "", "", "", "" };
        maze[12] = new String[] { "", "", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C", "C", "B", "", "", "", "" };
        maze[13] = new String[] { "B", "B", "B", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B", "C", "C", "B", "B", "B", "B", "B" };
        maze[14] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[15] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B", "B", "B", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[16] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B" };
        maze[17] = new String[] { "B", "C", "B", "C", "B", "C", "C", "B", "B", "B", "B", "B", "C", "C", "C", "B", "B", "C", "C", "B", "C", "B", "C", "B" };
        maze[18] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "C", "B", "C", "B" };
        maze[19] = new String[] { "B", "C", "B", "C", "B", "B", "B", "C", "C", "B", "B", "B", "C", "B", "B", "B", "C", "B", "B", "B", "C", "B", "C", "B" };
        maze[20] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "B", "B", "B", "C", "C", "C", "C", "C", "B", "C", "B" };
        maze[21] = new String[] { "B", "C", "B", "B", "B", "B", "B", "C", "C", "B", "", "B", "C", "B", "B", "B", "C", "B", "B", "B", "B", "B", "C", "B" };
        maze[22] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B" };
        maze[23] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "B" };
    }

    private void createGhosts() {
        blinky = new Ghost(20, 20, "blinky", 6, 6);
        pinky = new Ghost(20, 20, "pinky", 3, 20);
        inky = new Ghost(20, 20, "inky", 20, 3);
        clyde = new Ghost(20, 20, "clyde", 22, 22);
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}