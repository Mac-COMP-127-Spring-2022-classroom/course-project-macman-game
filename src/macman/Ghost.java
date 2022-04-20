package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Ghost extends GraphicsGroup {
    private Image ghostIcon;

    public Ghost(double ghostWidth, double ghostHeight, String ghostName) {
        super();
        ghostIcon = new Image("sprite-icons/" + ghostName + ".png");
        ghostIcon.setMaxWidth(ghostWidth);
        ghostIcon.setMaxHeight(ghostHeight);

        this.add(ghostIcon);
    }
}
