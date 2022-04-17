package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import java.awt.Color;

public class Coin extends Ellipse implements GameElements{
    private Ellipse coin;

    public Coin(double xPosition, double yPosition, double ballWidth, double ballHeight) {
        super(xPosition, yPosition, ballWidth, ballHeight);
        setFillColor(Color.PINK);
        setStrokeColor(Color.PINK);
    }

    public boolean canMove() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }

    public GraphicsObject getGraphics() {
        return this;
    }
    
}
