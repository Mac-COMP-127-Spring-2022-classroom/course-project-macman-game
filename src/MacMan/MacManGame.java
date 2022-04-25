package macman;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;

public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 750;
    private Grid grid;
    private CanvasWindow canvas;
    private String[][] maze;
    private Player player;
    private Ghost blinky, pinky, inky, clyde;
    private int tracker = 0;
    private GraphicsText gameStatus;
    private int numOfLives;


    public MacManGame() {
        canvas = new CanvasWindow("Mac-man!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        player = new Player(20, 20);
        numOfLives = 3;
        settingUpGame();
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

        updateNumOfLives();
    }

    private void settingUpGame() {
        generateMaze();
        createGhosts();
        createGameStatusLabel();
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

    private void createGameStatusLabel() {
        gameStatus = new GraphicsText();
        gameStatus.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        gameStatus.setFillColor(Color.GRAY);
        gameStatus.setText(numOfLives + " Lives Left");
        gameStatus.setPosition(canvas.getWidth() * 0.8, canvas.getHeight() * 0.99);
        canvas.add(gameStatus);
    }

    public void updateNumOfLives() {
        if (grid.playerGhostInteraction()) {
            numOfLives--;
            System.out.println(numOfLives);
            changeLivesStatus();
            canvas.draw();
        }
    }

    public void changeLivesStatus() {
        if (numOfLives == 0) {
            gameStatus.setText("YOU LOST");
        } else if (numOfLives == 1) {
            gameStatus.setText(numOfLives + " Life Left");
        } else if (numOfLives == 2) {
            gameStatus.setText(numOfLives + " Lives Left");
        }
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}