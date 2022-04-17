package macman;

import java.awt.Color;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Wall extends Rectangle implements GameElements { 

    public Wall(double xPosition, double yPosition, double wallWidth, double wallHeight) {
        super(xPosition, yPosition, wallWidth, wallHeight);
        setFillColor(Color.LIGHT_GRAY);
        setStrokeColor(Color.BLACK);
    }
    
    public boolean canMove() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }

    @Override
    public GraphicsObject getGraphics() {
        return this;
    }


}
