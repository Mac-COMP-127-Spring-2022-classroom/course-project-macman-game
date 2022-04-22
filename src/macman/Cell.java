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
    private Ghost ghost;

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
        return this.getGraphics().testHit(point.getX(), point.getY());
    }

    public double getSize() {
        return rectangle.getWidth();
    }

    public GraphicsGroup getGraphics () {
        return graphics;
    }

    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        this.graphics.add(group);
    }

    public void removeGraphics() {
        this.graphics.removeAll();
    }

    public void removeCoin(){
        if (coin != null) {
            this.graphics.remove(coin);
        }
        coin = null;
    }
    
    public void addCoin(double size){
        coin = new Coin(size / 6, size / 6);
        this.addGraphics(coin);
    }
    
    public void removePlayer() {
        if (player != null) {
            this.graphics.remove(player);
        }
        this.player = null;
    }
    
    public void addPlayer(Player player) {
        this.player = player;
        this.addGraphics(player);
    }

    public void removeGhost() {
        if (ghost != null) {
            this.graphics.remove(ghost);
        }
        this.ghost = null;
    }
    
    public void addGhost(Ghost ghost) {
        this.ghost = ghost;
        this.addGraphics(ghost);
    }
}
