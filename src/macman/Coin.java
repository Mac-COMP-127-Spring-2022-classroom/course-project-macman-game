package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

import java.awt.Color;

public class Coin extends GraphicsGroup {
    private Ellipse coin;

    /**
     * Creates a single coin within the canvas.
     * 
     * @param ballWidth  The width of the coin.
     * @param ballHeight The height of the coin.
     */
    public Coin(double ballWidth, double ballHeight) {
        super();
        coin = new Ellipse(0, 0, ballWidth, ballHeight);
        coin.setFillColor(Color.ORANGE);
        coin.setStrokeColor(Color.GREEN);
        this.add(coin);
    }
}
