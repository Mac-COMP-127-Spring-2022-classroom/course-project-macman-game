package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

/**
 * Represents the Mac-man, or the player icon that the player will control to move around the maze.
 */
public class Player extends GraphicsGroup {
    private Image playerIcon;
    private int numOfLives;

    /**
     * Constructs a player of a specified width/height and number of lives.
     */
    public Player(double playerWidth, double playerHeight) {
        super();
        playerIcon = new Image("sprite-icons/macman.png");
        playerIcon.setMaxWidth(playerWidth);
        playerIcon.setMaxHeight(playerHeight);
        numOfLives = 3;

        this.add(playerIcon);
    }

    /**
     * Returns the current number of lives left for the player.
     */
    public int getNumOfLives() {
        return numOfLives;
    }

    /***
     * Changes the current number of lives to the inputted new number of lives left.
     */
    public void setNumOfLives(int newLives) {
        numOfLives = newLives;
    }
}
