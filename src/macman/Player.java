package macman;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Player extends GraphicsGroup {
    private Image playerIcon;

    public Player(double playerWidth, double playerHeight) {
        super();
        playerIcon = new Image("sprite-icons/macman.png");
        playerIcon.setMaxWidth(playerWidth);
        playerIcon.setMaxHeight(playerHeight);

        this.add(playerIcon);
    }
}
