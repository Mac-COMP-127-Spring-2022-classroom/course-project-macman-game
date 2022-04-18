// package macman;

// import edu.macalester.graphics.Rectangle;

// public class Wall implements GameElements { // extends rectanlge

// }

package macman;

import java.awt.Color;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

<<<<<<< HEAD
public class Wall extends GameElements {
    public Wall(double xPosition, double yPosition, double wallWidth, double wallHeight) {
        Rectangle wall = new Rectangle(xPosition, yPosition, wallWidth, wallHeight);

        this.graphics.add(wall);
        wall.setStrokeColor(Color.BLUE);
    }

=======
public class Wall extends Rectangle implements GameElements { 

    public Wall(double xPosition, double yPosition, double wallWidth, double wallHeight) {
        super(xPosition, yPosition, wallWidth, wallHeight);
        setFillColor(Color.LIGHT_GRAY);
        setStrokeColor(Color.BLACK);
    }
    
>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
    public boolean canMove() {
        return false;
    }

    public boolean isEnd() {
        return false;
    }
<<<<<<< HEAD
=======

    @Override
    public GraphicsObject getGraphics() {
        return this;
    }


>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
}
