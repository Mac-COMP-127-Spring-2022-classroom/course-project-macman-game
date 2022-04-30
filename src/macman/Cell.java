package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Cell {
    private GraphicsGroup graphics;
    private Rectangle rectangle;
    private boolean isTraversable;
    private Coin coin;
    private Player player;

    public Cell(double size) {
        graphics = new GraphicsGroup();
        rectangle = new Rectangle(0, 0, size, size);
        graphics.add(rectangle);
        isTraversable = true;
    }

    public void setTraversable(boolean isTraversable) {
        this.isTraversable = isTraversable;
    }

    public boolean getTraversable() {
        return isTraversable;
    }

    public boolean isInBounds(Point point) {
        return getGraphics().testHit(point.getX(), point.getY());
    }

    public double getSize() {
        return rectangle.getWidth();
    }

    public GraphicsGroup getGraphics () {
        return graphics;
    }

    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        graphics.add(group);
    }

    public void removeGraphics() {
        graphics.removeAll();
    }

    public boolean removeCoin(){
        if (coin != null) {
            graphics.remove(coin);
            coin = null;
            return true;
        }
        return false;
    }
    
    public void addCoin(double size){
        coin = new Coin(size / 6, size / 6);
        addGraphics(coin);
    }
    
    public void removePlayer() {
        if (player != null) {
            graphics.remove(player);
        }
        player = null;
    }
    
    public void addPlayer(Player player) {
        this.player = player;
        addGraphics(player);
    }

    public void removeGhost(Ghost ghost) {
        graphics.remove(ghost);
    }
    
    public void addGhost(Ghost ghost) {
        addGraphics(ghost);
    }
}
