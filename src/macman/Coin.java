package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

/**
 * Represents a single coin that will populate the maze for the player to collect.
 */
public class Coin extends GraphicsGroup {
    private Ellipse coin;

    /**
     * Creates an instance of a coin of a specified width and height.
     */
    public Coin(double ballWidth, double ballHeight) {
        super();
        coin = new Ellipse(0, 0, ballWidth, ballHeight);
        coin.setFillColor(Color.ORANGE);
        coin.setStrokeColor(Color.GREEN);
        this.add(coin);
    }
}
