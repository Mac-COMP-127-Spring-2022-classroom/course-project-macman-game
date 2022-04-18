package macman;

import edu.macalester.graphics.GraphicsGroup;

public abstract class GameElements {
    GraphicsGroup graphics = new GraphicsGroup();

    public abstract boolean canMove();
    public abstract boolean isEnd();

    public void setGraphics(GraphicsGroup gGroup) {
        this.graphics = gGroup;
    }

    public GraphicsGroup getGraphics() {
        return graphics;
    }
}
