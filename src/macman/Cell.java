package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Cell {
    private GraphicsGroup graphics;
    private Rectangle rectangle;
    private boolean isTraversable;

    public Cell(double size) {
        graphics = new GraphicsGroup();
        rectangle = new Rectangle(0, 0, size, size);
        graphics.add(rectangle);
        setPositions();
        isTraversable = true;
    }

    private void setPositions() {
    }

    public void setTraversable(boolean isTraversable) {
        this.isTraversable = isTraversable;
    }

    public boolean getTraversable() {
        return isTraversable;
    }

    public boolean isInBounds(Point point) {
        return this.getGraphics().testHit(point.getX(), point.getY());
    }

    public double getSize() {
        return rectangle.getWidth();
    }

    public GraphicsGroup getGraphics() {
        return graphics;
    }

    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        this.graphics.add(group);
    }

    public void removeGraphics() {
        this.graphics.removeAll();
    }
}
