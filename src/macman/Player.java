package macman;

import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.events.KeyboardEvent;

import java.awt.Color;

public class Player extends Ellipse implements GameElements{
    private Ellipse player;
    
    public Player(double xPosition, double yPosition, double playerWidth, double playerHeight) {
        super(xPosition, yPosition, playerWidth, playerHeight);
        setFillColor(Color.BLUE);
        setStrokeColor(Color.BLUE);
    }
    
    public void movePlayer(KeyboardEvent event) {
        if (event.getKey().toString().equals("RIGHT_ARROW")) System.out.println("Right pressed");
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
