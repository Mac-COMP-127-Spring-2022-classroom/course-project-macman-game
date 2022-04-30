package macman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 750;
    private Grid grid;
    private CanvasWindow canvas;
    private String[][] maze;
    private Player player;
    private Ghost blinky, pinky, inky, clyde;
    private List<Ghost> ghosts = new ArrayList<>();
    private int tracker = 0;
    private GraphicsText gameStatus;
    private GraphicsText coinStatus;
    private GraphicsText coolDownMessage;
    private int count = 0;
    private int numOfCoins = 310;


    public MacManGame() {
        canvas = new CanvasWindow("Mac-man!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        player = new Player(20, 20);
        settingUpGame();
        grid = new Grid(24, 24, 30, maze, player, ghosts);
        canvas.add(grid);
        canvas.animate(() -> {
            if (tracker % 10 == 0) {
                for (Ghost ghost : ghosts) {
                    grid.moveGhost(ghost);
                }
            }
            tracker++;
            changingPlayerPositions();
            updateNumOfLives();
            updateNumOfCoins();
        });

    }
    private void changingPlayerPositions() {
        if (canvas.getKeysPressed().contains(Key.RIGHT_ARROW)) {
            count++;
            if (count == 4) {
                grid.movePlayerRight();
                count = 0;
            }
        } else if (canvas.getKeysPressed().contains(Key.LEFT_ARROW)) {
            count++;
            if (count == 4) {
                grid.movePlayerLeft();
                count = 0;
            }
        } else if (canvas.getKeysPressed().contains(Key.UP_ARROW)) {
            count++;
            if (count == 4) {
                grid.movePlayerUp();
                count = 0;
            }
        } else if (canvas.getKeysPressed().contains(Key.DOWN_ARROW)) {
            count++;
            if (count == 4) {
                grid.movePlayerDown();
                count = 0;
            }
        }
    }

    private void settingUpGame() {
        generateMaze();
        createGhosts();
        createGameStatusLabel();
        createCoinStatusLabel();
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
        ghosts.add(blinky);
        pinky = new Ghost(20, 20, "pinky", 3, 20);
        ghosts.add(pinky);
        inky = new Ghost(20, 20, "inky", 20, 3);
        ghosts.add(inky);
        clyde = new Ghost(20, 20, "clyde", 22, 22);
        ghosts.add(clyde);
    }

    private void createGameStatusLabel() {
        gameStatus = new GraphicsText();
        gameStatus.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        gameStatus.setFillColor(Color.ORANGE);
        gameStatus.setText("Lives Left: " + player.getNumOfLives());
        gameStatus.setPosition(canvas.getWidth() * 0.8, canvas.getHeight() * 0.99);
        canvas.add(gameStatus);
    }

    private void createCoinStatusLabel() {
        coinStatus = new GraphicsText();
        coinStatus.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        coinStatus.setFillColor(Color.ORANGE);
        coinStatus.setText("Coins Left: " + numOfCoins);
        coinStatus.setPosition(canvas.getWidth() * 0.02, canvas.getHeight() * 0.99);
        canvas.add(coinStatus);
    }

    private void updateNumOfCoins() {
        if (grid.playerCoinInteraction()) {
            numOfCoins--;
            coinStatus.setText("Coins Left: " + numOfCoins);
            gameWon();
        }
    }

    public void updateNumOfLives() {
        if (grid.playerGhostInteraction()) {
            player.setNumOfLives(player.getNumOfLives() - 1);
            changeLivesStatus();
        }
    }

    private void changeLivesStatus() {
        if (player.getNumOfLives() == 0) {
            gameStatus.setText("YOU LOSE");
            pauseGame();
            canvas.closeWindow();
        } else if (player.getNumOfLives() > 0) {
            gameStatus.setText("Lives Left: " + player.getNumOfLives());
            countdownMessage();
            pauseGame();
            canvas.remove(coolDownMessage);
        }
    }

    private void countdownMessage() {
        coolDownMessage = new GraphicsText();
        coolDownMessage.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        coolDownMessage.setFillColor(Color.RED);
        coolDownMessage.setText("Please wait 3 seconds!");
        coolDownMessage.setPosition(canvas.getWidth() * 0.35, canvas.getHeight() * 0.99);
        canvas.add(coolDownMessage);
    }

    private void gameWon() {
        if (player.getNumOfLives() > 0 && numOfCoins == 0) {
            gameStatus.setText("YOU WIN");
            pauseGame();
            canvas.closeWindow();
        }
    }

    private void pauseGame() {
        canvas.draw();
        canvas.pause(3000);
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}