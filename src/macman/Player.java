package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Player extends GraphicsGroup {
    private Image playerIcon;
    private int numOfLives;

    public Player(double playerWidth, double playerHeight) {
        super();
        playerIcon = new Image("sprite-icons/macman.png");
        playerIcon.setMaxWidth(playerWidth);
        playerIcon.setMaxHeight(playerHeight);
        numOfLives = 3;

        this.add(playerIcon);
    }

    // get player position
    // check if ghost is also in that cell
    // if yes, then remove player
    // add player to starting point
    // reduce no of lives by 1 (call method - checks no of lives, if 0, ends game)
    // else, do nothing

    public int getNumOfLives() {
        return numOfLives;
    }

    public void setNumOfLives(int newLives) {
        numOfLives = newLives;
    }}
