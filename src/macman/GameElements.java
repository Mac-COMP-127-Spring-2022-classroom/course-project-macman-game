package macman;

import edu.macalester.graphics.GraphicsObject;

public interface GameElements {
    public boolean canMove();
    public boolean isEnd();
    public GraphicsObject getGraphics();
    
}
