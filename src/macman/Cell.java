package macman;

import edu.macalester.graphics.GraphicsGroup;
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

    /**
     * Allows the ability to traverse to change based on the location of the player.
     * 
     * @param isTraversable A boolean that checks whether the player can continue moving or not.
     */
    public void setTraversable(boolean isTraversable) {
        this.isTraversable = isTraversable;
    }

    /**
     * Returns a boolean that is either true or false, and the outcome can determine whether the player
     * can continue moving or not.
     * 
     * @return
     */
    public boolean getTraversable() {
        return isTraversable;
    }

    /**
     * Returns a GraphicsGroup, indicating which graphic is in a particular cell within the grid.
     * 
     * @return
     */
    public GraphicsGroup getGraphics() {
        return graphics;
    }

    /**
     * Adds a particular graphic to be added into the GraphicsGroup, which will allow the given graphic
     * to be added onto the canvas.
     * 
     * @param group
     */
    public void addGraphics(GraphicsGroup group) {
        group.setCenter(rectangle.getCenter());
        graphics.add(group);
    }

    /**
     * Returns a boolean that states if there is a coin in a particular cell, then the coin will be
     * removed from the GraphicsGroup and be set to null. Afterwards, the method would return true;
     * however, if there are no coins in a cell, the method will return false.
     * 
     * @return
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
     * Allows the user to add a coin into a cell.
     * 
     * @param size The size of the coin
     */
    public void addCoin(double size) {
        coin = new Coin(size / 6, size / 6);
        addGraphics(coin);
    }

    /**
     * Allows the player to be removed from the cell as the player moves from one cell to another.
     */
    public void removePlayer() {
        if (player != null) {
            graphics.remove(player);
        }
        player = null;
    }

    /**
     * Allows the player to be added into a new cell.
     * 
     * @param player The player in which the user will be moving
     */
    public void addPlayer(Player player) {
        this.player = player;
        addGraphics(player);
    }

    /**
     * Allows the ghost to be removed from the canvas as the ghost moves from one cell to another
     * 
     * @param ghost One of the ghosts, which could be blinky, inky, pinky, or clyde.
     */
    public void removeGhost(Ghost ghost) {
        graphics.remove(ghost);
    }

    /**
     * Allows the opportunity to add a ghost into a new cell, especially as the ghost moves into a new
     * cell; that way, with the removeGhost and addGhost methods, we can see the ghosts shifting
     * positions within the canvas.
     * 
     * @param ghost One of the ghosts, which could be blinky, pinky, inky, or clyde.
     */
    public void addGhost(Ghost ghost) {
        addGraphics(ghost);
    }
}
