package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Ghost extends GraphicsGroup {
    private Image ghostIcon;
    private int ghostRow;
    private int ghostCol;

    public Ghost(double ghostWidth, double ghostHeight, String ghostName, int ghostRow, int ghostCol) {
        super();
        ghostIcon = new Image("sprite-icons/" + ghostName + ".png");
        ghostIcon.setMaxWidth(ghostWidth);
        ghostIcon.setMaxHeight(ghostHeight);
        this.ghostRow = ghostRow;
        this.ghostCol = ghostCol;

        add(ghostIcon);
    }

    public int getGhostRow() {
        return ghostRow;
    }

    public int getGhostCol() {
        return ghostCol;
    }

    public void setGhostRow(int row) {
        ghostRow = row;
    }

    public void setGhostCol(int column) {
        ghostCol = column;
    }
}
