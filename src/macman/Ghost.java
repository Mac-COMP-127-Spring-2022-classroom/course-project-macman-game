package macman;

import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

/**
 * Represents a ghost that will move randomly through the maze as an obstacle for the player.
 */
public class Ghost extends GraphicsGroup {
    private Image ghostIcon;
    private int ghostRow;
    private int ghostCol;
    private int direction;
    private Random random;

    /**
     * Creates an instance of a ghost of a specified width, height, and name, that will be added onto
     * the maze in the specified row and column.
     * 
     * @param ghostWidth  The width of the ghost.
     * @param ghostHeight The height of the ghost.
     * @param ghostName   The name of the ghost.
     * @param ghostRow    The row in which the ghost is located.
     * @param ghostCol    The column in which the ghost is located.
     */
    public Ghost(double ghostWidth, double ghostHeight, String ghostName, int ghostRow, int ghostCol) {
        super();
        ghostIcon = new Image("sprite-icons/" + ghostName + ".png");
        ghostIcon.setMaxWidth(ghostWidth);
        ghostIcon.setMaxHeight(ghostHeight);
        this.ghostRow = ghostRow;
        this.ghostCol = ghostCol;
        random = new Random();
        direction = chooseRandomDirection();

        add(ghostIcon);
    }

    /**
     * Returns the row the ghost is currently in.
     */
    public int getGhostRow() {
        return ghostRow;
    }

    /**
     * Returns the column in which the ghost is currently in.
     */
    public int getGhostCol() {
        return ghostCol;
    }

    /**
     * Changes the row the ghost is situated in.
     * 
     * @param row The new row in which the ghost will be in.
     */
    public void setGhostRow(int row) {
        ghostRow = row;
    }

    /**
     * Changes the column the ghost is situated in.
     * 
     * @param column The new column in which the ghost will be in.
     */
    public void setGhostCol(int column) {
        ghostCol = column;
    }

    /**
     * Returns the direction, which is in the form of an integer, that the ghost is heading in.
     */
    public int getGhostDirection() {
        return direction;
    }

    /**
     * Sets the direction of the ghost to a new direction.
     */
    public void setGhostDirection(int newDirection) {
        direction = newDirection;
    }

    /**
     * Returns a random integer between 0 and 4 (0, 1, 2, or 3), which determines which direction the
     * ghost will be moving in.
     */
    public int chooseRandomDirection() {
        direction = random.nextInt(4);
        return direction;
    }
}
