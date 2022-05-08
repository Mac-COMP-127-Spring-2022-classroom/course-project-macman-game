package macman;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;

/**
 * The main class of the game of Mac-Man that handles the logic of the game.
 */
public class MacManGame {
    private static final int CANVAS_WIDTH = 720;
    private static final int CANVAS_HEIGHT = 750;
    private Grid grid;
    private CanvasWindow canvas;
    private HomeScreen screens;
    private String[][] maze;
    private Player player;
    private Ghost blinky, pinky, inky, clyde;
    private List<Ghost> ghosts;
    private int tracker;
    private GraphicsText gameStatus;
    private GraphicsText coinStatus;
    private GraphicsText coolDownMessage;
    private int numOfCoins;
    private boolean playingGame;

    /**
     * Initializes a game of Mac-Man, creating its main screen.
     */
    public MacManGame() {
        canvas = new CanvasWindow("Mac-man!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        screens = new HomeScreen(canvas, this);
        screens.homeScreen();
        keyControls();
        canvas.animate(() -> {
            animateGhosts();
        });
    }

    /**
     * Initializes all interactable game elements - the player, the ghosts, the grid and the coins - within the
     * game's playing screen.
     */
    public void playingScreen() {
        player = new Player(20, 20);
        ghosts = new ArrayList<>();
        createGhosts();
        numOfCoins = 310;
        settingUpGame();
        grid = new Grid(24, 24, 30, maze, player, ghosts, this);
        canvas.add(grid);
    }

    /**
     * Adds all static visual game elements - the maze, and the coin and lives labels - to the
     * playing screen.
     */
    private void settingUpGame() {
        generateMaze();
        playingGame = true;
        canvas.draw();
        createGameStatusLabel();
        createCoinStatusLabel();
    }

    /**
     * Continuously updates the ghosts' positions while checking for ghost/player interactions for each
     * movement.
     */
    private void animateGhosts() {
        if (playingGame) {
            if (tracker % 7 == 0) {
                grid.moveGhost(blinky);
                grid.moveGhost(pinky);
                grid.moveGhost(inky);
                grid.moveGhost(clyde);
            }
            tracker++;
            updateNumOfLives();
        }
    }

    /**
     * Moves the player based on the keyboard's arrow keys.
     */
    private void keyControls() {
        canvas.onKeyDown(event -> {
            if (event.getKey().toString() == "RIGHT_ARROW") {
                grid.movePlayerRight();
            } else if (event.getKey().toString() == "LEFT_ARROW") {
                grid.movePlayerLeft();
            } else if (event.getKey().toString() == "UP_ARROW") {
                grid.movePlayerUp();
            } else if (event.getKey().toString() == "DOWN_ARROW") {
                grid.movePlayerDown();
            } else {
                return;
            }
            animateGhosts();
        });
    }

    /**
     * Populates the grid with coins and walls to form the maze.
     */
    private void generateMaze() {
        maze = new String[24][24];
        maze[0] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
        maze[1] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "C", "C", "C", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[2] = new String[] { "B", "C", "B", "B", "B", "B", "B", "C", "C", "B", "", "B", "C", "B", "B", "B", "C",
            "B", "B", "B", "B", "B", "C", "B" };
        maze[3] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "B", "B", "B", "C",
            "C", "C", "C", "C", "B", "C", "B" };
        maze[4] = new String[] { "B", "C", "B", "C", "B", "B", "B", "C", "C", "B", "B", "B", "C", "B", "B", "B", "C",
            "B", "B", "B", "C", "B", "C", "B" };
        maze[5] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C",
            "C", "C", "B", "C", "B", "C", "B" };
        maze[6] = new String[] { "B", "C", "B", "C", "B", "C", "C", "B", "B", "B", "B", "B", "C", "C", "C", "B", "B",
            "C", "C", "B", "C", "B", "C", "B" };
        maze[7] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[8] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B", "B", "B", "C", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[9] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[10] = new String[] { "B", "B", "B", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B",
            "C", "C", "B", "B", "B", "B", "B" };
        maze[11] = new String[] { "", "", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C",
            "C", "B", "", "", "", "" };
        maze[12] = new String[] { "", "", "", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B", "B", "C",
            "C", "B", "", "", "", "" };
        maze[13] = new String[] { "B", "B", "B", "B", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "C", "B", "B",
            "C", "C", "B", "B", "B", "B", "B" };
        maze[14] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "B", "B", "C", "C", "C", "C", "B", "B", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[15] = new String[] { "B", "C", "C", "C", "C", "B", "C", "C", "C", "C", "C", "C", "B", "B", "B", "C", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[16] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "B",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[17] = new String[] { "B", "C", "B", "C", "B", "C", "C", "B", "B", "B", "B", "B", "C", "C", "C", "B", "B",
            "C", "C", "B", "C", "B", "C", "B" };
        maze[18] = new String[] { "B", "C", "B", "C", "B", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C", "C",
            "C", "C", "B", "C", "B", "C", "B" };
        maze[19] = new String[] { "B", "C", "B", "C", "B", "B", "B", "C", "C", "B", "B", "B", "C", "B", "B", "B", "C",
            "B", "B", "B", "C", "B", "C", "B" };
        maze[20] = new String[] { "B", "C", "B", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "B", "B", "B", "C",
            "C", "C", "C", "C", "B", "C", "B" };
        maze[21] = new String[] { "B", "C", "B", "B", "B", "B", "B", "C", "C", "B", "", "B", "C", "B", "B", "B", "C",
            "B", "B", "B", "B", "B", "C", "B" };
        maze[22] = new String[] { "B", "C", "C", "C", "C", "C", "C", "C", "C", "B", "", "B", "C", "C", "C", "C", "C",
            "C", "C", "C", "C", "C", "C", "B" };
        maze[23] = new String[] { "B", "B", "B", "B", "B", "B", "B", "B", "B", "B", "", "B", "B", "B", "B", "B", "B",
            "B", "B", "B", "B", "B", "B", "B" };
    }

    /**
     * Creates four ghosts and places them at their starting positions at the four corners of the maze.
     */
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

    /**
     * Creates a label that reflects the number of lives the player has to be displayed on the screen.
     */
    private void createGameStatusLabel() {
        gameStatus = new GraphicsText();
        gameStatus.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        gameStatus.setFillColor(Color.ORANGE);
        gameStatus.setText("Lives Left: " + player.getNumOfLives());
        gameStatus.setPosition(canvas.getWidth() * 0.8, canvas.getHeight() * 0.99);
        canvas.add(gameStatus);
    }

    /**
     * Creates a label that reflects the number of coin the player has left to collect to be displayed
     * on the screen.
     */
    private void createCoinStatusLabel() {
        coinStatus = new GraphicsText();
        coinStatus.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        coinStatus.setFillColor(Color.ORANGE);
        coinStatus.setText("Coins Left: " + numOfCoins);
        coinStatus.setPosition(canvas.getWidth() * 0.02, canvas.getHeight() * 0.99);
        canvas.add(coinStatus);
    }

    /**
     * Reduces the number of coins by one and changes the coin status label to reflect this.
     */
    public void updateNumOfCoins() {
        numOfCoins--;
        coinStatus.setText("Coins Left: " + numOfCoins);
        gameWon();
    }

    /**
     * If there is an interaction between a ghost and the player, reduces the number of lives of the
     * player by one and changes the lives status label to reflect this.
     */
    public void updateNumOfLives() {
        if (grid.playerGhostInteraction()) {
            player.setNumOfLives(player.getNumOfLives() - 1);
            changeLivesStatus();
        }
    }

    /**
     * Changes the lives status label based on the number of lives of the player, ending the game and
     * displaying that you lost if the number of lives is zero.
     */
    private void changeLivesStatus() {
        if (player.getNumOfLives() == 0) {
            screens.loseMessage();
            playingGame = false;
            screens.homeScreen();
        } else if (player.getNumOfLives() > 0) {
            gameStatus.setText("Lives Left: " + player.getNumOfLives());
            countdownMessage();
            canvas.draw();
            canvas.pause(3000);
            canvas.remove(coolDownMessage);
        }
    }

    /**
     * Creates a message that prompts the user to wait for three seconds until the next turn.
     */
    private void countdownMessage() {
        coolDownMessage = new GraphicsText();
        coolDownMessage.setFont(FontStyle.BOLD, canvas.getWidth() * 0.03);
        coolDownMessage.setFillColor(Color.RED);
        coolDownMessage.setText("Please wait 3 seconds!");
        coolDownMessage.setPosition(canvas.getWidth() * 0.35, canvas.getHeight() * 0.99);
        canvas.add(coolDownMessage);
    }

    /**
     * Displays that you won and ends the game if all the coins have been collected without losing all
     * three lives.
     */
    private void gameWon() {
        if (player.getNumOfLives() > 0 && numOfCoins == 0) {
            screens.winMessage();
            playingGame = false;
            screens.homeScreen();
        }
    }

    public static void main(String[] args) {
        new MacManGame();
    }
}