package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Represents a single cell in the maze's grid.
 */
public class Cell {
    private GraphicsGroup graphics;
    private Rectangle rectangle;
    private boolean isTraversable;
    private Coin coin;
    private Player player;

    /**
     * Constructs an instance of a cell that is a square of a speicifed width/height.
     */
    public Cell(double size) {
        graphics = new GraphicsGroup();
        rectangle = new Rectangle(0, 0, size, size);
        graphics.add(rectangle);
        isTraversable = true;
    }

    /**
     * Checks if an object (whether it be player or ghost) can enter the cell.
     * 
     * @return true if it can, false if it cannot.
     */
    public boolean getTraversable() {
        return isTraversable;
    }

    /**
     * Changes whether or not an object can enter the cell based on the inputted value.
     */
    public void setTraversable(boolean isTraversable) {
        this.isTraversable = isTraversable;
    }

    /**
     * Returns the graphics in the cell.
     */
    public GraphicsGroup getGraphics() {
        return graphics;
    }

    /**
     * Adds a particular graphic to be added into the GraphicsGroup.
     */
    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        graphics.add(group);
    }

    /**
     * Checks if there is a coin in the cell, and removes it from the cell if there is.
     * 
     * @return true once a coin has been removed from the cell, or false if there is no coin to remove.
     */
    public boolean removeCoin() {
        if (coin != null) {
            graphics.remove(coin);
            coin = null;
            return true;
        }
        return false;
    }

    /**
     * Adds a coin of a certain size to the cell.
     */
    public void addCoin(double size) {
        coin = new Coin(size / 6, size / 6);
        addGraphics(coin);
    }

    /**
     * Removes the player from the cell.
     */
    public void removePlayer() {
        if (player != null) {
            graphics.remove(player);
        }
        player = null;
    }

    /**
     * Adds the player to the cell.
     */
    public void addPlayer(Player player) {
        this.player = player;
        addGraphics(player);
    }

    /**
     * Removes the ghost from the cell.
     */
    public void removeGhost(Ghost ghost) {
        graphics.remove(ghost);
    }

    /**
     * Adds the specified ghost to the cell.
     */
    public void addGhost(Ghost ghost) {
        addGraphics(ghost);
    }
}
