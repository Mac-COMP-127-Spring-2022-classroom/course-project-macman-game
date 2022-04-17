package macman;

import java.awt.Color;

import edu.macalester.graphics.Rectangle;

public class Coin extends Rectangle implements GameElements {

    private static final Color COIN_COLOR = Color.WHITE;
    private static final int COIN_RADIUS = 5;

    public Coin(double centerX, double centerY) {
        super(centerX, centerY, 2*COIN_RADIUS, 2*COIN_RADIUS);
        this.setFillColor(COIN_COLOR);
    }
    
}
