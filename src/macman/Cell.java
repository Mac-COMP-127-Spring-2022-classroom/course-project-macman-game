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
    private Ghost blinky, pinky, inky, clyde;

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
    
    public void addGhostBlinky(Ghost blinky) {
        this.blinky = blinky;
        this.addGraphics(blinky);
    }

    public void addGhostInky(Ghost inky) {
        this.inky = inky;
        this.addGraphics(inky);
    }

    public void addGhostClyde(Ghost clyde) {
        this.clyde = clyde;
        this.addGraphics(clyde);
    }

    public void addGhostPinky(Ghost pinky) {
        this.pinky = pinky;
        this.addGraphics(pinky);
    }
}
