// package macman;

// import java.awt.Color;

// import edu.macalester.graphics.Rectangle;

// public class Coin extends Rectangle implements GameElements {

//     private static final Color COIN_COLOR = Color.WHITE;
//     private static final int COIN_RADIUS = 5;

//     public Coin(double centerX, double centerY) {
//         super(centerX, centerY, 2*COIN_RADIUS, 2*COIN_RADIUS);
//         this.setFillColor(COIN_COLOR);
//     }
    
// }


package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;

public class Coin extends GameElements {
    private Ellipse coin;
    
    public Coin(double xPosition, double yPosition, double ballWidth, double ballHeight) {
        Ellipse coin = new Ellipse(xPosition, yPosition, ballWidth, ballHeight);
        graphics.add(coin);
        coin.setFillColor(Color.PINK);
        coin.setStrokeColor(Color.PINK);
    }
    public boolean canMove() {
        return false;
    }
    public boolean isEnd() {
        return false;
    }
}
