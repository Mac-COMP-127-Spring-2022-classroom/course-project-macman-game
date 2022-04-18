package macman;

<<<<<<< HEAD
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
=======
import edu.macalester.graphics.GraphicsObject;

public interface GameElements {
    public boolean canMove();
    public boolean isEnd();
    public GraphicsObject getGraphics();
    
>>>>>>> d086afb35105a583656880a8793cfd1a88fbeaa9
}
