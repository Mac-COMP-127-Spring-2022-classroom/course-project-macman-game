package macman;

import java.awt.Color;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Cell {
    private GraphicsGroup graphics;
    private Rectangle square;
    private double size;
    
    public Cell(double size) {
        this.size = size;
        graphics = new GraphicsGroup();
        square = new Rectangle(0, 0, size, size);
<<<<<<< HEAD
        square.setStrokeColor(Color.BLACK); // change later
=======
        square.setStrokeColor(Color.BLACK); 
>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
        graphics.add(square);
        setPositions();
    }

    private void setPositions() {
    }

    public boolean isInBounds(Point point) {
        return this.getGraphics().testHit(point.getX(), point.getY());
    }

    public double getSize() {
        return square.getWidth();
    }

    public GraphicsGroup getGraphics () {
        return graphics;
    } 

    // public void setColor(int i) {
    //     if (colorInt < i) {
    //         colorInt = i;
    //         square.setFillColor(COLORS[i]);
    //     }

    // }

    // public void setColor(Color color) {
    //     square.setFillColor(color);
    // }
}
