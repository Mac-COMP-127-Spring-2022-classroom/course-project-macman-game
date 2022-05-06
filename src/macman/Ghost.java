package macman;

import java.util.Random;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Ghost extends GraphicsGroup {
    private Image ghostIcon;
    private int ghostRow;
    private int ghostCol;
    private int direction;
    private Random random;

    /**
     * Creates each ghost that will be added onto the canvas.
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
     * Returns the location of the ghost in terms of which row the ghost is situated in.
     * 
     * @return
     */
    public int getGhostRow() {
        return ghostRow;
    }

    /**
     * Returns the column location in which the ghost is situated in.
     * 
     * @return
     */
    public int getGhostCol() {
        return ghostCol;
    }

    /**
     * Allows the row in which the ghost is located in to change.
     * 
     * @param row The new row in which the ghost will be in.
     */
    public void setGhostRow(int row) {
        ghostRow = row;
    }

    /**
     * Allows the column in which the ghost is located in to change.
     * 
     * @param column The new column in which the ghost will be in.
     */
    public void setGhostCol(int column) {
        ghostCol = column;
    }

    /**
     * Returns the direction, which is in the form of an integer, that the ghost is heading in.
     * 
     * @return
     */
    public int getGhostDirection() {
        return direction;
    }

    /**
     * Allows the direction of the ghost to change as the ghost moves in random directions within the
     * canvas.
     * 
     * @param newDirection The new direction in which the ghost will be heading in.
     */
    public void setGhostDirection(int newDirection) {
        direction = newDirection;
    }

    /**
     * Returns an integer that provides a random number between 0 and 4 (0, 1, 2, or 3), which
     * determines which direction the ghost will be moving in.
     * 
     * @return
     */
    public int chooseRandomDirection() {
        direction = random.nextInt(4);
        return direction;
    }
}
