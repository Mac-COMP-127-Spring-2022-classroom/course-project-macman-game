package macman;

import java.awt.Color;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

public class Wall extends GraphicsGroup {

    public Wall(double wallWidth, double wallHeight) {
        Rectangle wall = new Rectangle(0, 0, wallWidth, wallHeight);
        this.add(wall);
        wall.setStrokeColor(Color.BLUE);
    }
}
