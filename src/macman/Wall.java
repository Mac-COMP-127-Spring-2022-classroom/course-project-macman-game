// package macman;

// import edu.macalester.graphics.Rectangle;

// public class Wall implements GameElements { // extends rectanlge

// }

package macman;

import java.awt.Color;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Wall extends GameElements {
    public Wall(double xPosition, double yPosition, double wallWidth, double wallHeight) {
        Rectangle wall = new Rectangle(xPosition, yPosition, wallWidth, wallHeight);

        this.graphics.add(wall);
        wall.setStrokeColor(Color.BLUE);
    }

    public boolean canMove() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }
}
